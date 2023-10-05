package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOS_AntiCheatServer_Interface;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnMessageToClientCallbackInfo;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientAction;
import host.anzo.eossdk.eos.sdk.anticheat.common.options.EOS_AntiCheatCommon_SetClientDetailsOptions;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_BeginSessionOptions;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_RegisterClientOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public abstract class AEOSServer extends AEOSBase<EOSServerOptions> {
	private EOS_AntiCheatServer_Interface antiCheatServer;
	private EOS_NotificationId messageToClientNotificationId;
	private EOS_NotificationId clientActionRequiredNotificationId;
	private EOS_NotificationId clientAuthStatusChangedNotificationId;

	@Override
	public AEOSServer start(EOSServerOptions options) throws EOSException {
		super.start(options);

		if (options.isAntiCheatEnabled()) {
			antiCheatServer = platform.getAntiCheatServerInterface();
			if (antiCheatServer == null) {
				throw new RuntimeException("Failed to getAntiCheatServerInterface");
			}

			messageToClientNotificationId = antiCheatServer.addNotifyMessageToClient(null, this::onMessageToClient);
			if (!messageToClientNotificationId.isValid()) {
				throw new RuntimeException("Failed to addNotifyMessageToClient");
			}

			clientActionRequiredNotificationId = antiCheatServer.addNotifyClientActionRequired(null, this::onClientActionRequired);
			if (!clientActionRequiredNotificationId.isValid()) {
				throw new RuntimeException("Failed to addNotifyClientActionRequired");
			}

			clientAuthStatusChangedNotificationId = antiCheatServer.addNotifyClientAuthStatusChanged(null, this::onClientAuthStatusChanged);
			if (!clientAuthStatusChangedNotificationId.isValid()) {
				throw new RuntimeException("Failed to addNotifyClientAuthStatusChanged");
			}

			final EOS_EResult beginSessionResult = antiCheatServer.beginSession(new EOS_AntiCheatServer_BeginSessionOptions(options));
			if (!beginSessionResult.isSuccess()) {
				throw new RuntimeException("Failed to anti-cheat beginSession: " + beginSessionResult);
			}
		}
		return this;
	}

	@Override
	public void shutdown() {
		if (antiCheatServer != null) {
			if (messageToClientNotificationId.isValid()) {
				antiCheatServer.removeNotifyMessageToClient(messageToClientNotificationId);
			}
			if (clientActionRequiredNotificationId.isValid()) {
				antiCheatServer.removeNotifyClientActionRequired(clientActionRequiredNotificationId);
			}
			if (clientAuthStatusChangedNotificationId.isValid()) {
				antiCheatServer.removeNotifyClientAuthStatusChanged(clientAuthStatusChangedNotificationId);
			}
		}
		super.shutdown();
	}

	public EOS_EResult onNetworkClientConnected(@NotNull AEOSNetworkClient antiCheatClient) {
		return registerClient(antiCheatClient);
	}

	private EOS_EResult registerClient(@NotNull AEOSNetworkClient antiCheatClient) {
		EOS_EResult result = antiCheatServer.registerClient(new EOS_AntiCheatServer_RegisterClientOptions(antiCheatClient));
		if (!result.isSuccess()) {
			log.error("RegisterClient failed for client=[{}] with error=[{}]", antiCheatClient, result);
			return result;
		}

		result = antiCheatServer.setClientDetails(new EOS_AntiCheatCommon_SetClientDetailsOptions(antiCheatClient));
		if (!result.isSuccess()) {
			log.error("SetClientDetails failed for client=[{}] with error=[{}]", antiCheatClient, result);
			return result;
		}
		return EOS_EResult.EOS_Success;
	}

	public EOS_EResult onNetworkClientDisconnected(@NotNull AEOSNetworkClient networkClient) {
		final EOS_EResult result = antiCheatServer.unregisterClient(networkClient);
		if (!result.isSuccess()) {
			log.error("RegisterClient failed for client=[{}] with error=[{}]", networkClient, result);
			return result;
		}
		return EOS_EResult.EOS_Success;
	}

	/**
	 * @param connectionId connection ID
	 * @return network client by unique connection ID
	 */
	public abstract AEOSNetworkClient getNetworkClient(long connectionId);

	/**
	 * @param handle network client handle
	 * @return registered network client by handle
	 */
	private AEOSNetworkClient getNetworkClient(@NotNull EOS_AntiCheatCommon_ClientHandle handle) {
		return getNetworkClient(handle.getValue());
	}

	/**
	 * Notify the Anti-Cheat client with message server want to send
	 * @param callbackInfo info about a client and data to send
	 */
	protected void onMessageToClient(@NotNull EOS_AntiCheatCommon_OnMessageToClientCallbackInfo callbackInfo) throws EOSException {
		final AEOSNetworkClient antiCheatClient = getNetworkClient(callbackInfo.ClientHandle);
		if (antiCheatClient != null) {
			final ByteBuffer data = callbackInfo.getByteBuffer();
			if (options.isEnableNetworkProtection()) {
				final int protectMessageLength = antiCheatServer.getProtectMessageOutputLength(data.capacity());
				if (protectMessageLength > 0) {
					final ByteBuffer encryptedData = antiCheatServer.protectMessage(callbackInfo.ClientHandle, data.array(), protectMessageLength);
					antiCheatClient.sendEacData(encryptedData);
				}
			}
			else {
				antiCheatClient.sendEacData(data);
			}
		}
	}

	/**
	 * Event happens when Anti-Cheat interface wants to apply specified action to the game client
	 * @param callbackInfo info about a client and action to apply
	 */
	protected void onClientActionRequired(@NotNull EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo callbackInfo) {
		final AEOSNetworkClient networkClient = getNetworkClient(callbackInfo.ClientHandle);
		if (networkClient != null) {
			if (callbackInfo.ClientAction == EOS_EAntiCheatCommonClientAction.EOS_ACCCA_RemovePlayer) {
				networkClient.close(callbackInfo.ActionReasonCode, callbackInfo.ActionReasonDetailsString);
			}
		}
	}

	/**
	 * Event happens when Anti-Cheat changed auth status for the connected client
	 * @param callbackInfo info about client and auth status change data
	 */
	protected void onClientAuthStatusChanged(EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo callbackInfo) {
	}
}