package host.anzo.eossdk.eos.sdk;

import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;

/**
 * The Platform Instance is used to gain access to all other Epic Online Service interfaces and to drive internal operations through the Tick.
 * All Platform Instance calls take a handle of type EOS_HPlatform as the first parameter.
 * EOS_HPlatform handles are created by calling EOS_Platform_Create and subsequently released by calling EOS_Platform_Release.
 *
 * @see #EOS_Initialize(EOS_InitializeOptions)
 * @see #EOS_Platform_Create(EOS_Platform_Options)
 * @see EOS_Platform_Interface#release()
 * @see #EOS_Shutdown()
 *
 * @author Anton Lasevich
 * @since 8/6/2023
 */
public class EOS {
	/** EOS SDK major version */
	public static final int EOS_MAJOR_VERSION = 1;
	/** EOS SDK minor version */
	public static final int EOS_MINOR_VERSION = 16;
	/** EOS SDK patch version */
	public static final int EOS_PATCH_VERSION = 1;

	/**
	 * The name of the env var used to determine if the game was launched by the Epic Games Launcher.
	 * <p>
	 * During the call to EOS_Platform_Create, the command line that was used to launch the app is inspected, and if it is
	 * recognized as coming from the Epic Games Launcher, this environment variable is set to 1.
	 * <p>
	 * NOTE: You can force the EOS_Platform_CheckForLauncherAndRestart API to relaunch the title by
	 * explicitly unsetting this environment variable before calling EOS_Platform_CheckForLauncherAndRestart.
	 */
	public static final String EOS_PLATFORM_CHECKFORLAUNCHERANDRESTART_ENV_VAR = "EOS_LAUNCHED_BY_EPIC";

	/**
	 * Initialize the Epic Online Services SDK.
	 * <p>
	 * Before calling any other function in the SDK, clients must call this function.
	 * <p>
	 * This function must only be called one time and must have a corresponding EOS_Shutdown call.
	 *
	 * @param options - The initialization options to use for the SDK.
	 * @return {@link EOS_EResult#EOS_Success} is returned if the SDK successfully initializes.<br>
	 *         {@link EOS_EResult#EOS_AlreadyConfigured} is returned if the function has already been called.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} is returned if the provided options are invalid.
	 */
	public static EOS_EResult EOS_Initialize(EOS_InitializeOptions options) {
		return EOSLibrary.instance.EOS_Initialize(options);
	}

	/**
	 * Tear down the Epic Online Services SDK.
	 * <p>
	 * Once this function has been called, no more SDK calls are permitted; calling anything after EOS_Shutdown will result in undefined behavior.
	 * @return {@link EOS_EResult#EOS_Success} is returned if the SDK is successfully torn down.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} is returned if a successful call to EOS_Initialize has not been made.<br>
	 *         {@link EOS_EResult#EOS_UnexpectedError} is returned if EOS_Shutdown has already been called.
	 */
	public static EOS_EResult EOS_Shutdown() {
		return EOSLibrary.instance.EOS_Shutdown();
	}

	/**
	 * Create a single Epic Online Services Platform Instance.
	 * <p>
	 * The platform instance is used to gain access to the various Epic Online Services.
	 * <p>
	 * This function returns an opaque handle to the platform instance, and that handle must be passed to EOS_Platform_Release to release the instance.
	 * @param options platform create options
	 * @return An opaque handle to the platform instance.
	 */
	public static EOS_Platform_Interface EOS_Platform_Create(EOS_Platform_Options options) {
		return EOSLibrary.instance.EOS_Platform_Create(options);
	}

	/**
	 * Encode a byte array into hex encoded string
	 * @param byteArray byte array
	 * @param length byte count
	 * @param outBuffer out buffer
	 * @param inOutBufferLength exchange buffer
	 * @return {@link EOS_EResult#EOS_Success} if the encoding was successful and passed out in OutBuffer<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer on invalid length for any of the parameters<br>
	 *         {@link EOS_EResult#EOS_LimitExceeded} - The outBuffer is not large enough to receive the encoding. inOutBufferLength contains the required minimum length to perform the operation successfully.
	 */
	public EOS_EResult EOS_ByteArray_ToString(byte[] byteArray, int length, byte[] outBuffer, IntByReference inOutBufferLength) {
		return EOSLibrary.instance.EOS_ByteArray_ToString(byteArray, length, outBuffer, inOutBufferLength);
	}
}