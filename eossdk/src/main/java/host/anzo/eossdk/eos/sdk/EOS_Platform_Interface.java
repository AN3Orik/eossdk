package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSLimitExceededException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EApplicationStatus;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ENetworkStatus;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.platform.EOS_Platform_DesktopCrossplayStatusInfo;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_GetDesktopCrossplayStatusOptions;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;

/**
 * The Platform Instance is used to gain access to all other Epic Online Service interfaces and to drive internal operations through the Tick.
 * All Platform Instance calls take a handle of type EOS_HPlatform as the first parameter.
 * EOS_HPlatform handles are created by calling EOS_Platform_Create and subsequently released by calling EOS_Platform_Release.
 *
 * @author Anton Lasevich
 * @since 8/6/2023
 * @see EOS#EOS_Initialize(EOS_InitializeOptions)
 * @see EOS#EOS_Platform_Create(EOS_Platform_Options)
 * @see #release()
 * @see EOS#EOS_Shutdown()
 */

public class EOS_Platform_Interface extends PointerType {
	public EOS_Platform_Interface(Pointer address) {
		super(address);
	}

	public EOS_Platform_Interface() {
		super();
	}

	/**
	 * Release an Epic Online Services platform instance previously returned from EOS_Platform_Create.
	 * <p>
	 * This function should only be called once per instance returned by EOS_Platform_Create. Undefined behavior will result in calling it with a single instance more than once.
	 * Typically only a single platform instance needs to be created during the lifetime of a game.
	 * You should release each platform instance before calling the EOS_Shutdown function.
	 */
	public void release() {
		EOSLibrary.instance.EOS_Platform_Release(this);
	}

	/**
	 * Notify the platform instance to do work. This function must be called frequently in order for the services provided by the SDK to properly
	 * function. For tick-based applications, it is usually desirable to call this once per-tick.
	 */
	public void tick() {
		EOSLibrary.instance.EOS_Platform_Tick(this);
	}

	/**
	 * Get a handle to the Connect Interface.
	 * @return EOS_Connect_Interface handle
	 */
	public EOS_Connect_Interface getConnectInterface() {
		return EOSLibrary.instance.EOS_Platform_GetConnectInterface(this);
	}

	/**
	 * Get a handle to the Auth Interface.
	 * @return EOS_Auth_Interface handle
	 */
	public EOS_Auth_Interface getAuthInterface() {
		return EOSLibrary.instance.EOS_Platform_GetAuthInterface(this);
	}

	/**
	 * Get a handle to the Anti-Cheat Server Interface.
	 * @return EOS_AntiCheatServer_Interface handle
	 */
	public EOS_AntiCheatServer_Interface getAntiCheatServerInterface() {
		return EOSLibrary.instance.EOS_Platform_GetAntiCheatServerInterface(this);
	}

	/**
	 * Get a handle to the Anti-Cheat Client Interface.
	 * @return EOS_AntiCheatClient_Interface handle
	 */
	public EOS_AntiCheatClient_Interface getAntiCheatClientInterface() {
		return EOSLibrary.instance.EOS_Platform_GetAntiCheatClientInterface(this);
	}

	/**
	 * Get a handle to the Mods Interface.
	 * @return EOS_Mods_Interface handle
	 */
	public EOS_Mods_Interface getModsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetModsInterface(this);
	}

	/**
	 * Get a handle to the Lobby Interface.
	 * @return EOS_Lobby_Interface handle
	 */
	public EOS_Lobby_Interface getLobbyInterface() {
		return EOSLibrary.instance.EOS_Platform_GetLobbyInterface(this);
	}

	/**
	 * Get a handle to the Reports Interface.
	 * @return EOS_Reports_Interface handle
	 */
	public EOS_Reports_Interface getReportsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetReportsInterface(this);
	}

	/**
	 * Get a handle to the Sanctions Interface.
	 * @return EOS_Sanctions_Interface handle
	 */
	public EOS_Sanctions_Interface getSanctionsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetSanctionsInterface(this);
	}

	/**
	 * Get a handle to the Achievements Interface.
	 * @return EOS_Achievements_Interface handle
	 */
	public EOS_Achievements_Interface getAchievementsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetAchievementsInterface(this);
	}

	/**
	 * Get a handle to the Custom Invites Interface.
	 * @return EOS_CustomInvites_Interface handle
	 */
	public EOS_CustomInvites_Interface getCustomInvitesInterface() {
		return EOSLibrary.instance.EOS_Platform_GetCustomInvitesInterface(this);
	}

	/**
	 * Get a handle to the Ecom Interface.
	 * @return EOS_Ecom_Interface handle
	 */
	public EOS_Ecom_Interface getEcomInterface() {
		return EOSLibrary.instance.EOS_Platform_GetEcomInterface(this);
	}

	/**
	 * Get a handle to the Friends Interface.
	 * @return EOS_Friends_Interface handle
	 */
	public EOS_Friends_Interface getFriendsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetFriendsInterface(this);
	}

	/**
	 * Get a handle to the Integrated Platform Interface.
	 * @return EOS_IntegratedPlatform_Interface handle
	 */
	public EOS_IntegratedPlatform_Interface getIntegratedPlatformInterface() {
		return EOSLibrary.instance.EOS_Platform_GetIntegratedPlatformInterface(this);
	}

	/**
	 * Get a handle to the Kids Web Service Interface.
	 * @return EOS_KWS_Interface handle
	 */
	public EOS_KWS_Interface getKWSInterface() {
		return EOSLibrary.instance.EOS_Platform_GetKWSInterface(this);
	}

	/**
	 * Get a handle to the Leaderboards Interface.
	 * @return EOS_Leaderboards_Interface handle
	 */
	public EOS_Leaderboards_Interface getLeaderboardsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetLeaderboardsInterface(this);
	}

	/**
	 * Get a handle to the Metrics Interface.
	 * @return EOS_Metrics_Interface handle
	 */
	public EOS_Metrics_Interface getMetricsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetMetricsInterface(this);
	}

	/**
	 * Get a handle to the Peer-to-Peer Networking Interface.
	 * @return EOS_P2P handle
	 */
	public EOS_P2P_Interface getP2PInterface() {
		return EOSLibrary.instance.EOS_Platform_GetP2PInterface(this);
	}

	/**
	 * Get a handle to the PlayerDataStorage Interface.
	 * @return EOS_PlayerDataStoragev handle
	 */
	public EOS_PlayerDataStorage_Interface getPlayerDataStorageInterface() {
		return EOSLibrary.instance.EOS_Platform_GetPlayerDataStorageInterface(this);
	}

	/**
	 * Get a handle to the Presence Interface.
	 * @return EOS_Presence_Interface handle
	 */
	public EOS_Presence_Interface getPresenceInterface() {
		return EOSLibrary.instance.EOS_Platform_GetPresenceInterface(this);
	}

	/**
	 * Get the active country code that the SDK will send to services which require it.
	 * This returns the override value otherwise it will use the country code of the given user.
	 * This is currently used for determining pricing.
	 * Get a handle to the ProgressionSnapshot Interface.
	 * @return EOS_ProgressionSnapshot_Interface handle
	 */
	public EOS_ProgressionSnapshot_Interface getProgressionSnapshotInterface() {
		return EOSLibrary.instance.EOS_Platform_GetProgressionSnapshotInterface(this);
	}

	/**
	 * Get a handle to the Stats Interface.
	 * @return EOS_Stats handle
	 */
	public EOS_Stats_Interface getStatsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetStatsInterface(this);
	}

	/**
	 * Get a handle to the TitleStorage Interface.
	 * @return EOS_TitleStorage_Interface handle
	 */
	public EOS_TitleStorage_Interface getTitleStorageInterface() {
		return EOSLibrary.instance.EOS_Platform_GetTitleStorageInterface(this);
	}

	/**
	 * Get a handle to the UserInfo Interface.
	 * @return EOS_UserInfo_Interface handle
	 */
	public EOS_UserInfo_Interface getUserInfoInterface() {
		return EOSLibrary.instance.EOS_Platform_GetUserInfoInterface(this);
	}

	/**
	 * Get a handle to the Sessions Interface.
	 * @return EOS_Sessions_Interface handle
	 */
	public EOS_Sessions_Interface getSessionsInterface() {
		return EOSLibrary.instance.EOS_Platform_GetSessionsInterface(this);
	}

	/**
	 * Get a handle to the UI Interface.
	 * @return EOS_UI_Interface handle
	 */
	public EOS_UI_Interface getUIInterface() {
		return EOSLibrary.instance.EOS_Platform_GetUIInterface(this);
	}

	/**
	 * Get a handle to the RTC Interface.
	 * @return EOS_RTC_Interface handle
	 */
	public EOS_RTC_Interface getRTCInterface() {
		return EOSLibrary.instance.EOS_Platform_GetRTCInterface(this);
	}

	/**
	 * Get a handle to the RTC Admin Interface.
	 * @return EOS_RTC_Admin_Interface handle
	 */
	public EOS_RTC_Admin_Interface getRTCAdminInterface() {
		return EOSLibrary.instance.EOS_Platform_GetRTCAdminInterface(this);
	}

	/**
	 * This only will return the value set as the override otherwise EOS_NotFound is returned.
	 * This is not currently used for anything internally.
	 *
	 * @param localUserId The account to use for lookup if no override exists.
	 * @return active country code string
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if there is not an override country code for the user
	 * @throws EOSLimitExceededException The OutBuffer is not large enough to receive the country code string. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 *
	 * @see EOS_Defines#EOS_COUNTRYCODE_MAX_LENGTH
	 */
	public String getActiveCountryCode(EOS_EpicAccountId localUserId) throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_Defines.EOS_COUNTRYCODE_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_Defines.EOS_COUNTRYCODE_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Platform_GetActiveCountryCode(this, localUserId, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}

	/**
	 * Get the active locale code that the SDK will send to services which require it.
	 * This returns the override value otherwise it will use the locale code of the given user.
	 * This is used for localization. This follows ISO 639.
	 *
	 * @param localUserId The account to use for lookup if no override exists.
	 * @return active locale code string
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if there is neither an override nor an available locale code for the user
	 * @throws EOSLimitExceededException if there is neither an override nor an available locale code for the user
	 *
	 * @see EOS_Defines#EOS_LOCALECODE_MAX_LENGTH
	 */
	public String getActiveLocaleCode(EOS_EpicAccountId localUserId) throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_Defines.EOS_LOCALECODE_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_Defines.EOS_LOCALECODE_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Platform_GetActiveLocaleCode(this, localUserId, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}

	/**
	 * Get the override country code that the SDK will send to services which require it.
	 * This is not currently used for anything internally.
	 *
	 * @return override country code
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSLimitExceededException The OutBuffer is not large enough to receive the country code string. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 *
	 * @see EOS_Defines#EOS_COUNTRYCODE_MAX_LENGTH
	 */
	public String getOverrideCountryCode() throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_Defines.EOS_COUNTRYCODE_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_Defines.EOS_COUNTRYCODE_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Platform_GetOverrideCountryCode(this, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}

	/**
	 * Get the override locale code that the SDK will send to services which require it.
	 * This is used for localization. This follows ISO 639.
	 *
	 * @return override local code string
	 *
	 * @throws EOSInvalidParametersException override locale code string
	 * @throws EOSLimitExceededException The OutBuffer is not large enough to receive the locale code string. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 *
	 * @see EOS_Defines#EOS_LOCALECODE_MAX_LENGTH
	 */
	public String getOverrideLocaleCode() throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_Defines.EOS_LOCALECODE_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_Defines.EOS_LOCALECODE_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Platform_GetOverrideLocaleCode(this, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}

	/**
	 * Set the override country code that the SDK will send to services which require it.
	 * This is not currently used for anything internally.
	 * @param newCountryCode country code to override
	 * @return An EOS_EResult that indicates whether the override country code string was saved.<br>
	 *         {@link EOS_EResult#EOS_Success} if the country code was overridden<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid country code
	 *
	 * @see EOS_Defines#EOS_COUNTRYCODE_MAX_LENGTH
	 */
	public EOS_EResult setOverrideCountryCode(String newCountryCode) {
		return EOSLibrary.instance.EOS_Platform_SetOverrideCountryCode(this, newCountryCode);
	}

	/**
	 * Set the override locale code that the SDK will send to services which require it.
	 * This is used for localization. This follows ISO 639.
	 * @param newLocaleCode locale code to override
	 * @return An EOS_EResult that indicates whether the override locale code string was saved.<br>
	 *         {@link EOS_EResult#EOS_Success} if the locale code was overridden<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid locale code
	 *
	 * @see EOS_Defines#EOS_LOCALECODE_MAX_LENGTH
	 */
	public EOS_EResult setOverrideLocaleCode(String newLocaleCode) {
		return EOSLibrary.instance.EOS_Platform_SetOverrideLocaleCode(this, newLocaleCode);
	}

	/**
	 * Checks if the app was launched through the Epic Games Launcher, and relaunches it through the Epic Games Launcher if it wasn't.
	 * <p>
	 * NOTE: During the call to EOS_Platform_Create, the command line that was used to launch the app is inspected, and if it is
	 * recognized as coming from the Epic Games Launcher, an environment variable is set to 1. The name of the environment variable
	 * is defined by EOS_PLATFORM_CHECKFORLAUNCHERANDRESTART_ENV_VAR.
	 * <p>
	 * You can force the EOS_Platform_CheckForLauncherAndRestart API to relaunch the title by
	 * explicitly unsetting this environment variable before calling EOS_Platform_CheckForLauncherAndRestart.
	 *
	 * @return An EOS_EResult is returned to indicate success or an error.
	 * <p>
	 * {@link EOS_EResult#EOS_Success} is returned if the app is being restarted. You should quit your process as soon as possible.<br>
	 * {@link EOS_EResult#EOS_NoChange} is returned if the app was already launched through the Epic Launcher, and no action needs to be taken.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} is returned if the LauncherCheck module failed to initialize, or the module tried and failed to restart the app.
	 */
	public EOS_EResult checkForLauncherAndRestart() {
		return EOSLibrary.instance.EOS_Platform_CheckForLauncherAndRestart(this);
	}

	/**
	 * Windows only.
	 * Checks that the application is ready to use desktop crossplay functionality, with the necessary prerequisites having been met.
	 * <p>
	 * This function verifies that the application was launched through the Bootstrapper application,
	 * the redistributable service has been installed and is running in the background,
	 * and that the overlay has been loaded successfully.
	 * <p>
	 * On Windows, the desktop crossplay functionality is required to use Epic accounts login
	 * with applications that are distributed outside the Epic Games Store.
	 *
	 * @param options input structure that specifies the API version.
	 * @param outDesktopCrossplayStatusInfo output structure to receive the desktop crossplay status information.
	 *
	 * @return An EOS_EResult is returned to indicate success or an error.<br>
	 *           {@link EOS_EResult#EOS_NotImplemented} is returned on non-Windows platforms.
	 */
	public EOS_EResult getDesktopCrossplayStatus(EOS_Platform_GetDesktopCrossplayStatusOptions options, EOS_Platform_DesktopCrossplayStatusInfo outDesktopCrossplayStatusInfo) {
		return EOSLibrary.instance.EOS_Platform_GetDesktopCrossplayStatus(this, options, outDesktopCrossplayStatusInfo);
	}

	/**
	 * Notify a change in application state.<br>
	 * <b>Calling SetApplicationStatus must happen before Tick when foregrounding for the cases where we won't get the background notification.</b>
	 *
	 * @param newStatus The new status for the application.
	 *
	 * @return An EOS_EResult that indicates whether we changed the application status successfully.<br>
	 *         {@link EOS_EResult#EOS_Success} if the application was changed successfully.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the value of NewStatus is invalid.v
	 *         {@link EOS_EResult#EOS_NotImplemented} if EOS_AS_BackgroundConstrained or EOS_AS_BackgroundUnconstrained are attempted to be set on platforms that do not have such application states.
	 */
	public EOS_EResult setApplicationStatus(EOS_EApplicationStatus newStatus) {
		return EOSLibrary.instance.EOS_Platform_SetApplicationStatus(this, newStatus);
	}

	/**
	 * Retrieves the current application state as told to the SDK by the application.
	 *
	 * @return The current application status.
	 */
	public EOS_EApplicationStatus getApplicationStatus() {
		return EOSLibrary.instance.EOS_Platform_GetApplicationStatus(this);
	}

	/**
	 * Notify a change in network state.
	 *
	 * @param newStatus The new network status.
	 *
	 * @return An EOS_EResult that indicates whether we changed the network status successfully.<br>
	 *         {@link EOS_EResult#EOS_Success} if the network was changed successfully.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the value of NewStatus is invalid.
	 */
	public EOS_EResult setNetworkStatus(EOS_ENetworkStatus newStatus) {
		return EOSLibrary.instance.EOS_Platform_SetNetworkStatus(this, newStatus);
	}

	/**
	 * Retrieves the current network state as told to the SDK by the application.
	 *
	 * @return The current network status.
	 */
	public EOS_ENetworkStatus getNetworkStatus() {
		return EOSLibrary.instance.EOS_Platform_GetNetworkStatus(this);
	}
}