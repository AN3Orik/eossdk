package host.anzo.eossdk.eosex;

import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOS_AntiCheatClient_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults.EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults.EOS_AntiCheatClient_OnMessageToServerCallbackInfo;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_AuthExpirationCallbackInfo;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_CreateUserCallbackInfo;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_LoginCallbackInfo;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_AddNotifyAuthExpirationOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CreateUserOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public @Getter abstract class AEOSClient extends AEOSBase<EOSClientOptions> {
	private EOS_AntiCheatClient_Interface antiCheatClient;

	private EOS_NotificationId authExpirationNotificationId;
	private EOS_NotificationId messageToServerNotificationId;
	private EOS_NotificationId clientIntegrityViolatedNotificationId;

	private EOS_ProductUserId productUserId;

	@Override
	public AEOSClient start(EOSClientOptions options) throws EOSException {
		super.start(options);

		if (options.isUseEpicAuthentication()) {
			// TODO: Implement Auth* logic
			final EOS_Auth_Interface authInterface = platform.getAuthInterface();
		}
		else {
			platform.getConnectInterface().login(getConnectLoginOptions(), Pointer.NULL, this::onConnectLogin);
		}
		return this;
	}

	protected EOS_Connect_LoginOptions getConnectLoginOptions() {
		return null;
	}

	private void onConnectLogin(@NotNull EOS_Connect_LoginCallbackInfo data) {
		if (data.ResultCode.isSuccess()) {
			log.info("EOS_Connect_Login completed with ProductUserId: {}", data.LocalUserId.toString());
			onConnectLoginComplete(data.ResultCode, data.LocalUserId);
		}
		else if (data.ResultCode == EOS_EResult.EOS_InvalidUser) {
			log.warn("EOS_Connect_Login failed with result={}. Trying to create new user...", data.ResultCode);

			final EOS_Connect_CreateUserOptions createUserOptions = new EOS_Connect_CreateUserOptions();
			if (data.ContinuanceToken != null) {
				createUserOptions.ContinuanceToken = data.ContinuanceToken;
			}

			// NOTE: We're not deleting the received context because we're passing it down to another SDK call
			platform.getConnectInterface().createUser(createUserOptions, data.ClientData, this::onCreateUser);
		}
		else {
			onConnectLoginFailed(data.ResultCode);
		}
	}

	private void onCreateUser(@NotNull EOS_Connect_CreateUserCallbackInfo data) {
		if (data.ResultCode.isSuccess()) {
			log.info("EOS_Connect_CreateUser completed with ProductUserId: {}, Result: {}", data.LocalUserId.toString(), data.ResultCode);
			onConnectLoginComplete(data.ResultCode, data.LocalUserId);
		}
		else {
			onConnectLoginFailed(data.ResultCode);
		}
	}

	protected void onConnectLoginFailed(EOS_EResult result) {
		log.error("Connect to services failed with error: {}", result);
	}

	protected void onConnectLoginComplete(EOS_EResult result, EOS_ProductUserId productUserId) {
		this.productUserId = productUserId;

		this.authExpirationNotificationId = platform.getConnectInterface().addNotifyAuthExpiration(new EOS_Connect_AddNotifyAuthExpirationOptions(), null, this::onAuthExpiration);

		if (options.isAntiCheatEnabled()) {
			antiCheatClient = platform.getAntiCheatClientInterface();
			if (antiCheatClient == null) {
				throw new RuntimeException("Failed to getAntiCheatClientInterface");
			}

			switch (options.getAntiCheatMode()) {
				case EOS_ACCM_ClientServer:
					messageToServerNotificationId = antiCheatClient.addNotifyMessageToServer(null, this::onMessageToServer);
					if (messageToServerNotificationId == EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
						throw new RuntimeException("Failed to addNotifyMessageToServer");
					}

					clientIntegrityViolatedNotificationId = antiCheatClient.addNotifyClientIntegrityViolated(null, this::onClientIntegrityViolated);
					if (clientIntegrityViolatedNotificationId == EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
						throw new RuntimeException("Failed to addNotifyClientIntegrityViolated");
					}
					break;
				case EOS_ACCM_PeerToPeer:
					throw new UnsupportedOperationException("Peer2Peer mode isn't implemented");
			}

			final EOS_EResult beginSessionResult = antiCheatClient.beginSession(productUserId, options.getAntiCheatMode());
			if (!beginSessionResult.isSuccess()) {
				throw new RuntimeException("Failed to anti-cheat beginSession: " + beginSessionResult);
			}
		}
	}

	private void onAuthExpiration(@NotNull EOS_Connect_AuthExpirationCallbackInfo authExpirationCallbackInfo) {
		platform.getConnectInterface().login(getConnectLoginOptions(), authExpirationCallbackInfo.ClientData, this::onConnectLogin);
	}

	@Override
	public void shutdown() {
		if (authExpirationNotificationId != null) {
			platform.getConnectInterface().removeNotifyAuthExpiration(authExpirationNotificationId);
		}
		if (antiCheatClient != null) {
			switch (options.getAntiCheatMode()) {
				case EOS_ACCM_ClientServer:
					if (messageToServerNotificationId != EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
						antiCheatClient.removeNotifyMessageToServer(messageToServerNotificationId);
					}
					if (clientIntegrityViolatedNotificationId != EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
						antiCheatClient.removeNotifyClientIntegrityViolated(clientIntegrityViolatedNotificationId);
					}
					break;
				case EOS_ACCM_PeerToPeer:
					throw new UnsupportedOperationException("Peer2Peer mode isn't implemented");
			}
			final EOS_EResult endSessionResult = antiCheatClient.endSession();
			if (!endSessionResult.isSuccess()) {
				throw new RuntimeException("Failed to anti-cheat endSession: " + endSessionResult);
			}
		}
		super.shutdown();
	}

	/**
	 * Event happens when client module wants to send EAC data to server-side anti-cheat
	 * @param callbackInfo callback with EAC data
	 */
	protected void onMessageToServer(@NotNull EOS_AntiCheatClient_OnMessageToServerCallbackInfo callbackInfo) {
	}

	/**
	 * Event happens when client module detected any integrity violation
	 * @param callbackInfo callback info with integrity violation data
	 */
	protected void onClientIntegrityViolated(EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo callbackInfo) {
	}
}