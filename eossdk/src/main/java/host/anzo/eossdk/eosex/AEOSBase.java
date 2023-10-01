package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOS;
import host.anzo.eossdk.eos.sdk.EOS_Logging_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Platform_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public abstract class AEOSBase<T extends EOSBaseOptions> {
	protected T options;
	protected EOS_Platform_Interface platform;
	private final static ScheduledExecutorService taskExecutor = Executors.newScheduledThreadPool(1);

	public AEOSBase<T> start(T baseOptions) throws EOSException {
		this.options = baseOptions;
		try {
			taskExecutor.submit(this::initPlatform).get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public void shutdown() {
		try {
			taskExecutor.shutdown();
			if (!taskExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
				taskExecutor.shutdownNow();
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Error while taskExecutor termination", e);
		}
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

		taskExecutor.scheduleAtFixedRate(() -> platform.tick(), 0, options.getTickPeriod(), TimeUnit.MILLISECONDS);
	}

	/**
	 * Event happens when EOS logging engine sends the message
	 * @param logMessage object with message data
	 */
	protected abstract void onLogMessage(@NotNull EOS_LogMessage logMessage);
}