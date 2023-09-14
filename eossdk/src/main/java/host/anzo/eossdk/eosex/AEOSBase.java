package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.EOS;
import host.anzo.eossdk.eos.sdk.EOS_Logging_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Platform_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public abstract class AEOSBase<T extends EOSBaseOptions> {
	protected T options;
	protected EOS_Platform_Interface platform;
	private final Timer platformTickTimer = new Timer();

	public AEOSBase<T> start(T baseOptions) {
		this.options = baseOptions;
		initPlatform();
		return this;
	}

	public void shutdown() {
		platformTickTimer.cancel();
		platform.release();
		EOS.EOS_Shutdown();
	}

	protected void initPlatform() {
		final EOS_EResult initResult = EOS.EOS_Initialize(new EOS_InitializeOptions(options));
		if (!initResult.isSuccess()) {
			throw new RuntimeException("Failed to EOS_Initialize with message: " + initResult);
		}

		final EOS_EResult setLogCallbackResult = EOS_Logging_Interface.setCallback(this::onLogMessage);
		if (!setLogCallbackResult.isSuccess()) {
			throw new RuntimeException("Failed to EOS_Logging_SetCallback with message: " + setLogCallbackResult);
		}

		final EOS_EResult setLogLevelResult = EOS_Logging_Interface.setLogLevel(options.getLogCategory(), options.getLogLevel());
		if (!setLogLevelResult.isSuccess()) {
			throw new RuntimeException("Failed to EOS_Logging_SetLogLevel with message: " + setLogLevelResult);
		}

		platform = EOS.EOS_Platform_Create(new EOS_Platform_Options(options));
		if (platform == null) {
			throw new RuntimeException("Failed to EOS_Platform_Create: pointer is null");
		}

		try {
			platformTickTimer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					platform.tick();
				}
			}, 0, options.getTickPeriod());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to start platform tick timer: " + e.getMessage());
		}
	}

	/**
	 * Event happens when EOS logging engine sends the message
	 * @param logMessage object with message data
	 */
	protected abstract void onLogMessage(@NotNull EOS_LogMessage logMessage);
}