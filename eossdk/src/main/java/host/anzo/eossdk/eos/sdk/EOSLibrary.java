package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_Definition;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_DefinitionV2;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_PlayerAchievement;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_UnlockedAchievement;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.*;
import host.anzo.eossdk.eos.sdk.achievements.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbacks.*;
import host.anzo.eossdk.eos.sdk.anticheat.client.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.common.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientActionRequiredCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientAuthStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnMessageToClientCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.*;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_IdToken;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Token;
import host.anzo.eossdk.eos.sdk.auth.callbacks.*;
import host.anzo.eossdk.eos.sdk.auth.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.*;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_ExternalAccountInfo;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_IdToken;
import host.anzo.eossdk.eos.sdk.connect.callbacks.*;
import host.anzo.eossdk.eos.sdk.connect.options.*;
import host.anzo.eossdk.eos.sdk.custominvites.callbacks.*;
import host.anzo.eossdk.eos.sdk.custominvites.options.*;
import host.anzo.eossdk.eos.sdk.ecom.*;
import host.anzo.eossdk.eos.sdk.ecom.callbacks.*;
import host.anzo.eossdk.eos.sdk.ecom.options.*;
import host.anzo.eossdk.eos.sdk.friends.callbacks.*;
import host.anzo.eossdk.eos.sdk.friends.enums.EOS_EFriendsStatus;
import host.anzo.eossdk.eos.sdk.friends.options.*;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbacks.EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbacks.EOS_IntegratedPlatform_OnUserPreLogoutCallback;
import host.anzo.eossdk.eos.sdk.integratedplatform.options.*;
import host.anzo.eossdk.eos.sdk.kws.EOS_KWS_PermissionStatus;
import host.anzo.eossdk.eos.sdk.kws.callbacks.*;
import host.anzo.eossdk.eos.sdk.kws.options.*;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_Definition;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_LeaderboardRecord;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_LeaderboardUserScore;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.options.*;
import host.anzo.eossdk.eos.sdk.lobby.*;
import host.anzo.eossdk.eos.sdk.lobby.callbacks.*;
import host.anzo.eossdk.eos.sdk.lobby.options.*;
import host.anzo.eossdk.eos.sdk.logging.callbacks.EOS_LogMessageFunc;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogCategory;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogLevel;
import host.anzo.eossdk.eos.sdk.metrics.options.EOS_Metrics_BeginPlayerSessionOptions;
import host.anzo.eossdk.eos.sdk.metrics.options.EOS_Metrics_EndPlayerSessionOptions;
import host.anzo.eossdk.eos.sdk.mods.EOS_Mods_ModInfo;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnEnumerateModsCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnInstallModCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnUninstallModCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnUpdateModCallback;
import host.anzo.eossdk.eos.sdk.mods.options.*;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_PacketQueueInfo;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;
import host.anzo.eossdk.eos.sdk.p2p.callbackresults.EOS_P2P_AddNotifyIncomingPacketQueueFullOptions;
import host.anzo.eossdk.eos.sdk.p2p.callbacks.*;
import host.anzo.eossdk.eos.sdk.p2p.options.*;
import host.anzo.eossdk.eos.sdk.integratedplatform.EOS_IntegratedPlatformOptionsContainer;
import host.anzo.eossdk.eos.sdk.platform.EOS_Platform_DesktopCrossplayStatusInfo;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_GetDesktopCrossplayStatusOptions;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import host.anzo.eossdk.eos.sdk.playerdatastorage.EOS_PlayerDataStorageFileTransferRequest;
import host.anzo.eossdk.eos.sdk.playerdatastorage.EOS_PlayerDataStorage_FileMetadata;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.*;
import host.anzo.eossdk.eos.sdk.playerdatastorage.options.*;
import host.anzo.eossdk.eos.sdk.presence.EOS_PresenceModification;
import host.anzo.eossdk.eos.sdk.presence.EOS_Presence_Info;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnJoinGameAcceptedCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnPresenceChangedCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnQueryPresenceCompleteCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_SetPresenceCompleteCallback;
import host.anzo.eossdk.eos.sdk.presence.options.*;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks.EOS_ProgressionSnapshot_OnDeleteSnapshotCallback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks.EOS_ProgressionSnapshot_OnSubmitSnapshotCallback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.options.*;
import host.anzo.eossdk.eos.sdk.reports.callbacks.EOS_Reports_OnSendPlayerBehaviorReportCompleteCallback;
import host.anzo.eossdk.eos.sdk.reports.options.EOS_Reports_SendPlayerBehaviorReportOptions;
import host.anzo.eossdk.eos.sdk.sanctions.EOS_Sanctions_PlayerSanction;
import host.anzo.eossdk.eos.sdk.sanctions.callbacks.EOS_Sanctions_OnQueryActivePlayerSanctionsCallback;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_CopyPlayerSanctionByIndexOptions;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_GetPlayerSanctionCountOptions;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_QueryActivePlayerSanctionsOptions;
import host.anzo.eossdk.eos.sdk.sessions.*;
import host.anzo.eossdk.eos.sdk.sessions.callbacks.*;
import host.anzo.eossdk.eos.sdk.sessions.options.*;
import host.anzo.eossdk.eos.sdk.stats.EOS_Stats_Stat;
import host.anzo.eossdk.eos.sdk.stats.callbacks.EOS_Stats_OnIngestStatCompleteCallback;
import host.anzo.eossdk.eos.sdk.stats.callbacks.EOS_Stats_OnQueryStatsCompleteCallback;
import host.anzo.eossdk.eos.sdk.stats.options.*;
import host.anzo.eossdk.eos.sdk.titlestorage.EOS_TitleStorageFileTransferRequest;
import host.anzo.eossdk.eos.sdk.titlestorage.EOS_TitleStorage_FileMetadata;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnDeleteCacheCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnQueryFileCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnQueryFileListCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnReadFileCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.options.*;
import host.anzo.eossdk.eos.sdk.ui.callbacks.*;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EInputStateButtonFlags;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EKeyCombination;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_ENotificationLocation;
import host.anzo.eossdk.eos.sdk.ui.options.*;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo_BestDisplayName;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo_ExternalUserInfo;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoCallback;
import host.anzo.eossdk.eos.sdk.userinfo.options.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Anton Lasevich
 * @since 8/8/2023
 */
public interface EOSLibrary extends Library {
	EOSLibrary instance = getLibraryInstance();

	private static EOSLibrary getLibraryInstance() {
		String libName;
		switch (Platform.getOSType()) {
			case Platform.WINDOWS, Platform.WINDOWSCE -> {
				if (Platform.is64Bit()) {
					libName = "EOSSDK-Win64-Shipping";
				}
				else {
					libName = "EOSSDK-Win32-Shipping";
				}
			}
			case Platform.LINUX -> libName = "libEOSSDK-Linux-Shipping";
			case Platform.MAC -> libName = "libEOSSDK-Mac-Shipping";
			case Platform.ANDROID -> libName = "libEOSSDK-Android-Shipping";
			default -> throw new RuntimeException("Unsupported platform: " + Platform.getOSType());
		}
		return Native.load(libName, EOSLibrary.class);
	}

	// Common
	String EOS_EResult_ToString(EOS_EResult result);
	int EOS_EResult_IsOperationComplete(EOS_EResult result);
	EOS_EResult EOS_ByteArray_ToString(byte[] byteArray, int length, byte[] uutBuffer, IntBuffer inOutBufferLength);
	int EOS_EpicAccountId_IsValid(EOS_EpicAccountId accountId);
	EOS_EResult EOS_EpicAccountId_ToString(EOS_EpicAccountId accountId, String outBuffer, IntBuffer inOutBufferLength);
	EOS_EpicAccountId EOS_EpicAccountId_FromString(String accountIdString);
	int EOS_ProductUserId_IsValid(EOS_ProductUserId accountId);
	EOS_EResult EOS_ProductUserId_ToString(EOS_ProductUserId accountId, String outBuffer, IntBuffer inOutBufferLength);
	EOS_ProductUserId EOS_ProductUserId_FromString(String productUserIdString);
	EOS_EResult EOS_ContinuanceToken_ToString(EOS_ContinuanceToken continuanceToken, String outBuffer, IntBuffer inOutBufferLength);

	// Interfaces
	EOS_Connect_Interface EOS_Platform_GetConnectInterface(EOS_Platform_Interface handle);
	EOS_Auth_Interface EOS_Platform_GetAuthInterface(EOS_Platform_Interface handle);
	EOS_AntiCheatServer_Interface EOS_Platform_GetAntiCheatServerInterface(EOS_Platform_Interface handle);
	EOS_AntiCheatClient_Interface EOS_Platform_GetAntiCheatClientInterface(EOS_Platform_Interface handle);
	EOS_Mods_Interface EOS_Platform_GetModsInterface(EOS_Platform_Interface handle);
	EOS_Lobby_Interface EOS_Platform_GetLobbyInterface(EOS_Platform_Interface handle);
	EOS_Achievements_Interface EOS_Platform_GetAchievementsInterface(EOS_Platform_Interface handle);
	EOS_Reports_Interface EOS_Platform_GetReportsInterface(EOS_Platform_Interface handle);
	EOS_Sanctions_Interface EOS_Platform_GetSanctionsInterface(EOS_Platform_Interface handle);
	EOS_CustomInvites_Interface EOS_Platform_GetCustomInvitesInterface(EOS_Platform_Interface handle);
	EOS_Ecom_Interface EOS_Platform_GetEcomInterface(EOS_Platform_Interface handle);
	EOS_Friends_Interface EOS_Platform_GetFriendsInterface(EOS_Platform_Interface handle);
	EOS_IntegratedPlatform_Interface EOS_Platform_GetIntegratedPlatformInterface(EOS_Platform_Interface handle);
	EOS_KWS_Interface EOS_Platform_GetKWSInterface(EOS_Platform_Interface handle);
	EOS_Leaderboards_Interface EOS_Platform_GetLeaderboardsInterface(EOS_Platform_Interface handle);
	EOS_Metrics_Interface EOS_Platform_GetMetricsInterface(EOS_Platform_Interface handle);
	EOS_P2P_Interface EOS_Platform_GetP2PInterface(EOS_Platform_Interface handle);
	EOS_PlayerDataStorage_Interface EOS_Platform_GetPlayerDataStorageInterface(EOS_Platform_Interface handle);
	EOS_Presence_Interface EOS_Platform_GetPresenceInterface(EOS_Platform_Interface handle);
	EOS_ProgressionSnapshot_Interface EOS_Platform_GetProgressionSnapshotInterface(EOS_Platform_Interface handle);
	EOS_Sessions_Interface EOS_Platform_GetSessionsInterface(EOS_Platform_Interface handle);
	EOS_Stats_Interface EOS_Platform_GetStatsInterface(EOS_Platform_Interface handle);
	EOS_TitleStorage_Interface EOS_Platform_GetTitleStorageInterface(EOS_Platform_Interface handle);
	EOS_UserInfo_Interface EOS_Platform_GetUserInfoInterface(EOS_Platform_Interface handle);
	EOS_UI_Interface EOS_Platform_GetUIInterface(EOS_Platform_Interface handle);

	// Initialize
	EOS_EResult EOS_Initialize(EOS_InitializeOptions options);
	EOS_EResult EOS_Shutdown();

	// Logging
	EOS_EResult EOS_Logging_SetCallback(EOS_LogMessageFunc callback);
	EOS_EResult EOS_Logging_SetLogLevel(EOS_ELogCategory logCategory, EOS_ELogLevel logLevel);

	// Platform
	EOS_Platform_Interface EOS_Platform_Create(EOS_Platform_Options options);
	void EOS_Platform_Release(EOS_Platform_Interface handle);
	void EOS_Platform_Tick(EOS_Platform_Interface handle);
	EOS_EResult EOS_Platform_GetActiveCountryCode(EOS_Platform_Interface handle, EOS_EpicAccountId localUserId, ByteBuffer outBuffer, IntBuffer inOutBufferLength);
	EOS_EResult EOS_Platform_GetActiveLocaleCode(EOS_Platform_Interface handle, EOS_EpicAccountId localUserId, ByteBuffer outBuffer, IntBuffer inOutBufferLength);
	EOS_EResult EOS_Platform_GetOverrideCountryCode(EOS_Platform_Interface handle, ByteBuffer outBuffer, IntBuffer inOutBufferLength);
	EOS_EResult EOS_Platform_GetOverrideLocaleCode(EOS_Platform_Interface handle, ByteBuffer outBuffer, IntBuffer inOutBufferLength);
	EOS_EResult EOS_Platform_SetOverrideCountryCode(EOS_Platform_Interface handle, String newCountryCode);
	EOS_EResult EOS_Platform_SetOverrideLocaleCode(EOS_Platform_Interface handle, String newLocaleCode);
	EOS_EResult EOS_Platform_CheckForLauncherAndRestart(EOS_Platform_Interface handle);
	EOS_EResult EOS_Platform_GetDesktopCrossplayStatus(EOS_Platform_Interface handle, EOS_Platform_GetDesktopCrossplayStatusOptions options, EOS_Platform_DesktopCrossplayStatusInfo outDesktopCrossplayStatusInfo);
	EOS_EResult EOS_Platform_SetApplicationStatus(EOS_Platform_Interface handle, EOS_EApplicationStatus newStatus);
	EOS_EApplicationStatus EOS_Platform_GetApplicationStatus(EOS_Platform_Interface handle);
	EOS_EResult EOS_Platform_SetNetworkStatus(EOS_Platform_Interface handle, EOS_ENetworkStatus newStatus);
	EOS_ENetworkStatus EOS_Platform_GetNetworkStatus(EOS_Platform_Interface handle);
	String EOS_EApplicationStatus_ToString(EOS_EApplicationStatus applicationStatus);
	String EOS_ENetworkStatus_ToString(EOS_ENetworkStatus networkStatus);


	// Anti-cheat Server
	EOS_NotificationId EOS_AntiCheatServer_AddNotifyMessageToClient(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_AddNotifyMessageToClientOptions options,
	                                                                Pointer clientData,
	                                                                EOS_AntiCheatServer_OnMessageToClientCallback notificationFn);

	void EOS_AntiCheatServer_RemoveNotifyMessageToClient(EOS_AntiCheatServer_Interface handle, EOS_NotificationId notificationId);

	EOS_NotificationId EOS_AntiCheatServer_AddNotifyClientActionRequired(EOS_AntiCheatServer_Interface handle,
	                                                                     EOS_AntiCheatServer_AddNotifyClientActionRequiredOptions options,
	                                                                     Pointer clientData,
	                                                                     EOS_AntiCheatServer_OnClientActionRequiredCallback notificationFn);

	void EOS_AntiCheatServer_RemoveNotifyClientActionRequired(EOS_AntiCheatServer_Interface handle, EOS_NotificationId notificationId);

	EOS_NotificationId EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged(EOS_AntiCheatServer_Interface handle,
	                                                                        EOS_AntiCheatServer_AddNotifyClientAuthStatusChangedOptions options,
	                                                                        Pointer clientData,
	                                                                        EOS_AntiCheatServer_OnClientAuthStatusChangedCallback notificationFn);

	void EOS_AntiCheatServer_RemoveNotifyClientAuthStatusChanged(EOS_AntiCheatServer_Interface handle, EOS_NotificationId notificationId);

	EOS_EResult EOS_AntiCheatServer_BeginSession(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_BeginSessionOptions options);

	EOS_EResult EOS_AntiCheatServer_EndSession(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_EndSessionOptions options);

	EOS_EResult EOS_AntiCheatServer_RegisterClient(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_RegisterClientOptions options);

	EOS_EResult EOS_AntiCheatServer_UnregisterClient(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_UnregisterClientOptions options);

	EOS_EResult EOS_AntiCheatServer_ReceiveMessageFromClient(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_ReceiveMessageFromClientOptions options);

	EOS_EResult EOS_AntiCheatServer_SetClientDetails(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_SetClientDetailsOptions options);

	EOS_EResult EOS_AntiCheatServer_SetGameSessionId(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_SetGameSessionIdOptions options);

	EOS_EResult EOS_AntiCheatServer_SetClientNetworkState(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatServer_SetClientNetworkStateOptions options);

	EOS_EResult EOS_AntiCheatServer_GetProtectMessageOutputLength(EOS_AntiCheatServer_Interface handle,
	                                                              EOS_AntiCheatServer_GetProtectMessageOutputLengthOptions options,
	                                                              IntByReference outBufferSizeBytes);

	EOS_EResult EOS_AntiCheatServer_ProtectMessage(EOS_AntiCheatServer_Interface handle,
	                                               EOS_AntiCheatServer_ProtectMessageOptions options,
	                                               ByteBuffer outBuffer,
	                                               IntByReference outBytesWritten);

	EOS_EResult EOS_AntiCheatServer_UnprotectMessage(EOS_AntiCheatServer_Interface handle,
	                                                 EOS_AntiCheatServer_UnprotectMessageOptions options,
	                                                 ByteBuffer outBuffer,
	                                                 IntByReference outBytesWritten);

	EOS_EResult EOS_AntiCheatServer_RegisterEvent(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_RegisterEventOptions options);

	EOS_EResult EOS_AntiCheatServer_LogEvent(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogEventOptions options);

	EOS_EResult EOS_AntiCheatServer_LogGameRoundStart(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogGameRoundStartOptions options);

	EOS_EResult EOS_AntiCheatServer_LogGameRoundEnd(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogGameRoundEndOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerSpawn(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerSpawnOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerDespawn(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerDespawnOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerRevive(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerReviveOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerTick(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerTickOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerUseWeapon(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerUseWeaponOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerUseAbility(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerUseAbilityOptions options);

	EOS_EResult EOS_AntiCheatServer_LogPlayerTakeDamage(EOS_AntiCheatServer_Interface handle, EOS_AntiCheatCommon_LogPlayerTakeDamageOptions options);
	
	// Anti-Cheat Client
	EOS_NotificationId EOS_AntiCheatClient_AddNotifyMessageToServer(EOS_AntiCheatClient_Interface handle,
	                                                                EOS_AntiCheatClient_AddNotifyMessageToServerOptions options,
	                                                                Pointer clientData,
	                                                                EOS_AntiCheatClient_OnMessageToServerCallback notificationFn);
	void EOS_AntiCheatClient_RemoveNotifyMessageToServer(EOS_AntiCheatClient_Interface handle, EOS_NotificationId NotificationId);

	EOS_NotificationId EOS_AntiCheatClient_AddNotifyMessageToPeer(EOS_AntiCheatClient_Interface handle,
	                                                              EOS_AntiCheatClient_AddNotifyMessageToPeerOptions options,
	                                                              Pointer ClientData,
	                                                              EOS_AntiCheatClient_OnMessageToPeerCallback notificationFn);
	void EOS_AntiCheatClient_RemoveNotifyMessageToPeer(EOS_AntiCheatClient_Interface handle, EOS_NotificationId NotificationId);

	EOS_NotificationId EOS_AntiCheatClient_AddNotifyPeerActionRequired(EOS_AntiCheatClient_Interface handle,
	                                                                   EOS_AntiCheatClient_AddNotifyPeerActionRequiredOptions options,
	                                                                   Pointer clientData,
	                                                                   EOS_AntiCheatClient_OnPeerActionRequiredCallback notificationFn);

	void EOS_AntiCheatClient_RemoveNotifyPeerActionRequired(EOS_AntiCheatClient_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged(EOS_AntiCheatClient_Interface handle,
	                                                                      EOS_AntiCheatClient_AddNotifyPeerAuthStatusChangedOptions options,
	                                                                      Pointer clientData,
	                                                                      EOS_AntiCheatClient_OnPeerAuthStatusChangedCallback notificationFn);
	void EOS_AntiCheatClient_RemoveNotifyPeerAuthStatusChanged(EOS_AntiCheatClient_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_AntiCheatClient_AddNotifyClientIntegrityViolated(EOS_AntiCheatClient_Interface handle,
	                                                                        EOS_AntiCheatClient_AddNotifyClientIntegrityViolatedOptions options,
	                                                                        Pointer clientData,
	                                                                        EOS_AntiCheatClient_OnClientIntegrityViolatedCallback notificationFn);
	void EOS_AntiCheatClient_RemoveNotifyClientIntegrityViolated(EOS_AntiCheatClient_Interface handle, EOS_NotificationId NotificationId);
	EOS_EResult EOS_AntiCheatClient_BeginSession(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_BeginSessionOptions options);
	EOS_EResult EOS_AntiCheatClient_EndSession(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_EndSessionOptions options);
	EOS_EResult EOS_AntiCheatClient_PollStatus(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_PollStatusOptions options, IntByReference outViolationType, Pointer outMessage);
	EOS_EResult EOS_AntiCheatClient_AddExternalIntegrityCatalog(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions options);
	EOS_EResult EOS_AntiCheatClient_ReceiveMessageFromServer(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_ReceiveMessageFromServerOptions options);
	EOS_EResult EOS_AntiCheatClient_GetProtectMessageOutputLength(EOS_AntiCheatClient_Interface handle,
	                                                              EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions options,
	                                                              IntBuffer outBufferSizeBytes);
	EOS_EResult EOS_AntiCheatClient_ProtectMessage(EOS_AntiCheatClient_Interface handle,
	                                               EOS_AntiCheatClient_ProtectMessageOptions options,
	                                               Pointer outBuffer,
	                                               IntBuffer outBytesWritten);
	EOS_EResult EOS_AntiCheatClient_UnprotectMessage(EOS_AntiCheatClient_Interface handle,
	                                                 EOS_AntiCheatClient_UnprotectMessageOptions options,
	                                                 Pointer outBuffer,
	                                                 IntBuffer outBytesWritten);
	EOS_EResult EOS_AntiCheatClient_RegisterPeer(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_RegisterPeerOptions options);
	EOS_EResult EOS_AntiCheatClient_UnregisterPeer(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_UnregisterPeerOptions options);
	EOS_EResult EOS_AntiCheatClient_ReceiveMessageFromPeer(EOS_AntiCheatClient_Interface handle, EOS_AntiCheatClient_ReceiveMessageFromPeerOptions options);

	// Connect
	void EOS_Connect_Login(EOS_Connect_Interface handle, EOS_Connect_LoginOptions options, Pointer clientData, EOS_Connect_OnLoginCallback completionDelegate);

	void EOS_Connect_CreateUser(EOS_Connect_Interface handle, EOS_Connect_CreateUserOptions options, Pointer clientData, EOS_Connect_OnCreateUserCallback completionDelegate);

	void EOS_Connect_LinkAccount(EOS_Connect_Interface handle, EOS_Connect_LinkAccountOptions options, Pointer clientData, EOS_Connect_OnLinkAccountCallback completionDelegate);

	void EOS_Connect_UnlinkAccount(EOS_Connect_Interface handle, EOS_Connect_UnlinkAccountOptions options, Pointer clientData, EOS_Connect_OnUnlinkAccountCallback completionDelegate);

	void EOS_Connect_CreateDeviceId(EOS_Connect_Interface handle, EOS_Connect_CreateDeviceIdOptions options, Pointer clientData, EOS_Connect_OnCreateDeviceIdCallback completionDelegate);

	void EOS_Connect_DeleteDeviceId(EOS_Connect_Interface handle, EOS_Connect_DeleteDeviceIdOptions options, Pointer clientData, EOS_Connect_OnDeleteDeviceIdCallback completionDelegate);

	void EOS_Connect_TransferDeviceIdAccount(EOS_Connect_Interface handle,
	                                         EOS_Connect_TransferDeviceIdAccountOptions options,
	                                         Pointer clientData,
	                                         EOS_Connect_OnTransferDeviceIdAccountCallback completionDelegate);

	void EOS_Connect_QueryExternalAccountMappings(EOS_Connect_Interface handle,
	                                              EOS_Connect_QueryExternalAccountMappingsOptions options,
	                                              Pointer clientData,
	                                              EOS_Connect_OnQueryExternalAccountMappingsCallback completionDelegate);

	void EOS_Connect_QueryProductUserIdMappings(EOS_Connect_Interface handle,
	                                            EOS_Connect_QueryProductUserIdMappingsOptions options,
	                                            Pointer clientData,
	                                            EOS_Connect_OnQueryProductUserIdMappingsCallback completionDelegate);

	EOS_ProductUserId EOS_Connect_GetExternalAccountMapping(EOS_Connect_Interface handle, EOS_Connect_GetExternalAccountMappingsOptions options);

	EOS_EResult EOS_Connect_GetProductUserIdMapping(EOS_Connect_Interface handle, EOS_Connect_GetProductUserIdMappingOptions options, ByteBuffer outBuffer, IntBuffer inOutBufferLength);

	int EOS_Connect_GetProductUserExternalAccountCount(EOS_Connect_Interface handle, EOS_Connect_GetProductUserExternalAccountCountOptions options);

	EOS_EResult EOS_Connect_CopyProductUserExternalAccountByIndex(EOS_Connect_Interface handle,
	                                                              EOS_Connect_CopyProductUserExternalAccountByIndexOptions options,
	                                                              EOS_Connect_ExternalAccountInfo.ByReference[] outExternalAccountInfo);

	EOS_EResult EOS_Connect_CopyProductUserExternalAccountByAccountType(EOS_Connect_Interface handle,
	                                                                    EOS_Connect_CopyProductUserExternalAccountByAccountTypeOptions options,
	                                                                    EOS_Connect_ExternalAccountInfo.ByReference[] outExternalAccountInfo);

	EOS_EResult EOS_Connect_CopyProductUserExternalAccountByAccountId(EOS_Connect_Interface handle,
	                                                                  EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions options,
	                                                                  EOS_Connect_ExternalAccountInfo.ByReference[] outExternalAccountInfo);

	EOS_EResult EOS_Connect_CopyProductUserInfo(EOS_Connect_Interface handle,
	                                            EOS_Connect_CopyProductUserInfoOptions options,
	                                            EOS_Connect_ExternalAccountInfo.ByReference[] OutExternalAccountInfo);

	int EOS_Connect_GetLoggedInUsersCount(EOS_Connect_Interface handle);

	EOS_ProductUserId EOS_Connect_GetLoggedInUserByIndex(EOS_Connect_Interface handle, int index);

	EOS_ELoginStatus EOS_Connect_GetLoginStatus(EOS_Connect_Interface handle, EOS_ProductUserId LocalUserId);

	EOS_NotificationId EOS_Connect_AddNotifyAuthExpiration(EOS_Connect_Interface handle,
	                                                       EOS_Connect_AddNotifyAuthExpirationOptions options,
	                                                       Pointer clientData,
	                                                       EOS_Connect_OnAuthExpirationCallback Notification);

	void EOS_Connect_RemoveNotifyAuthExpiration(EOS_Connect_Interface handle, EOS_NotificationId InId);

	EOS_NotificationId EOS_Connect_AddNotifyLoginStatusChanged(EOS_Connect_Interface handle,
	                                                           EOS_Connect_AddNotifyLoginStatusChangedOptions options,
	                                                           Pointer clientData,
	                                                           EOS_Connect_OnLoginStatusChangedCallback Notification);

	void EOS_Connect_RemoveNotifyLoginStatusChanged(EOS_Connect_Interface handle, EOS_NotificationId InId);

	EOS_EResult EOS_Connect_CopyIdToken(EOS_Connect_Interface handle, EOS_Connect_CopyIdTokenOptions options, EOS_Connect_IdToken.ByReference[] outIdToken);

	void EOS_Connect_VerifyIdToken(EOS_Connect_Interface handle,
	                               EOS_Connect_VerifyIdTokenOptions options,
	                               Pointer clientData,
	                               EOS_Connect_OnVerifyIdTokenCallback completionDelegate);
	void EOS_Connect_IdToken_Release(EOS_Connect_IdToken idToken);

	void EOS_Connect_ExternalAccountInfo_Release(EOS_Connect_ExternalAccountInfo externalAccountInfo);

	// Auth
	void EOS_Auth_Login(EOS_Auth_Interface handle, EOS_Auth_LoginOptions options, Pointer clientData, EOS_Auth_OnLoginCallback completionDelegate);

	void EOS_Auth_Logout(EOS_Auth_Interface handle, EOS_Auth_LogoutOptions options, Pointer clientData, EOS_Auth_OnLogoutCallback completionDelegate);

	void EOS_Auth_LinkAccount(EOS_Auth_Interface handle, EOS_Auth_LinkAccountOptions options, Pointer clientData, EOS_Auth_OnLinkAccountCallback completionDelegate);

	void EOS_Auth_DeletePersistentAuth(EOS_Auth_Interface handle, EOS_Auth_DeletePersistentAuthOptions options, Pointer clientData, EOS_Auth_OnDeletePersistentAuthCallback completionDelegate);

	void EOS_Auth_VerifyUserAuth(EOS_Auth_Interface handle, EOS_Auth_VerifyUserAuthOptions options, Pointer clientData, EOS_Auth_OnVerifyUserAuthCallback completionDelegate);

	int EOS_Auth_GetLoggedInAccountsCount(EOS_Auth_Interface handle);

	EOS_EpicAccountId EOS_Auth_GetLoggedInAccountByIndex(EOS_Auth_Interface handle, int index);

	EOS_ELoginStatus EOS_Auth_GetLoginStatus(EOS_Auth_Interface handle, EOS_EpicAccountId localUserId);

	EOS_EResult EOS_Auth_CopyUserAuthToken(EOS_Auth_Interface handle, EOS_Auth_CopyUserAuthTokenOptions options, EOS_EpicAccountId LocalUserId, EOS_Auth_Token[] outUserAuthToken);

	EOS_EResult EOS_Auth_CopyIdToken(EOS_Auth_Interface handle, EOS_Auth_CopyIdTokenOptions options, EOS_Auth_IdToken[] outIdToken);

	void EOS_Auth_QueryIdToken(EOS_Auth_Interface handle, EOS_Auth_QueryIdTokenOptions options, Pointer clientData, EOS_Auth_OnQueryIdTokenCallback completionDelegate);

	void EOS_Auth_VerifyIdToken(EOS_Auth_Interface handle, EOS_Auth_VerifyIdTokenOptions options, Pointer clientData, EOS_Auth_OnVerifyIdTokenCallback completionDelegate);

	EOS_EResult EOS_Auth_GetSelectedAccountId(EOS_Auth_Interface handle, EOS_EpicAccountId localUserId, EOS_EpicAccountId outSelectedAccountId);

	int EOS_Auth_GetMergedAccountsCount(EOS_Auth_Interface handle, EOS_EpicAccountId localUserId);

	EOS_EpicAccountId EOS_Auth_GetMergedAccountByIndex(EOS_Auth_Interface handle, EOS_EpicAccountId localUserId, int index);

	EOS_NotificationId EOS_Auth_AddNotifyLoginStatusChanged(EOS_Auth_Interface handle,
	                                                        EOS_Auth_AddNotifyLoginStatusChangedOptions options,
	                                                        Pointer clientData,
	                                                        EOS_Auth_OnLoginStatusChangedCallback notification);

	void EOS_Auth_RemoveNotifyLoginStatusChanged(EOS_Auth_Interface handle, EOS_NotificationId inId);

	void EOS_Auth_Token_Release(EOS_Auth_Token authToken);

	void EOS_Auth_IdToken_Release(EOS_Auth_IdToken idToken);

	// Mods
	void EOS_Mods_InstallMod(EOS_Mods_Interface handle, EOS_Mods_InstallModOptions Options, Pointer ClientData, EOS_Mods_OnInstallModCallback completionDelegate);
	void EOS_Mods_UninstallMod(EOS_Mods_Interface handle, EOS_Mods_UninstallModOptions options, Pointer clientData, EOS_Mods_OnUninstallModCallback completionDelegate);
	void EOS_Mods_EnumerateMods(EOS_Mods_Interface handle, EOS_Mods_EnumerateModsOptions options, Pointer clientData, EOS_Mods_OnEnumerateModsCallback completionDelegate);
	EOS_EResult EOS_Mods_CopyModInfo(EOS_Mods_Interface handle, EOS_Mods_CopyModInfoOptions options, EOS_Mods_ModInfo[] outEnumeratedMods);
	void EOS_Mods_UpdateMod(EOS_Mods_Interface handle, EOS_Mods_UpdateModOptions options, Pointer clientData, EOS_Mods_OnUpdateModCallback completionDelegate);
	void EOS_Mods_ModInfo_Release(EOS_Mods_ModInfo modInfo);
	
	// Lobby
	void EOS_Lobby_CreateLobby(EOS_Lobby_Interface handle, EOS_Lobby_CreateLobbyOptions Options, Pointer ClientData, EOS_Lobby_OnCreateLobbyCallback completionDelegate);
	void EOS_Lobby_DestroyLobby(EOS_Lobby_Interface handle, EOS_Lobby_DestroyLobbyOptions Options, Pointer ClientData, EOS_Lobby_OnDestroyLobbyCallback completionDelegate);
	void EOS_Lobby_JoinLobby(EOS_Lobby_Interface handle, EOS_Lobby_JoinLobbyOptions Options, Pointer ClientData, EOS_Lobby_OnJoinLobbyCallback completionDelegate);
	void EOS_Lobby_JoinLobbyById(EOS_Lobby_Interface handle, EOS_Lobby_JoinLobbyByIdOptions Options, Pointer ClientData, EOS_Lobby_OnJoinLobbyByIdCallback completionDelegate);
	void EOS_Lobby_LeaveLobby(EOS_Lobby_Interface handle, EOS_Lobby_LeaveLobbyOptions Options, Pointer ClientData, EOS_Lobby_OnLeaveLobbyCallback completionDelegate);
	EOS_EResult EOS_Lobby_UpdateLobbyModification(EOS_Lobby_Interface handle, EOS_Lobby_UpdateLobbyModificationOptions Options, PointerByReference outLobbyModificationHandle);
	void EOS_Lobby_UpdateLobby(EOS_Lobby_Interface handle, EOS_Lobby_UpdateLobbyOptions Options, Pointer ClientData, EOS_Lobby_OnUpdateLobbyCallback completionDelegate);
	void EOS_Lobby_PromoteMember(EOS_Lobby_Interface handle, EOS_Lobby_PromoteMemberOptions Options, Pointer ClientData, EOS_Lobby_OnPromoteMemberCallback completionDelegate);
	void EOS_Lobby_KickMember(EOS_Lobby_Interface handle, EOS_Lobby_KickMemberOptions Options, Pointer ClientData, EOS_Lobby_OnKickMemberCallback completionDelegate);
	void EOS_Lobby_HardMuteMember(EOS_Lobby_Interface handle, EOS_Lobby_HardMuteMemberOptions Options, Pointer ClientData, EOS_Lobby_OnHardMuteMemberCallback completionDelegate);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyUpdateReceived(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyUpdateReceivedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyUpdateReceivedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyUpdateReceived(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyMemberUpdateReceived(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyMemberUpdateReceivedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyMemberUpdateReceivedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyMemberUpdateReceived(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyMemberStatusReceived(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyMemberStatusReceivedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyMemberStatusReceivedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyMemberStatusReceived(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	void EOS_Lobby_SendInvite(EOS_Lobby_Interface handle, EOS_Lobby_SendInviteOptions Options, Pointer ClientData, EOS_Lobby_OnSendInviteCallback completionDelegate);
	void EOS_Lobby_RejectInvite(EOS_Lobby_Interface handle, EOS_Lobby_RejectInviteOptions Options, Pointer ClientData, EOS_Lobby_OnRejectInviteCallback completionDelegate);
	void EOS_Lobby_QueryInvites(EOS_Lobby_Interface handle, EOS_Lobby_QueryInvitesOptions Options, Pointer ClientData, EOS_Lobby_OnQueryInvitesCallback completionDelegate);
	int EOS_Lobby_GetInviteCount(EOS_Lobby_Interface handle, EOS_Lobby_GetInviteCountOptions Options);
	EOS_EResult EOS_Lobby_GetInviteIdByIndex(EOS_Lobby_Interface handle, EOS_Lobby_GetInviteIdByIndexOptions Options, ByteBuffer OutBuffer, IntBuffer InOutBufferLength);
	EOS_EResult EOS_Lobby_CreateLobbySearch(EOS_Lobby_Interface handle, EOS_Lobby_CreateLobbySearchOptions Options, PointerByReference OutLobbySearchHandle);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyInviteReceived(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyInviteReceivedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyInviteReceivedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyInviteReceived(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyInviteAccepted(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyInviteAcceptedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyInviteAcceptedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyInviteAccepted(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifyLobbyInviteRejected(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyLobbyInviteRejectedOptions Options, Pointer ClientData, EOS_Lobby_OnLobbyInviteRejectedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyLobbyInviteRejected(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifyJoinLobbyAccepted(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyJoinLobbyAcceptedOptions Options, Pointer ClientData, EOS_Lobby_OnJoinLobbyAcceptedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyJoinLobbyAccepted(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Lobby_AddNotifySendLobbyNativeInviteRequested(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifySendLobbyNativeInviteRequestedOptions Options, Pointer ClientData, EOS_Lobby_OnSendLobbyNativeInviteRequestedCallback notificationFn);
	void EOS_Lobby_RemoveNotifySendLobbyNativeInviteRequested(EOS_Lobby_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_Lobby_CopyLobbyDetailsHandleByInviteId(EOS_Lobby_Interface handle, EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions Options, PointerByReference OutLobbyDetailsHandle);
	EOS_EResult EOS_Lobby_CopyLobbyDetailsHandleByUiEventId(EOS_Lobby_Interface handle, EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions Options, PointerByReference OutLobbyDetailsHandle);
	EOS_EResult EOS_Lobby_CopyLobbyDetailsHandle(EOS_Lobby_Interface handle, EOS_Lobby_CopyLobbyDetailsHandleOptions Options, PointerByReference OutLobbyDetailsHandle);
	EOS_EResult EOS_Lobby_GetRTCRoomName(EOS_Lobby_Interface handle, EOS_Lobby_GetRTCRoomNameOptions options, ByteBuffer outBuffer, IntBuffer inOutBufferLength);
	EOS_EResult EOS_Lobby_IsRTCRoomConnected(EOS_Lobby_Interface handle, EOS_Lobby_IsRTCRoomConnectedOptions Options, IntBuffer bOutIsConnected);
	EOS_NotificationId EOS_Lobby_AddNotifyRTCRoomConnectionChanged(EOS_Lobby_Interface handle, EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions Options, Pointer ClientData, EOS_Lobby_OnRTCRoomConnectionChangedCallback notificationFn);
	void EOS_Lobby_RemoveNotifyRTCRoomConnectionChanged(EOS_Lobby_Interface handle, EOS_NotificationId InId);

	// Lobby Modification
	EOS_EResult EOS_LobbyModification_SetBucketId(EOS_LobbyModification handle, EOS_LobbyModification_SetBucketIdOptions Options);
	EOS_EResult EOS_LobbyModification_SetPermissionLevel(EOS_LobbyModification handle, EOS_LobbyModification_SetPermissionLevelOptions Options);
	EOS_EResult EOS_LobbyModification_SetMaxMembers(EOS_LobbyModification handle, EOS_LobbyModification_SetMaxMembersOptions Options);
	EOS_EResult EOS_LobbyModification_SetInvitesAllowed(EOS_LobbyModification handle, EOS_LobbyModification_SetInvitesAllowedOptions Options);
	EOS_EResult EOS_LobbyModification_AddAttribute(EOS_LobbyModification handle, EOS_LobbyModification_AddAttributeOptions Options);
	EOS_EResult EOS_LobbyModification_RemoveAttribute(EOS_LobbyModification handle, EOS_LobbyModification_RemoveAttributeOptions Options);
	EOS_EResult EOS_LobbyModification_AddMemberAttribute(EOS_LobbyModification handle, EOS_LobbyModification_AddMemberAttributeOptions Options);
	EOS_EResult EOS_LobbyModification_RemoveMemberAttribute(EOS_LobbyModification handle, EOS_LobbyModification_RemoveMemberAttributeOptions Options);
	void EOS_LobbyModification_Release(EOS_LobbyModification lobbyModificationHandle);

	// Lobby Details
	EOS_ProductUserId EOS_LobbyDetails_GetLobbyOwner(EOS_LobbyDetails handle, EOS_LobbyDetails_GetLobbyOwnerOptions Options);
	EOS_EResult EOS_LobbyDetails_CopyInfo(EOS_LobbyDetails handle, EOS_LobbyDetails_CopyInfoOptions Options, EOS_LobbyDetails_Info[] OutLobbyDetailsInfo);
	int EOS_LobbyDetails_GetAttributeCount(EOS_LobbyDetails handle, EOS_LobbyDetails_GetAttributeCountOptions Options);
	EOS_EResult EOS_LobbyDetails_CopyAttributeByIndex(EOS_LobbyDetails handle, EOS_LobbyDetails_CopyAttributeByIndexOptions Options, EOS_Lobby_Attribute[] OutAttribute);
	EOS_EResult EOS_LobbyDetails_CopyAttributeByKey(EOS_LobbyDetails handle, EOS_LobbyDetails_CopyAttributeByKeyOptions Options, EOS_Lobby_Attribute[] OutAttribute);
	int EOS_LobbyDetails_GetMemberCount(EOS_LobbyDetails handle, EOS_LobbyDetails_GetMemberCountOptions Options);
	EOS_ProductUserId EOS_LobbyDetails_GetMemberByIndex(EOS_LobbyDetails handle, EOS_LobbyDetails_GetMemberByIndexOptions Options);
	int EOS_LobbyDetails_GetMemberAttributeCount(EOS_LobbyDetails handle, EOS_LobbyDetails_GetMemberAttributeCountOptions Options);
	EOS_EResult EOS_LobbyDetails_CopyMemberAttributeByIndex(EOS_LobbyDetails handle, EOS_LobbyDetails_CopyMemberAttributeByIndexOptions Options, EOS_Lobby_Attribute[] OutAttribute);
	EOS_EResult EOS_LobbyDetails_CopyMemberAttributeByKey(EOS_LobbyDetails handle, EOS_LobbyDetails_CopyMemberAttributeByKeyOptions Options, EOS_Lobby_Attribute[] OutAttribute);
	void EOS_LobbyDetails_Info_Release(EOS_LobbyDetails_Info lobbyDetailsInfo);
	void EOS_Lobby_Attribute_Release(EOS_Lobby_Attribute lobbyAttribute);
	void EOS_LobbyDetails_Release(EOS_LobbyDetails lobbyHandle);

	// Lobby Search
	void EOS_LobbySearch_Find(EOS_LobbySearch handle, EOS_LobbySearch_FindOptions Options, Pointer ClientData, EOS_LobbySearch_OnFindCallback completionDelegate);
	EOS_EResult EOS_LobbySearch_SetLobbyId(EOS_LobbySearch handle, EOS_LobbySearch_SetLobbyIdOptions Options);
	EOS_EResult EOS_LobbySearch_SetTargetUserId(EOS_LobbySearch handle, EOS_LobbySearch_SetTargetUserIdOptions Options);
	EOS_EResult EOS_LobbySearch_SetParameter(EOS_LobbySearch handle, EOS_LobbySearch_SetParameterOptions Options);
	EOS_EResult EOS_LobbySearch_RemoveParameter(EOS_LobbySearch handle, EOS_LobbySearch_RemoveParameterOptions Options);
	EOS_EResult EOS_LobbySearch_SetMaxResults(EOS_LobbySearch handle, EOS_LobbySearch_SetMaxResultsOptions Options);
	int EOS_LobbySearch_GetSearchResultCount(EOS_LobbySearch handle, EOS_LobbySearch_GetSearchResultCountOptions Options);
	EOS_EResult EOS_LobbySearch_CopySearchResultByIndex(EOS_LobbySearch handle, EOS_LobbySearch_CopySearchResultByIndexOptions Options, EOS_LobbyDetails OutLobbyDetailsHandle);

	// Sanctions
	void EOS_Sanctions_QueryActivePlayerSanctions(EOS_Sanctions_Interface handle, EOS_Sanctions_QueryActivePlayerSanctionsOptions options, Pointer clientData, EOS_Sanctions_OnQueryActivePlayerSanctionsCallback completionDelegate);
	int EOS_Sanctions_GetPlayerSanctionCount(EOS_Sanctions_Interface handle, EOS_Sanctions_GetPlayerSanctionCountOptions options);
	EOS_EResult EOS_Sanctions_CopyPlayerSanctionByIndex(EOS_Sanctions_Interface handle, EOS_Sanctions_CopyPlayerSanctionByIndexOptions options, EOS_Sanctions_PlayerSanction[] outSanction);
	void EOS_Sanctions_PlayerSanction_Release(EOS_Sanctions_PlayerSanction sanction);

	// Reports
	void EOS_Reports_SendPlayerBehaviorReport(EOS_Reports_Interface handle, EOS_Reports_SendPlayerBehaviorReportOptions options, Pointer clientData, EOS_Reports_OnSendPlayerBehaviorReportCompleteCallback completionDelegate);
	
	// Achievements
	void EOS_Achievements_QueryDefinitions(EOS_Achievements_Interface handle, EOS_Achievements_QueryDefinitionsOptions options, Pointer clientData, EOS_Achievements_OnQueryDefinitionsCompleteCallback completionDelegate);
	int EOS_Achievements_GetAchievementDefinitionCount(EOS_Achievements_Interface handle, EOS_Achievements_GetAchievementDefinitionCountOptions options);
	EOS_EResult EOS_Achievements_CopyAchievementDefinitionV2ByIndex(EOS_Achievements_Interface handle, EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions options, EOS_Achievements_DefinitionV2[] OutDefinition);
	EOS_EResult EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId(EOS_Achievements_Interface handle, EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions options, EOS_Achievements_DefinitionV2[] OutDefinition);
	void EOS_Achievements_QueryPlayerAchievements(EOS_Achievements_Interface handle, EOS_Achievements_QueryPlayerAchievementsOptions options, Pointer clientData, EOS_Achievements_OnQueryPlayerAchievementsCompleteCallback completionDelegate);
	int EOS_Achievements_GetPlayerAchievementCount(EOS_Achievements_Interface handle, EOS_Achievements_GetPlayerAchievementCountOptions options);
	EOS_EResult EOS_Achievements_CopyPlayerAchievementByIndex(EOS_Achievements_Interface handle, EOS_Achievements_CopyPlayerAchievementByIndexOptions options, EOS_Achievements_PlayerAchievement[] OutAchievement);
	EOS_EResult EOS_Achievements_CopyPlayerAchievementByAchievementId(EOS_Achievements_Interface handle, EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions options, EOS_Achievements_PlayerAchievement[] OutAchievement);
	void EOS_Achievements_UnlockAchievements(EOS_Achievements_Interface handle, EOS_Achievements_UnlockAchievementsOptions options, Pointer clientData, EOS_Achievements_OnUnlockAchievementsCompleteCallback completionDelegate);
	EOS_NotificationId EOS_Achievements_AddNotifyAchievementsUnlockedV2(EOS_Achievements_Interface handle, EOS_Achievements_AddNotifyAchievementsUnlockedV2Options options, Pointer clientData, EOS_Achievements_OnAchievementsUnlockedCallbackV2 notificationFn);
	void EOS_Achievements_RemoveNotifyAchievementsUnlocked(EOS_Achievements_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_Achievements_CopyAchievementDefinitionByIndex(EOS_Achievements_Interface handle, EOS_Achievements_CopyAchievementDefinitionByIndexOptions options, EOS_Achievements_Definition[] OutDefinition);
	EOS_EResult EOS_Achievements_CopyAchievementDefinitionByAchievementId(EOS_Achievements_Interface handle, EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions options, EOS_Achievements_Definition[] OutDefinition);
	int EOS_Achievements_GetUnlockedAchievementCount(EOS_Achievements_Interface handle, EOS_Achievements_GetUnlockedAchievementCountOptions options);
	EOS_EResult EOS_Achievements_CopyUnlockedAchievementByIndex(EOS_Achievements_Interface handle, EOS_Achievements_CopyUnlockedAchievementByIndexOptions options, EOS_Achievements_UnlockedAchievement[] OutAchievement);
	EOS_EResult EOS_Achievements_CopyUnlockedAchievementByAchievementId(EOS_Achievements_Interface handle, EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions options, EOS_Achievements_UnlockedAchievement[] OutAchievement);
	EOS_NotificationId EOS_Achievements_AddNotifyAchievementsUnlocked(EOS_Achievements_Interface handle, EOS_Achievements_AddNotifyAchievementsUnlockedOptions options, Pointer clientData, EOS_Achievements_OnAchievementsUnlockedCallback notificationFn);
	void EOS_Achievements_Definition_Release(EOS_Achievements_Definition achievementDefinition);
	void EOS_Achievements_DefinitionV2_Release(EOS_Achievements_DefinitionV2 achievementDefinition);
	void EOS_Achievements_UnlockedAchievement_Release(EOS_Achievements_UnlockedAchievement achievement);
	void EOS_Achievements_PlayerAchievement_Release(EOS_Achievements_PlayerAchievement achievement);
	
	// Custom Invites
	EOS_EResult EOS_CustomInvites_SetCustomInvite(EOS_CustomInvites_Interface handle, EOS_CustomInvites_SetCustomInviteOptions options);
	void EOS_CustomInvites_SendCustomInvite(EOS_CustomInvites_Interface handle, EOS_CustomInvites_SendCustomInviteOptions options, Pointer clientData, EOS_CustomInvites_OnSendCustomInviteCallback completionDelegate);
	EOS_NotificationId EOS_CustomInvites_AddNotifyCustomInviteReceived(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions options, Pointer clientData, EOS_CustomInvites_OnCustomInviteReceivedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyCustomInviteReceived(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifyCustomInviteAccepted(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions options, Pointer clientData, EOS_CustomInvites_OnCustomInviteAcceptedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyCustomInviteAccepted(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifyCustomInviteRejected(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyCustomInviteRejectedOptions options, Pointer clientData, EOS_CustomInvites_OnCustomInviteRejectedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyCustomInviteRejected(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_CustomInvites_FinalizeInvite(EOS_CustomInvites_Interface handle, EOS_CustomInvites_FinalizeInviteOptions options);
	void EOS_CustomInvites_SendRequestToJoin(EOS_CustomInvites_Interface handle, EOS_CustomInvites_SendRequestToJoinOptions options, Pointer clientData, EOS_CustomInvites_OnSendRequestToJoinCallback completionDelegate);
	EOS_NotificationId EOS_CustomInvites_AddNotifyRequestToJoinResponseReceived(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyRequestToJoinResponseReceivedOptions options, Pointer clientData, EOS_CustomInvites_OnRequestToJoinResponseReceivedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyRequestToJoinResponseReceived(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifyRequestToJoinReceived(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions options, Pointer clientData, EOS_CustomInvites_OnRequestToJoinReceivedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyRequestToJoinReceived(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions options, Pointer clientData, EOS_CustomInvites_OnSendCustomNativeInviteRequestedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifySendCustomNativeInviteRequested(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifyRequestToJoinAccepted(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyRequestToJoinAcceptedOptions options, Pointer clientData, EOS_CustomInvites_OnRequestToJoinAcceptedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyRequestToJoinAccepted(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_CustomInvites_AddNotifyRequestToJoinRejected(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AddNotifyRequestToJoinRejectedOptions options, Pointer clientData, EOS_CustomInvites_OnRequestToJoinRejectedCallback notificationFn);
	void EOS_CustomInvites_RemoveNotifyRequestToJoinRejected(EOS_CustomInvites_Interface handle, EOS_NotificationId InId);
	void EOS_CustomInvites_AcceptRequestToJoin(EOS_CustomInvites_Interface handle, EOS_CustomInvites_AcceptRequestToJoinOptions options, Pointer clientData, EOS_CustomInvites_OnAcceptRequestToJoinCallback completionDelegate);
	void EOS_CustomInvites_RejectRequestToJoin(EOS_CustomInvites_Interface handle, EOS_CustomInvites_RejectRequestToJoinOptions options, Pointer clientData, EOS_CustomInvites_OnRejectRequestToJoinCallback completionDelegate);
	
	// Ecom
	void EOS_Ecom_QueryOwnership(EOS_Ecom_Interface handle, EOS_Ecom_QueryOwnershipOptions options, Pointer clientData, EOS_Ecom_OnQueryOwnershipCallback completionDelegate);
	void EOS_Ecom_QueryOwnershipBySandboxIds(EOS_Ecom_Interface handle, EOS_Ecom_QueryOwnershipBySandboxIdsOptions options, Pointer clientData, EOS_Ecom_OnQueryOwnershipBySandboxIdsCallback completionDelegate);
	void EOS_Ecom_QueryOwnershipToken(EOS_Ecom_Interface handle, EOS_Ecom_QueryOwnershipTokenOptions options, Pointer clientData, EOS_Ecom_OnQueryOwnershipTokenCallback completionDelegate);
	void EOS_Ecom_QueryEntitlements(EOS_Ecom_Interface handle, EOS_Ecom_QueryEntitlementsOptions options, Pointer clientData, EOS_Ecom_OnQueryEntitlementsCallback completionDelegate);
	void EOS_Ecom_QueryEntitlementToken(EOS_Ecom_Interface handle, EOS_Ecom_QueryEntitlementTokenOptions options, Pointer clientData, EOS_Ecom_OnQueryEntitlementTokenCallback completionDelegate);
	void EOS_Ecom_QueryOffers(EOS_Ecom_Interface handle, EOS_Ecom_QueryOffersOptions options, Pointer clientData, EOS_Ecom_OnQueryOffersCallback completionDelegate);
	void EOS_Ecom_Checkout(EOS_Ecom_Interface handle, EOS_Ecom_CheckoutOptions options, Pointer clientData, EOS_Ecom_OnCheckoutCallback completionDelegate);
	void EOS_Ecom_RedeemEntitlements(EOS_Ecom_Interface handle, EOS_Ecom_RedeemEntitlementsOptions options, Pointer clientData, EOS_Ecom_OnRedeemEntitlementsCallback completionDelegate);
	int EOS_Ecom_GetLastRedeemedEntitlementsCount(EOS_Ecom_Interface handle, EOS_Ecom_GetLastRedeemedEntitlementsCountOptions options);
	EOS_EResult EOS_Ecom_CopyLastRedeemedEntitlementByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions options, ByteBuffer OutRedeemedEntitlementId, IntBuffer InOutRedeemedEntitlementIdLength);
	int EOS_Ecom_GetEntitlementsCount(EOS_Ecom_Interface handle, EOS_Ecom_GetEntitlementsCountOptions options);
	int EOS_Ecom_GetEntitlementsByNameCount(EOS_Ecom_Interface handle, EOS_Ecom_GetEntitlementsByNameCountOptions options);
	EOS_EResult EOS_Ecom_CopyEntitlementByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyEntitlementByIndexOptions options, EOS_Ecom_Entitlement[] OutEntitlement);
	EOS_EResult EOS_Ecom_CopyEntitlementByNameAndIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyEntitlementByNameAndIndexOptions options, EOS_Ecom_Entitlement[] OutEntitlement);
	EOS_EResult EOS_Ecom_CopyEntitlementById(EOS_Ecom_Interface handle, EOS_Ecom_CopyEntitlementByIdOptions options, EOS_Ecom_Entitlement[] OutEntitlement);
	int EOS_Ecom_GetOfferCount(EOS_Ecom_Interface handle, EOS_Ecom_GetOfferCountOptions options);
	EOS_EResult EOS_Ecom_CopyOfferByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyOfferByIndexOptions options, EOS_Ecom_CatalogOffer[] OutOffer);
	EOS_EResult EOS_Ecom_CopyOfferById(EOS_Ecom_Interface handle, EOS_Ecom_CopyOfferByIdOptions options, EOS_Ecom_CatalogOffer[] OutOffer);
	int EOS_Ecom_GetOfferItemCount(EOS_Ecom_Interface handle, EOS_Ecom_GetOfferItemCountOptions options);
	EOS_EResult EOS_Ecom_CopyOfferItemByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyOfferItemByIndexOptions options, EOS_Ecom_CatalogItem[] OutItem);
	EOS_EResult EOS_Ecom_CopyItemById(EOS_Ecom_Interface handle, EOS_Ecom_CopyItemByIdOptions options, EOS_Ecom_CatalogItem[] OutItem);
	int EOS_Ecom_GetOfferImageInfoCount(EOS_Ecom_Interface handle, EOS_Ecom_GetOfferImageInfoCountOptions options);
	EOS_EResult EOS_Ecom_CopyOfferImageInfoByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyOfferImageInfoByIndexOptions options, EOS_Ecom_KeyImageInfo[] OutImageInfo);
	int EOS_Ecom_GetItemImageInfoCount(EOS_Ecom_Interface handle, EOS_Ecom_GetItemImageInfoCountOptions options);
	EOS_EResult EOS_Ecom_CopyItemImageInfoByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyItemImageInfoByIndexOptions options, EOS_Ecom_KeyImageInfo[] OutImageInfo);
	int EOS_Ecom_GetItemReleaseCount(EOS_Ecom_Interface handle, EOS_Ecom_GetItemReleaseCountOptions options);
	EOS_EResult EOS_Ecom_CopyItemReleaseByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyItemReleaseByIndexOptions options, EOS_Ecom_CatalogRelease[] OutRelease);
	int EOS_Ecom_GetTransactionCount(EOS_Ecom_Interface handle, EOS_Ecom_GetTransactionCountOptions options);
	EOS_EResult EOS_Ecom_CopyTransactionByIndex(EOS_Ecom_Interface handle, EOS_Ecom_CopyTransactionByIndexOptions options, EOS_Ecom_Transaction OutTransaction);
	EOS_EResult EOS_Ecom_CopyTransactionById(EOS_Ecom_Interface handle, EOS_Ecom_CopyTransactionByIdOptions options, EOS_Ecom_Transaction OutTransaction);
	EOS_EResult EOS_Ecom_Transaction_GetTransactionId(EOS_Ecom_Transaction handle, ByteBuffer OutBuffer, IntBuffer InOutBufferLength);
	int EOS_Ecom_Transaction_GetEntitlementsCount(EOS_Ecom_Transaction handle, EOS_Ecom_Transaction_GetEntitlementsCountOptions options);
	EOS_EResult EOS_Ecom_Transaction_CopyEntitlementByIndex(EOS_Ecom_Transaction handle, EOS_Ecom_Transaction_CopyEntitlementByIndexOptions options, EOS_Ecom_Entitlement[] OutEntitlement);
	void EOS_Ecom_Transaction_Release(EOS_Ecom_Transaction transaction);
	void EOS_Ecom_Entitlement_Release(EOS_Ecom_Entitlement entitlement);
	void EOS_Ecom_KeyImageInfo_Release(EOS_Ecom_KeyImageInfo keyImageInfo);
	void EOS_Ecom_CatalogOffer_Release(EOS_Ecom_CatalogOffer catalogOffer);
	void EOS_Ecom_CatalogItem_Release(EOS_Ecom_CatalogItem catalogItem);
	void EOS_Ecom_CatalogRelease_Release(EOS_Ecom_CatalogRelease catalogRelease);
	
	// Friends
	void EOS_Friends_QueryFriends(EOS_Friends_Interface handle, EOS_Friends_QueryFriendsOptions options, Pointer clientData, EOS_Friends_OnQueryFriendsCallback completionDelegate);
	void EOS_Friends_SendInvite(EOS_Friends_Interface handle, EOS_Friends_SendInviteOptions options, Pointer clientData, EOS_Friends_OnSendInviteCallback completionDelegate);
	void EOS_Friends_AcceptInvite(EOS_Friends_Interface handle, EOS_Friends_AcceptInviteOptions options, Pointer clientData, EOS_Friends_OnAcceptInviteCallback completionDelegate);
	void EOS_Friends_RejectInvite(EOS_Friends_Interface handle, EOS_Friends_RejectInviteOptions options, Pointer clientData, EOS_Friends_OnRejectInviteCallback completionDelegate);
	int EOS_Friends_GetFriendsCount(EOS_Friends_Interface handle, EOS_Friends_GetFriendsCountOptions options);
	EOS_EpicAccountId EOS_Friends_GetFriendAtIndex(EOS_Friends_Interface handle, EOS_Friends_GetFriendAtIndexOptions options);
	EOS_EFriendsStatus EOS_Friends_GetStatus(EOS_Friends_Interface handle, EOS_Friends_GetStatusOptions options);
	EOS_NotificationId EOS_Friends_AddNotifyFriendsUpdate(EOS_Friends_Interface handle, EOS_Friends_AddNotifyFriendsUpdateOptions options, Pointer clientData, EOS_Friends_OnFriendsUpdateCallback friendsUpdateHandler);
	void EOS_Friends_RemoveNotifyFriendsUpdate(EOS_Friends_Interface handle, EOS_NotificationId notificationId);
	int EOS_Friends_GetBlockedUsersCount(EOS_Friends_Interface handle, EOS_Friends_GetBlockedUsersCountOptions options);
	EOS_EpicAccountId EOS_Friends_GetBlockedUserAtIndex(EOS_Friends_Interface handle, EOS_Friends_GetBlockedUserAtIndexOptions options);
	EOS_NotificationId EOS_Friends_AddNotifyBlockedUsersUpdate(EOS_Friends_Interface handle,
	                                                           EOS_Friends_AddNotifyBlockedUsersUpdateOptions options,
	                                                           Pointer clientData,
	                                                           EOS_Friends_OnBlockedUsersUpdateCallback blockedUsersUpdateHandler);
	void EOS_Friends_RemoveNotifyBlockedUsersUpdate(EOS_Friends_Interface handle, EOS_NotificationId notificationId);
	
	// Integrated platform
	EOS_EResult EOS_IntegratedPlatformOptionsContainer_Add(EOS_IntegratedPlatformOptionsContainer handle, EOS_IntegratedPlatformOptionsContainer_AddOptions inOptions);
	EOS_EResult EOS_IntegratedPlatform_SetUserLoginStatus(EOS_IntegratedPlatform_Interface handle, EOS_IntegratedPlatform_SetUserLoginStatusOptions options);
	EOS_NotificationId EOS_IntegratedPlatform_AddNotifyUserLoginStatusChanged(EOS_IntegratedPlatform_Interface handle,
	                                                                          EOS_IntegratedPlatform_AddNotifyUserLoginStatusChangedOptions options,
	                                                                          Pointer clientData,
	                                                                          EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback CallbackFunction);
	void EOS_IntegratedPlatform_RemoveNotifyUserLoginStatusChanged(EOS_IntegratedPlatform_Interface handle, EOS_NotificationId NotificationId);
	EOS_EResult EOS_IntegratedPlatform_SetUserPreLogoutCallback(EOS_IntegratedPlatform_Interface handle,
	                                                            EOS_IntegratedPlatform_SetUserPreLogoutCallbackOptions options,
	                                                            Pointer clientData,
	                                                            EOS_IntegratedPlatform_OnUserPreLogoutCallback CallbackFunction);
	void EOS_IntegratedPlatform_ClearUserPreLogoutCallback(EOS_IntegratedPlatform_Interface handle, EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions options);
	EOS_EResult EOS_IntegratedPlatform_FinalizeDeferredUserLogout(EOS_IntegratedPlatform_Interface handle, EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions options);
	EOS_EResult EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer(EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions options, EOS_IntegratedPlatformOptionsContainer outIntegratedPlatformOptionsContainerHandle);
	void EOS_IntegratedPlatformOptionsContainer_Release(EOS_IntegratedPlatformOptionsContainer integratedPlatformOptionsContainerHandle);
	
	// KWS
	void EOS_KWS_QueryAgeGate(EOS_KWS_Interface handle, EOS_KWS_QueryAgeGateOptions options, Pointer clientData, EOS_KWS_OnQueryAgeGateCallback completionDelegate);
	void EOS_KWS_CreateUser(EOS_KWS_Interface handle, EOS_KWS_CreateUserOptions options, Pointer clientData, EOS_KWS_OnCreateUserCallback completionDelegate);
	void EOS_KWS_QueryPermissions(EOS_KWS_Interface handle, EOS_KWS_QueryPermissionsOptions options, Pointer clientData, EOS_KWS_OnQueryPermissionsCallback completionDelegate);
	void EOS_KWS_UpdateParentEmail(EOS_KWS_Interface handle, EOS_KWS_UpdateParentEmailOptions options, Pointer clientData, EOS_KWS_OnUpdateParentEmailCallback completionDelegate);
	void EOS_KWS_RequestPermissions(EOS_KWS_Interface handle, EOS_KWS_RequestPermissionsOptions options, Pointer clientData, EOS_KWS_OnRequestPermissionsCallback completionDelegate);
	int EOS_KWS_GetPermissionsCount(EOS_KWS_Interface handle, EOS_KWS_GetPermissionsCountOptions options);
	EOS_EResult EOS_KWS_CopyPermissionByIndex(EOS_KWS_Interface handle, EOS_KWS_CopyPermissionByIndexOptions options, EOS_KWS_PermissionStatus[] outPermission);
	EOS_EResult EOS_KWS_GetPermissionByKey(EOS_KWS_Interface handle, EOS_KWS_GetPermissionByKeyOptions options, IntBuffer outPermission);
	EOS_NotificationId EOS_KWS_AddNotifyPermissionsUpdateReceived(EOS_KWS_Interface handle,
	                                                              EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions options,
	                                                              Pointer clientData,
	                                                              EOS_KWS_OnPermissionsUpdateReceivedCallback notificationFn);
	void EOS_KWS_RemoveNotifyPermissionsUpdateReceived(EOS_KWS_Interface handle, EOS_NotificationId InId);

	void EOS_KWS_PermissionStatus_Release(EOS_KWS_PermissionStatus permissionStatus);
	
	// Leaderboards
	void EOS_Leaderboards_QueryLeaderboardDefinitions(EOS_Leaderboards_Interface handle, EOS_Leaderboards_QueryLeaderboardDefinitionsOptions options, Pointer clientData, EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallback completionDelegate);
	int EOS_Leaderboards_GetLeaderboardDefinitionCount(EOS_Leaderboards_Interface handle, EOS_Leaderboards_GetLeaderboardDefinitionCountOptions options);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardDefinitionByIndex(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions options, EOS_Leaderboards_Definition[] OutLeaderboardDefinition);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardId(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions options, EOS_Leaderboards_Definition[] OutLeaderboardDefinition);
	void EOS_Leaderboards_QueryLeaderboardRanks(EOS_Leaderboards_Interface handle, EOS_Leaderboards_QueryLeaderboardRanksOptions options, Pointer clientData, EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallback completionDelegate);
	int EOS_Leaderboards_GetLeaderboardRecordCount(EOS_Leaderboards_Interface handle, EOS_Leaderboards_GetLeaderboardRecordCountOptions options);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardRecordByIndex(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions options, EOS_Leaderboards_LeaderboardRecord[] outLeaderboardRecord);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardRecordByUserId(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions options, EOS_Leaderboards_LeaderboardRecord[] outLeaderboardRecord);
	void EOS_Leaderboards_QueryLeaderboardUserScores(EOS_Leaderboards_Interface handle, EOS_Leaderboards_QueryLeaderboardUserScoresOptions options, Pointer clientData, EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallback completionDelegate);
	int EOS_Leaderboards_GetLeaderboardUserScoreCount(EOS_Leaderboards_Interface handle, EOS_Leaderboards_GetLeaderboardUserScoreCountOptions options);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardUserScoreByIndex(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions options, EOS_Leaderboards_LeaderboardUserScore[] outLeaderboardUserScore);
	EOS_EResult EOS_Leaderboards_CopyLeaderboardUserScoreByUserId(EOS_Leaderboards_Interface handle, EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions options, EOS_Leaderboards_LeaderboardUserScore[] outLeaderboardUserScore);
	void EOS_Leaderboards_LeaderboardUserScore_Release(EOS_Leaderboards_LeaderboardUserScore leaderboardUserScore);
	void EOS_Leaderboards_Definition_Release(EOS_Leaderboards_Definition leaderboardDefinition);
	void EOS_Leaderboards_LeaderboardRecord_Release(EOS_Leaderboards_LeaderboardRecord leaderboardRecord);

	// Metrics
	EOS_EResult EOS_Metrics_BeginPlayerSession(EOS_Metrics_Interface handle, EOS_Metrics_BeginPlayerSessionOptions options);
	EOS_EResult EOS_Metrics_EndPlayerSession(EOS_Metrics_Interface handle, EOS_Metrics_EndPlayerSessionOptions options);
	
	// P2P
	EOS_EResult EOS_P2P_SendPacket(EOS_P2P_Interface handle, EOS_P2P_SendPacketOptions options);
	EOS_EResult EOS_P2P_GetNextReceivedPacketSize(EOS_P2P_Interface handle, EOS_P2P_GetNextReceivedPacketSizeOptions options, IntBuffer outPacketSizeBytes);
	EOS_EResult EOS_P2P_ReceivePacket(EOS_P2P_Interface handle, EOS_P2P_ReceivePacketOptions options, EOS_ProductUserId OutPeerId, EOS_P2P_SocketId OutSocketId, ByteBuffer OutChannel, Pointer OutData, IntBuffer OutBytesWritten);
	EOS_NotificationId EOS_P2P_AddNotifyPeerConnectionRequest(EOS_P2P_Interface handle, EOS_P2P_AddNotifyPeerConnectionRequestOptions options, Pointer clientData, EOS_P2P_OnIncomingConnectionRequestCallback ConnectionRequestHandler);
	void EOS_P2P_RemoveNotifyPeerConnectionRequest(EOS_P2P_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_P2P_AddNotifyPeerConnectionEstablished(EOS_P2P_Interface handle, EOS_P2P_AddNotifyPeerConnectionEstablishedOptions options, Pointer clientData, EOS_P2P_OnPeerConnectionEstablishedCallback ConnectionEstablishedHandler);
	void EOS_P2P_RemoveNotifyPeerConnectionEstablished(EOS_P2P_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_P2P_AddNotifyPeerConnectionInterrupted(EOS_P2P_Interface handle, EOS_P2P_AddNotifyPeerConnectionInterruptedOptions options, Pointer clientData, EOS_P2P_OnPeerConnectionInterruptedCallback connectionInterruptedHandler);
	void EOS_P2P_RemoveNotifyPeerConnectionInterrupted(EOS_P2P_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_P2P_AddNotifyPeerConnectionClosed(EOS_P2P_Interface handle, EOS_P2P_AddNotifyPeerConnectionClosedOptions options, Pointer clientData, EOS_P2P_OnRemoteConnectionClosedCallback connectionClosedHandler);
	void EOS_P2P_RemoveNotifyPeerConnectionClosed(EOS_P2P_Interface handle, EOS_NotificationId NotificationId);
	EOS_EResult EOS_P2P_AcceptConnection(EOS_P2P_Interface handle, EOS_P2P_AcceptConnectionOptions options);
	EOS_EResult EOS_P2P_CloseConnection(EOS_P2P_Interface handle, EOS_P2P_CloseConnectionOptions options);
	EOS_EResult EOS_P2P_CloseConnections(EOS_P2P_Interface handle, EOS_P2P_CloseConnectionsOptions options);
	void EOS_P2P_QueryNATType(EOS_P2P_Interface handle, EOS_P2P_QueryNATTypeOptions options, Pointer clientData, EOS_P2P_OnQueryNATTypeCompleteCallback completionDelegate);
	EOS_EResult EOS_P2P_GetNATType(EOS_P2P_Interface handle, EOS_P2P_GetNATTypeOptions options, IntBuffer outNATType);
	EOS_EResult EOS_P2P_SetRelayControl(EOS_P2P_Interface handle, EOS_P2P_SetRelayControlOptions options);
	EOS_EResult EOS_P2P_GetRelayControl(EOS_P2P_Interface handle, EOS_P2P_GetRelayControlOptions options, IntBuffer outRelayControl);
	EOS_EResult EOS_P2P_SetPortRange(EOS_P2P_Interface handle, EOS_P2P_SetPortRangeOptions options);
	EOS_EResult EOS_P2P_GetPortRange(EOS_P2P_Interface handle, EOS_P2P_GetPortRangeOptions options, ShortByReference outPort, ShortByReference outNumAdditionalPortsToTry);
	EOS_EResult EOS_P2P_SetPacketQueueSize(EOS_P2P_Interface handle, EOS_P2P_SetPacketQueueSizeOptions options);
	EOS_EResult EOS_P2P_GetPacketQueueInfo(EOS_P2P_Interface handle, EOS_P2P_GetPacketQueueInfoOptions options, EOS_P2P_PacketQueueInfo OutPacketQueueInfo);
	EOS_NotificationId EOS_P2P_AddNotifyIncomingPacketQueueFull(EOS_P2P_Interface handle, EOS_P2P_AddNotifyIncomingPacketQueueFullOptions options, Pointer clientData, EOS_P2P_OnIncomingPacketQueueFullCallback incomingPacketQueueFullHandler);
	void EOS_P2P_RemoveNotifyIncomingPacketQueueFull(EOS_P2P_Interface handle, EOS_NotificationId NotificationId);
	EOS_EResult EOS_P2P_ClearPacketQueue(EOS_P2P_Interface handle, EOS_P2P_ClearPacketQueueOptions options);

	// Player Datastorage
	void EOS_PlayerDataStorage_QueryFile(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_QueryFileOptions QueryFileOptions, Pointer ClientData, EOS_PlayerDataStorage_OnQueryFileCompleteCallback CompletionCallback);
	void EOS_PlayerDataStorage_QueryFileList(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_QueryFileListOptions QueryFileListOptions, Pointer clientData, EOS_PlayerDataStorage_OnQueryFileListCompleteCallback CompletionCallback);
	EOS_EResult EOS_PlayerDataStorage_CopyFileMetadataByFilename(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions CopyFileMetadataOptions, EOS_PlayerDataStorage_FileMetadata[] OutMetadata);
	EOS_EResult EOS_PlayerDataStorage_GetFileMetadataCount(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_GetFileMetadataCountOptions GetFileMetadataCountOptions, IntBuffer OutFileMetadataCount);
	EOS_EResult EOS_PlayerDataStorage_CopyFileMetadataAtIndex(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions copyFileMetadataOptions, EOS_PlayerDataStorage_FileMetadata[] outMetadata);
	void EOS_PlayerDataStorage_DuplicateFile(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_DuplicateFileOptions DuplicateOptions, Pointer clientData, EOS_PlayerDataStorage_OnDuplicateFileCompleteCallback CompletionCallback);
	void EOS_PlayerDataStorage_DeleteFile(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_DeleteFileOptions DeleteOptions, Pointer clientData, EOS_PlayerDataStorage_OnDeleteFileCompleteCallback CompletionCallback);
	EOS_PlayerDataStorageFileTransferRequest EOS_PlayerDataStorage_ReadFile(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_ReadFileOptions ReadOptions, Pointer clientData, EOS_PlayerDataStorage_OnReadFileCompleteCallback CompletionCallback);
	EOS_PlayerDataStorageFileTransferRequest EOS_PlayerDataStorage_WriteFile(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_WriteFileOptions WriteOptions, Pointer clientData, EOS_PlayerDataStorage_OnWriteFileCompleteCallback CompletionCallback);
	EOS_EResult EOS_PlayerDataStorage_DeleteCache(EOS_PlayerDataStorage_Interface handle, EOS_PlayerDataStorage_DeleteCacheOptions Options, Pointer clientData, EOS_PlayerDataStorage_OnDeleteCacheCompleteCallback CompletionCallback);
	EOS_EResult EOS_PlayerDataStorageFileTransferRequest_GetFileRequestState(EOS_PlayerDataStorageFileTransferRequest handle);
	EOS_EResult EOS_PlayerDataStorageFileTransferRequest_GetFilename(EOS_PlayerDataStorageFileTransferRequest handle, int FilenameStringBufferSizeBytes, ByteBuffer OutStringBuffer, IntBuffer OutStringLength);
	EOS_EResult EOS_PlayerDataStorageFileTransferRequest_CancelRequest(EOS_PlayerDataStorageFileTransferRequest handle);
	void EOS_PlayerDataStorage_FileMetadata_Release(EOS_PlayerDataStorage_FileMetadata fileMetadata);
	void EOS_PlayerDataStorageFileTransferRequest_Release(EOS_PlayerDataStorageFileTransferRequest playerDataStorageFileTransferHandle);
	
	// Presence
	void EOS_Presence_QueryPresence(EOS_Presence_Interface handle, EOS_Presence_QueryPresenceOptions options, Pointer clientData, EOS_Presence_OnQueryPresenceCompleteCallback completionDelegate);
	int EOS_Presence_HasPresence(EOS_Presence_Interface handle, EOS_Presence_HasPresenceOptions options);
	EOS_EResult EOS_Presence_CopyPresence(EOS_Presence_Interface handle, EOS_Presence_CopyPresenceOptions options, EOS_Presence_Info[] OutPresence);
	EOS_EResult EOS_Presence_CreatePresenceModification(EOS_Presence_Interface handle, EOS_Presence_CreatePresenceModificationOptions options, EOS_PresenceModification OutPresenceModificationHandle);
	void EOS_Presence_SetPresence(EOS_Presence_Interface handle, EOS_Presence_SetPresenceOptions options, Pointer clientData, EOS_Presence_SetPresenceCompleteCallback completionDelegate);
	EOS_NotificationId EOS_Presence_AddNotifyOnPresenceChanged(EOS_Presence_Interface handle, EOS_Presence_AddNotifyOnPresenceChangedOptions options, Pointer clientData, EOS_Presence_OnPresenceChangedCallback NotificationHandler);
	void EOS_Presence_RemoveNotifyOnPresenceChanged(EOS_Presence_Interface handle, EOS_NotificationId NotificationId);
	EOS_NotificationId EOS_Presence_AddNotifyJoinGameAccepted(EOS_Presence_Interface handle, EOS_Presence_AddNotifyJoinGameAcceptedOptions options, Pointer clientData, EOS_Presence_OnJoinGameAcceptedCallback notificationFn);
	void EOS_Presence_RemoveNotifyJoinGameAccepted(EOS_Presence_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_Presence_GetJoinInfo(EOS_Presence_Interface handle, EOS_Presence_GetJoinInfoOptions options, ByteBuffer OutBuffer, IntBuffer InOutBufferLength);
	EOS_EResult EOS_PresenceModification_SetStatus(EOS_PresenceModification handle, EOS_PresenceModification_SetStatusOptions options);
	EOS_EResult EOS_PresenceModification_SetRawRichText(EOS_PresenceModification handle, EOS_PresenceModification_SetRawRichTextOptions options);
	EOS_EResult EOS_PresenceModification_SetData(EOS_PresenceModification handle, EOS_PresenceModification_SetDataOptions options);
	EOS_EResult EOS_PresenceModification_DeleteData(EOS_PresenceModification handle, EOS_PresenceModification_DeleteDataOptions options);
	EOS_EResult EOS_PresenceModification_SetJoinInfo(EOS_PresenceModification handle, EOS_PresenceModification_SetJoinInfoOptions options);
	void EOS_Presence_Info_Release(EOS_Presence_Info presenceInfo);
	void EOS_PresenceModification_Release(EOS_PresenceModification presenceModificationHandle);
	
	// Progression shapshot
	EOS_EResult EOS_ProgressionSnapshot_BeginSnapshot(EOS_ProgressionSnapshot_Interface handle, EOS_ProgressionSnapshot_BeginSnapshotOptions options, IntBuffer outSnapshotId);
	EOS_EResult EOS_ProgressionSnapshot_AddProgression(EOS_ProgressionSnapshot_Interface handle, EOS_ProgressionSnapshot_AddProgressionOptions options);
	void EOS_ProgressionSnapshot_SubmitSnapshot(EOS_ProgressionSnapshot_Interface handle, EOS_ProgressionSnapshot_SubmitSnapshotOptions options, Pointer clientData, EOS_ProgressionSnapshot_OnSubmitSnapshotCallback completionDelegate);
	EOS_EResult EOS_ProgressionSnapshot_EndSnapshot(EOS_ProgressionSnapshot_Interface handle, EOS_ProgressionSnapshot_EndSnapshotOptions options);
	void EOS_ProgressionSnapshot_DeleteSnapshot(EOS_ProgressionSnapshot_Interface handle, EOS_ProgressionSnapshot_DeleteSnapshotOptions options, Pointer clientData, EOS_ProgressionSnapshot_OnDeleteSnapshotCallback completionDelegate);
	
	// Stats
	void EOS_Stats_IngestStat(EOS_Stats_Interface handle, EOS_Stats_IngestStatOptions options, Pointer clientData, EOS_Stats_OnIngestStatCompleteCallback completionDelegate);
	void EOS_Stats_QueryStats(EOS_Stats_Interface handle, EOS_Stats_QueryStatsOptions options, Pointer clientData, EOS_Stats_OnQueryStatsCompleteCallback completionDelegate);
	int EOS_Stats_GetStatsCount(EOS_Stats_Interface handle, EOS_Stats_GetStatCountOptions options);
	EOS_EResult EOS_Stats_CopyStatByIndex(EOS_Stats_Interface handle, EOS_Stats_CopyStatByIndexOptions options, EOS_Stats_Stat[] OutStat);
	EOS_EResult EOS_Stats_CopyStatByName(EOS_Stats_Interface handle, EOS_Stats_CopyStatByNameOptions options, EOS_Stats_Stat[] OutStat);
	void EOS_Stats_Stat_Release(EOS_Stats_Stat stat);
	
	// Title storage
	void EOS_TitleStorage_QueryFile(EOS_TitleStorage_Interface handle, EOS_TitleStorage_QueryFileOptions options, Pointer clientData, EOS_TitleStorage_OnQueryFileCompleteCallback completionCallback);
	void EOS_TitleStorage_QueryFileList(EOS_TitleStorage_Interface handle, EOS_TitleStorage_QueryFileListOptions options, Pointer clientData, EOS_TitleStorage_OnQueryFileListCompleteCallback completionCallback);
	EOS_EResult EOS_TitleStorage_CopyFileMetadataByFilename(EOS_TitleStorage_Interface handle, EOS_TitleStorage_CopyFileMetadataByFilenameOptions options, EOS_TitleStorage_FileMetadata[] outMetadata);
	int EOS_TitleStorage_GetFileMetadataCount(EOS_TitleStorage_Interface handle, EOS_TitleStorage_GetFileMetadataCountOptions options);
	EOS_EResult EOS_TitleStorage_CopyFileMetadataAtIndex(EOS_TitleStorage_Interface handle, EOS_TitleStorage_CopyFileMetadataAtIndexOptions options, EOS_TitleStorage_FileMetadata[] outMetadata);
	EOS_TitleStorageFileTransferRequest EOS_TitleStorage_ReadFile(EOS_TitleStorage_Interface handle, EOS_TitleStorage_ReadFileOptions options, Pointer clientData, EOS_TitleStorage_OnReadFileCompleteCallback completionCallback);
	EOS_EResult EOS_TitleStorage_DeleteCache(EOS_TitleStorage_Interface handle, EOS_TitleStorage_DeleteCacheOptions options, Pointer clientData, EOS_TitleStorage_OnDeleteCacheCompleteCallback completionCallback);
	EOS_EResult EOS_TitleStorageFileTransferRequest_GetFileRequestState(EOS_TitleStorageFileTransferRequest handle);
	EOS_EResult EOS_TitleStorageFileTransferRequest_GetFilename(EOS_TitleStorageFileTransferRequest handle, int filenameStringBufferSizeBytes, ByteBuffer outStringBuffer, IntBuffer outStringLength);
	EOS_EResult EOS_TitleStorageFileTransferRequest_CancelRequest(EOS_TitleStorageFileTransferRequest handle);
	void EOS_TitleStorageFileTransferRequest_Release(EOS_TitleStorageFileTransferRequest titleStorageFileTransferHandle);
	void EOS_TitleStorage_FileMetadata_Release(EOS_TitleStorage_FileMetadata fileMetadata);
	
	// User Info
	void EOS_UserInfo_QueryUserInfo(EOS_UserInfo_Interface handle, EOS_UserInfo_QueryUserInfoOptions options, Pointer clientData, EOS_UserInfo_OnQueryUserInfoCallback completionDelegate);
	void EOS_UserInfo_QueryUserInfoByDisplayName(EOS_UserInfo_Interface handle, EOS_UserInfo_QueryUserInfoByDisplayNameOptions options, Pointer clientData, EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback completionDelegate);
	void EOS_UserInfo_QueryUserInfoByExternalAccount(EOS_UserInfo_Interface handle, EOS_UserInfo_QueryUserInfoByExternalAccountOptions options, Pointer clientData, EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback completionDelegate);
	EOS_EResult EOS_UserInfo_CopyUserInfo(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyUserInfoOptions options, EOS_UserInfo[] OutUserInfo);
	int EOS_UserInfo_GetExternalUserInfoCount(EOS_UserInfo_Interface handle, EOS_UserInfo_GetExternalUserInfoCountOptions options);
	EOS_EResult EOS_UserInfo_CopyExternalUserInfoByIndex(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyExternalUserInfoByIndexOptions options, EOS_UserInfo_ExternalUserInfo[] OutExternalUserInfo);
	EOS_EResult EOS_UserInfo_CopyExternalUserInfoByAccountType(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions options, EOS_UserInfo_ExternalUserInfo[] OutExternalUserInfo);
	EOS_EResult EOS_UserInfo_CopyExternalUserInfoByAccountId(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyExternalUserInfoByAccountIdOptions options, EOS_UserInfo_ExternalUserInfo[] OutExternalUserInfo);
	EOS_EResult EOS_UserInfo_CopyBestDisplayName(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyBestDisplayNameOptions options, EOS_UserInfo_BestDisplayName[] OutBestDisplayName);
	EOS_EResult EOS_UserInfo_CopyBestDisplayNameWithPlatform(EOS_UserInfo_Interface handle, EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions options, EOS_UserInfo_BestDisplayName[] OutBestDisplayName);
	EOS_OnlinePlatformType EOS_UserInfo_GetLocalPlatformType(EOS_UserInfo_Interface handle, EOS_UserInfo_GetLocalPlatformTypeOptions options);
	void EOS_UserInfo_ExternalUserInfo_Release(EOS_UserInfo_ExternalUserInfo externalUserInfo);
	void EOS_UserInfo_Release(EOS_UserInfo userInfo);
	void EOS_UserInfo_BestDisplayName_Release(EOS_UserInfo_BestDisplayName bestDisplayName);

	// Sessions
	EOS_EResult EOS_Sessions_CreateSessionModification(EOS_Sessions_Interface handle, EOS_Sessions_CreateSessionModificationOptions options, EOS_SessionModification OutSessionModificationHandle);
	EOS_EResult EOS_Sessions_UpdateSessionModification(EOS_Sessions_Interface handle, EOS_Sessions_UpdateSessionModificationOptions options, EOS_SessionModification OutSessionModificationHandle);
	void EOS_Sessions_UpdateSession(EOS_Sessions_Interface handle, EOS_Sessions_UpdateSessionOptions options, Pointer ClientData, EOS_Sessions_OnUpdateSessionCallback completionDelegate);
	void EOS_Sessions_DestroySession(EOS_Sessions_Interface handle, EOS_Sessions_DestroySessionOptions options, Pointer ClientData, EOS_Sessions_OnDestroySessionCallback completionDelegate);
	void EOS_Sessions_JoinSession(EOS_Sessions_Interface handle, EOS_Sessions_JoinSessionOptions options, Pointer ClientData, EOS_Sessions_OnJoinSessionCallback completionDelegate);
	void EOS_Sessions_StartSession(EOS_Sessions_Interface handle, EOS_Sessions_StartSessionOptions options, Pointer ClientData, EOS_Sessions_OnStartSessionCallback completionDelegate);
	void EOS_Sessions_EndSession(EOS_Sessions_Interface handle, EOS_Sessions_EndSessionOptions options, Pointer ClientData, EOS_Sessions_OnEndSessionCallback completionDelegate);
	void EOS_Sessions_RegisterPlayers(EOS_Sessions_Interface handle, EOS_Sessions_RegisterPlayersOptions options, Pointer ClientData, EOS_Sessions_OnRegisterPlayersCallback completionDelegate);
	void EOS_Sessions_UnregisterPlayers(EOS_Sessions_Interface handle, EOS_Sessions_UnregisterPlayersOptions options, Pointer ClientData, EOS_Sessions_OnUnregisterPlayersCallback completionDelegate);
	void EOS_Sessions_SendInvite(EOS_Sessions_Interface handle, EOS_Sessions_SendInviteOptions options, Pointer ClientData, EOS_Sessions_OnSendInviteCallback completionDelegate);
	void EOS_Sessions_RejectInvite(EOS_Sessions_Interface handle, EOS_Sessions_RejectInviteOptions options, Pointer ClientData, EOS_Sessions_OnRejectInviteCallback completionDelegate);
	void EOS_Sessions_QueryInvites(EOS_Sessions_Interface handle, EOS_Sessions_QueryInvitesOptions options, Pointer ClientData, EOS_Sessions_OnQueryInvitesCallback completionDelegate);
	int EOS_Sessions_GetInviteCount(EOS_Sessions_Interface handle, EOS_Sessions_GetInviteCountOptions options);
	EOS_EResult EOS_Sessions_GetInviteIdByIndex(EOS_Sessions_Interface handle, EOS_Sessions_GetInviteIdByIndexOptions options, ByteBuffer OutBuffer, IntBuffer InOutBufferLength);
	EOS_EResult EOS_Sessions_CreateSessionSearch(EOS_Sessions_Interface handle, EOS_Sessions_CreateSessionSearchOptions options, EOS_SessionSearch OutSessionSearchHandle);
	EOS_EResult EOS_Sessions_CopyActiveSessionHandle(EOS_Sessions_Interface handle, EOS_Sessions_CopyActiveSessionHandleOptions options, EOS_ActiveSession OutSessionHandle);
	EOS_NotificationId EOS_Sessions_AddNotifySessionInviteReceived(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifySessionInviteReceivedOptions options, Pointer ClientData, EOS_Sessions_OnSessionInviteReceivedCallback notificationFn);
	void EOS_Sessions_RemoveNotifySessionInviteReceived(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Sessions_AddNotifySessionInviteAccepted(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifySessionInviteAcceptedOptions options, Pointer ClientData, EOS_Sessions_OnSessionInviteAcceptedCallback notificationFn);
	void EOS_Sessions_RemoveNotifySessionInviteAccepted(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Sessions_AddNotifySessionInviteRejected(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifySessionInviteRejectedOptions options, Pointer ClientData, EOS_Sessions_OnSessionInviteRejectedCallback notificationFn);
	void EOS_Sessions_RemoveNotifySessionInviteRejected(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Sessions_AddNotifyJoinSessionAccepted(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifyJoinSessionAcceptedOptions options, Pointer ClientData, EOS_Sessions_OnJoinSessionAcceptedCallback notificationFn);
	void EOS_Sessions_RemoveNotifyJoinSessionAccepted(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_Sessions_CopySessionHandleByInviteId(EOS_Sessions_Interface handle, EOS_Sessions_CopySessionHandleByInviteIdOptions options, EOS_SessionDetails OutSessionHandle);
	EOS_EResult EOS_Sessions_CopySessionHandleByUiEventId(EOS_Sessions_Interface handle, EOS_Sessions_CopySessionHandleByUiEventIdOptions options, EOS_SessionDetails OutSessionHandle);
	EOS_EResult EOS_Sessions_CopySessionHandleForPresence(EOS_Sessions_Interface handle, EOS_Sessions_CopySessionHandleForPresenceOptions options, EOS_SessionDetails OutSessionHandle);
	EOS_EResult EOS_Sessions_IsUserInSession(EOS_Sessions_Interface handle, EOS_Sessions_IsUserInSessionOptions options);
	EOS_EResult EOS_Sessions_DumpSessionState(EOS_Sessions_Interface handle, EOS_Sessions_DumpSessionStateOptions options);
	EOS_NotificationId EOS_Sessions_AddNotifyLeaveSessionRequested(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifyLeaveSessionRequestedOptions options, Pointer ClientData, EOS_Sessions_OnLeaveSessionRequestedCallback notificationFn);
	void EOS_Sessions_RemoveNotifyLeaveSessionRequested(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_NotificationId EOS_Sessions_AddNotifySendSessionNativeInviteRequested(EOS_Sessions_Interface handle, EOS_Sessions_AddNotifySendSessionNativeInviteRequestedOptions options, Pointer ClientData, EOS_Sessions_OnSendSessionNativeInviteRequestedCallback notificationFn);
	void EOS_Sessions_RemoveNotifySendSessionNativeInviteRequested(EOS_Sessions_Interface handle, EOS_NotificationId InId);
	EOS_EResult EOS_SessionModification_SetBucketId(EOS_SessionModification handle, EOS_SessionModification_SetBucketIdOptions options);
	EOS_EResult EOS_SessionModification_SetHostAddress(EOS_SessionModification handle, EOS_SessionModification_SetHostAddressOptions options);
	EOS_EResult EOS_SessionModification_SetPermissionLevel(EOS_SessionModification handle, EOS_SessionModification_SetPermissionLevelOptions options);
	EOS_EResult EOS_SessionModification_SetJoinInProgressAllowed(EOS_SessionModification handle, EOS_SessionModification_SetJoinInProgressAllowedOptions options);
	EOS_EResult EOS_SessionModification_SetMaxPlayers(EOS_SessionModification handle, EOS_SessionModification_SetMaxPlayersOptions options);
	EOS_EResult EOS_SessionModification_SetInvitesAllowed(EOS_SessionModification handle, EOS_SessionModification_SetInvitesAllowedOptions options);
	EOS_EResult EOS_SessionModification_SetAllowedPlatformIds(EOS_SessionModification handle, EOS_SessionModification_SetAllowedPlatformIdsOptions options);
	EOS_EResult EOS_SessionModification_AddAttribute(EOS_SessionModification handle, EOS_SessionModification_AddAttributeOptions options);
	EOS_EResult EOS_SessionModification_RemoveAttribute(EOS_SessionModification handle, EOS_SessionModification_RemoveAttributeOptions options);
	EOS_EResult EOS_ActiveSession_CopyInfo(EOS_ActiveSession handle, EOS_ActiveSession_CopyInfoOptions options, EOS_ActiveSession_Info[] OutActiveSessionInfo);
	int EOS_ActiveSession_GetRegisteredPlayerCount(EOS_ActiveSession handle, EOS_ActiveSession_GetRegisteredPlayerCountOptions options);
	EOS_ProductUserId EOS_ActiveSession_GetRegisteredPlayerByIndex(EOS_ActiveSession handle, EOS_ActiveSession_GetRegisteredPlayerByIndexOptions options);
	EOS_EResult EOS_SessionDetails_CopyInfo(EOS_SessionDetails handle, EOS_SessionDetails_CopyInfoOptions options, EOS_SessionDetails_Info[] OutSessionInfo);
	int EOS_SessionDetails_GetSessionAttributeCount(EOS_SessionDetails handle, EOS_SessionDetails_GetSessionAttributeCountOptions options);
	EOS_EResult EOS_SessionDetails_CopySessionAttributeByIndex(EOS_SessionDetails handle, EOS_SessionDetails_CopySessionAttributeByIndexOptions options, EOS_SessionDetails_Attribute[] OutSessionAttribute);
	EOS_EResult EOS_SessionDetails_CopySessionAttributeByKey(EOS_SessionDetails handle, EOS_SessionDetails_CopySessionAttributeByKeyOptions options, EOS_SessionDetails_Attribute[] OutSessionAttribute);
	EOS_EResult EOS_SessionSearch_SetSessionId(EOS_SessionSearch handle, EOS_SessionSearch_SetSessionIdOptions options);
	EOS_EResult EOS_SessionSearch_SetTargetUserId(EOS_SessionSearch handle, EOS_SessionSearch_SetTargetUserIdOptions options);
	EOS_EResult EOS_SessionSearch_SetParameter(EOS_SessionSearch handle, EOS_SessionSearch_SetParameterOptions options);
	EOS_EResult EOS_SessionSearch_RemoveParameter(EOS_SessionSearch handle, EOS_SessionSearch_RemoveParameterOptions options);
	EOS_EResult EOS_SessionSearch_SetMaxResults(EOS_SessionSearch handle, EOS_SessionSearch_SetMaxResultsOptions options);
	void EOS_SessionSearch_Find(EOS_SessionSearch handle, EOS_SessionSearch_FindOptions options, Pointer ClientData, EOS_SessionSearch_OnFindCallback completionDelegate);
	int EOS_SessionSearch_GetSearchResultCount(EOS_SessionSearch handle, EOS_SessionSearch_GetSearchResultCountOptions options);
	EOS_EResult EOS_SessionSearch_CopySearchResultByIndex(EOS_SessionSearch handle, EOS_SessionSearch_CopySearchResultByIndexOptions options, EOS_SessionDetails OutSessionHandle);
	void EOS_SessionModification_Release(EOS_SessionModification SessionModificationHandle);
	void EOS_ActiveSession_Release(EOS_ActiveSession ActiveSessionHandle);
	void EOS_SessionDetails_Release(EOS_SessionDetails SessionHandle);
	void EOS_SessionSearch_Release(EOS_SessionSearch SessionSearchHandle);
	void EOS_ActiveSession_Info_Release(EOS_ActiveSession_Info activeSessionInfo);
	void EOS_SessionDetails_Info_Release(EOS_SessionDetails_Info sessionInfo);
	void EOS_SessionDetails_Attribute_Release(EOS_SessionDetails_Attribute sessionAttribute);
	
	// UI
	void EOS_UI_ShowFriends(EOS_UI_Interface handle, EOS_UI_ShowFriendsOptions options, Pointer clientData, EOS_UI_OnShowFriendsCallback completionDelegate);
	void EOS_UI_HideFriends(EOS_UI_Interface handle, EOS_UI_HideFriendsOptions options, Pointer clientData, EOS_UI_OnHideFriendsCallback completionDelegate);
	int EOS_UI_GetFriendsVisible(EOS_UI_Interface handle, EOS_UI_GetFriendsVisibleOptions options);
	int EOS_UI_GetFriendsExclusiveInput(EOS_UI_Interface handle, EOS_UI_GetFriendsExclusiveInputOptions options);
	EOS_NotificationId EOS_UI_AddNotifyDisplaySettingsUpdated(EOS_UI_Interface handle, EOS_UI_AddNotifyDisplaySettingsUpdatedOptions options, Pointer clientData, EOS_UI_OnDisplaySettingsUpdatedCallback notificationFn);
	void EOS_UI_RemoveNotifyDisplaySettingsUpdated(EOS_UI_Interface handle, EOS_NotificationId Id);
	EOS_EResult EOS_UI_SetToggleFriendsKey(EOS_UI_Interface handle, EOS_UI_SetToggleFriendsKeyOptions options);
	EOS_UI_EKeyCombination EOS_UI_GetToggleFriendsKey(EOS_UI_Interface handle, EOS_UI_GetToggleFriendsKeyOptions options);
	int EOS_UI_IsValidKeyCombination(EOS_UI_Interface handle, EOS_UI_EKeyCombination keyCombination);
	EOS_EResult EOS_UI_SetToggleFriendsButton(EOS_UI_Interface handle, EOS_UI_SetToggleFriendsButtonOptions options);
	EOS_UI_EInputStateButtonFlags EOS_UI_GetToggleFriendsButton(EOS_UI_Interface handle, EOS_UI_GetToggleFriendsButtonOptions options);
	int EOS_UI_IsValidButtonCombination(EOS_UI_Interface handle, EOS_UI_EInputStateButtonFlags buttonCombination);
	EOS_EResult EOS_UI_SetDisplayPreference(EOS_UI_Interface handle, EOS_UI_SetDisplayPreferenceOptions options);
	EOS_UI_ENotificationLocation EOS_UI_GetNotificationLocationPreference(EOS_UI_Interface handle);
	EOS_EResult EOS_UI_AcknowledgeEventId(EOS_UI_Interface handle, EOS_UI_AcknowledgeEventIdOptions options);
	EOS_EResult EOS_UI_ReportInputState(EOS_UI_Interface handle, EOS_UI_ReportInputStateOptions options);
	EOS_EResult EOS_UI_PrePresent(EOS_UI_Interface handle, EOS_UI_PrePresentOptions options);
	void EOS_UI_ShowBlockPlayer(EOS_UI_Interface handle, EOS_UI_ShowBlockPlayerOptions options, Pointer clientData, EOS_UI_OnShowBlockPlayerCallback completionDelegate);
	void EOS_UI_ShowReportPlayer(EOS_UI_Interface handle, EOS_UI_ShowReportPlayerOptions options, Pointer clientData, EOS_UI_OnShowReportPlayerCallback completionDelegate);
	EOS_EResult EOS_UI_PauseSocialOverlay(EOS_UI_Interface handle, EOS_UI_PauseSocialOverlayOptions options);
	int EOS_UI_IsSocialOverlayPaused(EOS_UI_Interface handle, EOS_UI_IsSocialOverlayPausedOptions options);
	EOS_NotificationId EOS_UI_AddNotifyMemoryMonitor(EOS_UI_Interface handle, EOS_UI_AddNotifyMemoryMonitorOptions options, Pointer clientData, EOS_UI_OnMemoryMonitorCallback notificationFn);
	void EOS_UI_RemoveNotifyMemoryMonitor(EOS_UI_Interface handle, EOS_NotificationId Id);
	void EOS_UI_ShowNativeProfile(EOS_UI_Interface handle, EOS_UI_ShowNativeProfileOptions options, Pointer clientData, EOS_UI_OnShowNativeProfileCallback completionDelegate);
}