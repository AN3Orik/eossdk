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
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_ProtectMessageOptions;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_RegisterClientOptions;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_UnregisterClientOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	private final Map<EOS_AntiCheatCommon_ClientHandle, IEOSNetworkClient> networkClients = new ConcurrentHashMap<>();

	@Override
	public AEOSServer start(EOSServerOptions options) throws EOSException {
		super.start(options);

		if (options.isAntiCheatEnabled()) {
			antiCheatServer = platform.getAntiCheatServerInterface();
			if (antiCheatServer == null) {
				throw new RuntimeException("Failed to getAntiCheatServerInterface");
			}

			messageToClientNotificationId = antiCheatServer.addNotifyMessageToClient(null, this::onMessageToClient);
			if (messageToClientNotificationId == EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
				throw new RuntimeException("Failed to addNotifyMessageToClient");
			}

			clientActionRequiredNotificationId = antiCheatServer.addNotifyClientActionRequired(null, this::onClientActionRequired);
			if (clientActionRequiredNotificationId == EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
				throw new RuntimeException("Failed to addNotifyClientActionRequired");
			}

			clientAuthStatusChangedNotificationId = antiCheatServer.addNotifyClientAuthStatusChanged(null, this::onClientAuthStatusChanged);
			if (clientAuthStatusChangedNotificationId == EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
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
			if (messageToClientNotificationId != EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
				antiCheatServer.removeNotifyMessageToClient(messageToClientNotificationId);
			}
			if (clientActionRequiredNotificationId != EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
				antiCheatServer.removeNotifyClientActionRequired(clientActionRequiredNotificationId);
			}
			if (clientAuthStatusChangedNotificationId != EOS_NotificationId.EOS_INVALID_NOTIFICATIONID) {
				antiCheatServer.removeNotifyClientAuthStatusChanged(clientAuthStatusChangedNotificationId);
			}
		}
		super.shutdown();
	}

	public void addNetworkClient(@NotNull IEOSNetworkClient antiCheatClient) {
		if (networkClients.containsKey(antiCheatClient.getHandle())) {
			log.error("Client [{}] already registered.", antiCheatClient);
			return;
		}

		final EOS_AntiCheatServer_RegisterClientOptions registerClientOptions = new EOS_AntiCheatServer_RegisterClientOptions(antiCheatClient);
		EOS_EResult result = antiCheatServer.registerClient(registerClientOptions);
		if (!result.isSuccess()) {
			log.error("RegisterClient failed for client=[{}] with error=[{}]", antiCheatClient, result);
			antiCheatClient.close("RegisterClient failed");
			return;
		}

		final EOS_AntiCheatCommon_SetClientDetailsOptions setClientDetailsOptions = new EOS_AntiCheatCommon_SetClientDetailsOptions(antiCheatClient);
		result = antiCheatServer.setClientDetails(setClientDetailsOptions);
		if (!result.isSuccess()) {
			log.error("SetClientDetails failed for client=[{}] with error=[{}]", antiCheatClient, result);
			antiCheatClient.close("SetClientDetails failed");
			return;
		}
		networkClients.put(antiCheatClient.getHandle(), antiCheatClient);
		onNetworkClientAdded(antiCheatClient);
	}

	private IEOSNetworkClient getNetworkClient(@NotNull EOS_AntiCheatCommon_ClientHandle clientHandle) {
		return networkClients.getOrDefault(clientHandle, null);
	}

	private boolean removeNetworkClient(@NotNull EOS_AntiCheatCommon_ClientHandle clientHandle) {
		return networkClients.remove(clientHandle) != null;
	}

	/**
	 * Event called when a client successfully registered at Anti-Cheat backend
	 * @param antiCheatClient added anti-cheat client
	 */
	protected abstract void onNetworkClientAdded(@NotNull IEOSNetworkClient antiCheatClient);

	/**
	 * Notify the Anti-Cheat client with message server want to send
	 * @param callbackInfo info about a client and data to send
	 */
	protected void onMessageToClient(@NotNull EOS_AntiCheatCommon_OnMessageToClientCallbackInfo callbackInfo) throws EOSException {
		final IEOSNetworkClient antiCheatClient = getNetworkClient(callbackInfo.ClientHandle);
		if (antiCheatClient != null) {
			final byte[] data = callbackInfo.getMessageBytes();
			if (options.isEnableNetworkProtection()) {
				final int protectMessageLength = antiCheatServer.getProtectMessageOutputLength(data.length);
				final byte[] encryptedData = antiCheatServer.protectMessage(new EOS_AntiCheatServer_ProtectMessageOptions(callbackInfo.ClientHandle, data, protectMessageLength));
				antiCheatClient.onSendEacData(encryptedData);
			}
			else {
				antiCheatClient.onSendEacData(data);
			}
		}
	}

	/**
	 * Event happens when Anti-Cheat interface wants to apply specified action to the game client
	 * @param callbackInfo info about a client and action to apply
	 */
	protected void onClientActionRequired(@NotNull EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo callbackInfo) {
		final IEOSNetworkClient antiCheatClient = getNetworkClient(callbackInfo.ClientHandle);
		if (antiCheatClient != null) {
			if (callbackInfo.ClientAction == EOS_EAntiCheatCommonClientAction.EOS_ACCCA_RemovePlayer) {
				if (removeNetworkClient(callbackInfo.ClientHandle)) {
					antiCheatServer.unregisterClient(new EOS_AntiCheatServer_UnregisterClientOptions(callbackInfo.ClientHandle));
					antiCheatClient.onKickFromAntiCheat(callbackInfo.ActionReasonCode, callbackInfo.ActionReasonDetailsString);
				}
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