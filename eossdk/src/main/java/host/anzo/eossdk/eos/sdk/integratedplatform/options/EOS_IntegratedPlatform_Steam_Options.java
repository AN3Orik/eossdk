package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Defines;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Required initialization options to use with EOS_IntegratedPlatform_Options for Steam.
 * Steamworks API needs to be at least v1.13
 * Steam Sanitization requires at least v1.45
 * Starting Steamworks v1.58a onwards, SteamApiInterfaceVersionsArray is required when EOS_IPMF_LibraryManagedBySDK is set.
 *
 * @see EOS_IntegratedPlatform_Options
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "OverrideLibraryPath", "SteamMajorVersion", "SteamMinorVersion", "SteamApiInterfaceVersionsArray", "SteamApiInterfaceVersionsArrayBytes"})
public class EOS_IntegratedPlatform_Steam_Options extends Structure {
	/** The most recent version of the EOS_IntegratedPlatform_Steam_Options API. */
	public static final int EOS_INTEGRATEDPLATFORM_STEAM_OPTIONS_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_INTEGRATEDPLATFORM_STEAM_OPTIONS_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Usage of this parameter is dependent on the specified EOS_EIntegratedPlatformManagementFlags.
	 * <p>
	 * Optional with EOS_IPMF_LibraryManagedByApplication.
	 * Set to override the loaded library basename, or use NULL to assume the default basename by platform:
	 * <p>
	 * - Linux: libsteam_api.so,<br>
	 * - macOS: libsteam_api.dylib,<br>
	 * - Windows 32-bit: steam_api.dll,<br>
	 * - Windows 64-bit: steam_api64.dll.
	 * <p>
	 * Required with EOS_IPMF_LibraryManagedBySDK.
	 * Set to a fully qualified file path to the Steamworks SDK runtime library on disk.
	 */
	public String OverrideLibraryPath;
	/**
	 * Used to specify the major version of the Steam SDK your game is compiled against, e.g.:
	 * <p>
	 * Options.SteamMajorVersion = 1;
	 */
	public int SteamMajorVersion;
	/**
	 * Used to specify the minor version of the Steam SDK your game is compiled against, e.g.:
	 * <p>
	 * Options.SteamMinorVersion = 58;
	 */
	public int SteamMinorVersion;
	/**
	 * A pointer to a series of null terminated steam interface version names supported by the current steam dll.
	 * <p>
	 * This field is only required when the Integrated Platform Management flags has EOS_IPMF_LibraryManagedBySDK set. Else must be set to NULL.
	 * <p>
	 * Starting v1.58 the Steam initialization API requires this new field during initialization for version check validations.
	 * <p>
	 * Note: The pointer must be valid until after the execution of the EOS_IntegratedPlatformOptionsContainer_Add method.
	 * <p>
	 * This value must be constructed from the corresponding steam_api.h header of the steam dll version that is shipped with the game.
	 * In the steam_api.h header, look for SteamAPI_InitEx() and copy the value of pszInternalCheckInterfaceVersions as it is.
	 * <p>
	 * For example in v1.58a its this:
	 * 	const char SteamInterfaceVersionsArray[] =
	 *		STEAMUTILS_INTERFACE_VERSION "\0"
	 *		STEAMNETWORKINGUTILS_INTERFACE_VERSION "\0"
	 *		...
	 *		STEAMUSER_INTERFACE_VERSION "\0"
	 *		STEAMVIDEO_INTERFACE_VERSION "\0"
	 *      "\0";
	 */
	public Pointer SteamApiInterfaceVersionsArray;

	/**
	 * Size of the SteamApiInterfaceVersionsArray in bytes. Cannot exceed {@link EOS_Defines#EOS_INTEGRATEDPLATFORM_STEAM_MAX_STEAMAPIINTERFACEVERSIONSARRAY_SIZE}.
	 * <p>
	 * This field is only required when the Integrated Platform Management flags has EOS_IPMF_LibraryManagedBySDK set. Else must be set to 0.
	 * <pre>
	 * Note: Since SteamInterfaceVersionsArray contains a series of null terminated strings, please ensure that strlen() is NOT used to calculate this field.
	 * For instance, you can use the following to get the array length:
	 *  const char SteamInterfaceVersionsArray[] =
	 *      STEAMUTILS_INTERFACE_VERSION "\0"
	 *		STEAMNETWORKINGUTILS_INTERFACE_VERSION "\0"
	 *      ...
	 *		STEAMVIDEO_INTERFACE_VERSION "\0"
	 *      "\0";
	 * <br>
	 *  uint32_t SteamApiInterfaceVersionsArrayBytes = sizeof(SteamApiInterfaceVersionsArray) // Note: sizeof() takes into account the last "\0" of the string literal;
	 * </pre>
	 */
	public int SteamApiInterfaceVersionsArrayBytes;

	public EOS_IntegratedPlatform_Steam_Options() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_STEAM_OPTIONS_API_LATEST;
	}

	public EOS_IntegratedPlatform_Steam_Options(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_Steam_Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_Steam_Options implements Structure.ByValue {
	}
}