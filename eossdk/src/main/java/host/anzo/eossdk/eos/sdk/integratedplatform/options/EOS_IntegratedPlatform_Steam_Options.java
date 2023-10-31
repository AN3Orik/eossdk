package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Required initialization options to use with EOS_IntegratedPlatform_Options for Steam.
 * Steamworks API needs to be at least v1.13
 * Steam Sanitization requires at least v1.45
 *
 * @see EOS_IntegratedPlatform_Options
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "OverrideLibraryPath", "SteamMajorVersion", "SteamMinorVersion"})
public class EOS_IntegratedPlatform_Steam_Options extends Structure {
	/** The most recent version of the EOS_IntegratedPlatform_Steam_Options API. */
	public static final int EOS_INTEGRATEDPLATFORM_STEAM_OPTIONS_API_LATEST = 2;

	/** API Version: Set this to EOS_INTEGRATEDPLATFORM_STEAM_OPTIONS_API_LATEST. */
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
	 * Options.SteamMinorVersion = 57;
	 */
	public int SteamMinorVersion;

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