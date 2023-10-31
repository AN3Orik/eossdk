package host.anzo.eossdk.eos.sdk.integratedplatform.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Lobby_Interface;
import host.anzo.eossdk.eos.sdk.lobby.callbacks.EOS_Lobby_OnSendLobbyNativeInviteRequestedCallback;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_AddNotifySendLobbyNativeInviteRequestedOptions;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * These flags are used to determine how a specific Integrated Platform will be managed.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public @Getter class EOS_EIntegratedPlatformManagementFlags extends NativeMappedBitMask {
	/** The integrated platform library should be disabled. This is equivalent to providing no flags. */
	public static final int EOS_IPMF_Disabled = 0x0001;
	/** The integrated platform library is managed by the calling application. EOS SDK should only hook into an existing instance of the integrated platform library. */
	public static final int EOS_IPMF_LibraryManagedByApplication = 0x0002;
	/** EOS SDK should fully manage the integrated platform library. It will do this by performing the load, initialize, tick and unload operations as necessary. */
	public static final int EOS_IPMF_LibraryManagedBySDK = 0x0004;
	/**
	 * The EOS SDK should not mirror the EOS rich presence with the Integrated Platform.
	 * The default behavior is for EOS SDK to share local presence with the Integrated Platform.
	 */
	public static final int EOS_IPMF_DisablePresenceMirroring = 0x0008;
	/**
	 * EOS SDK should not perform any sessions management through the Integrated Platform.
	 * The default behavior is for EOS SDK to perform sessions management through the Integrated Platform.<br>
	 * Sessions management includes:
	 * <ul>
	 *     <li>sharing the lobby and session presence enabled games with the Integrated Platform.
	 *     <li>handling Social Overlay invite button events which cannot be handled by normal processing of Epic Services.
	 *     <li>handling startup requests from the Integrated Platform to immediately join a game due to in invite while offline.
	 * </ul>
	 *
	 * @see EOS_Lobby_Interface#addNotifySendLobbyNativeInviteRequested(EOS_Lobby_AddNotifySendLobbyNativeInviteRequestedOptions, Pointer, EOS_Lobby_OnSendLobbyNativeInviteRequestedCallback)
	 */
	public static final int EOS_IPMF_DisableSDKManagedSessions = 0x0010;
	/**
	 * Some features within the EOS SDK may wish to know a preference of Integrated Platform versus EOS.
	 * When determining an absolute platform preference those with this flag will be skipped.
	 * The IntegratedPlatforms list is provided via the EOS_Platform_Options during EOS_Platform_Create.
	 * <p>
	 * The primary usage of the EOS_IPMF_PreferEOSIdentity and EOS_IPMF_PreferIntegratedIdentity flags is with game invites
	 * from the Social Overlay.
	 * <p>
	 * For game invites from the Social Overlay the EOS SDK will follow these rules:<br>
	 * <ul>
	 *     <li>If the only account ID we can determine for the target player is an EAS ID then the EOS system will be used.
	 *     <li>If the only account ID we can determine for the target player is an integrated platform ID then the integrated platform system will be used.
	 *     <li>If both are available then the EOS SDK will operate in 1 of 3 modes:
	 *     <ul>
	 *         <li>no preference identified: use both the EOS and integrated platform systems.
	 *         <li>PreferEOS: Use EOS if the target is an EAS friend and is either online in EAS or not online for the integrated platform.
	 *         <li>PreferIntegrated: Use integrated platform if the target is an integrated platform friend and is either online in the integrated platform or not online for EAS.
	 *     </ul>
	 *     <li>If the integrated platform fails to send then try EAS if was not already used.
	 * </ul>
	 */
	public static final int EOS_IPMF_PreferEOSIdentity = 0x0020;
	/**
	 * Some features within the EOS SDK may wish to know a preference of Integrated Platform versus EOS.
	 * For further explanation see EOS_IPMF_PreferEOSIdentity.
	 *
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_PreferEOSIdentity
	 */
	public static final int EOS_IPMF_PreferIntegratedIdentity = 0x0040;
	/**
	 * By default the EOS SDK will attempt to detect the login/logout events of local users and update local states accordingly. Setting this flag will disable this functionality,
	 * relying on the application to process login/logout events and notify EOS SDK. It is not possible for the EOS SDK to do this on all platforms, making this flag not always
	 * optional.
	 * <p>
	 * This flag must be set to use the manual platform user login/logout functions, even on platforms where it is not possible for the EOS SDK to detect login/logout events,
	 * making this a required flag for correct Integrated Platform behavior on those platforms.
	 */
	public static final int EOS_IPMF_ApplicationManagedIdentityLogin = 0x0080;

	public static @NotNull EOS_EIntegratedPlatformManagementFlags of(int... flags) {
		final EOS_EIntegratedPlatformManagementFlags result = new EOS_EIntegratedPlatformManagementFlags();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_EIntegratedPlatformManagementFlags value = new EOS_EIntegratedPlatformManagementFlags();
		value.bitMask = (int) nativeValue;
		return value;
	}
}