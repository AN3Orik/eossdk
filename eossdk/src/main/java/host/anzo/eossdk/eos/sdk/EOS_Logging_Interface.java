package host.anzo.eossdk.eos.sdk;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.logging.callbacks.EOS_LogMessageFunc;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogCategory;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogLevel;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * @author Anton Lasevich
 * @since 8/8/2023
 */
public class EOS_Logging_Interface {
	/**
	 * Set the logging level for the specified logging category. By default all log categories will callback for Warnings, Errors, and Fatals.
	 *
	 * @param logCategory the specific log category to configure. Use EOS_LC_ALL_CATEGORIES to configure all categories simultaneously to the same log level.
	 * @param logLevel the log level to use for the log category
	 *
	 * @return {@link EOS_EResult#EOS_Success} is returned if the log levels are now in use.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} is returned if the SDK has not yet been initialized, or if it has been shut down.
	 */
	public static EOS_EResult setLogLevel(EOS_ELogCategory logCategory, EOS_ELogLevel logLevel) {
		return EOSLibrary.instance.EOS_Logging_SetLogLevel(logCategory, logLevel);
	}

	/**
	 * Set the callback function to use for SDK log messages. Any previously set callback will no longer be called.
	 *
	 * @param callback the function to call when the SDK logs messages
	 * @return {@link EOS_EResult#EOS_Success} is returned if the callback will be used for future log messages.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} is returned if the SDK has not yet been initialized, or if it has been shut down
	 *
	 * @see EOSLibrary#EOS_Initialize(EOS_InitializeOptions)
	 */
	public static EOS_EResult setCallback(EOS_LogMessageFunc callback) {
		CallbackUtils.registerLoggingCallback(callback);
		return EOSLibrary.instance.EOS_Logging_SetCallback(callback);
	}
}