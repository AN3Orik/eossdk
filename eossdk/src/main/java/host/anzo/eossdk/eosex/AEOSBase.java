package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOS;
import host.anzo.eossdk.eos.sdk.EOS_Logging_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Platform_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.init.options.EOS_InitializeOptions;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import host.anzo.eossdk.eos.sdk.reports.enums.EOS_EPlayerReportsCategory;
import host.anzo.eossdk.eos.sdk.reports.options.EOS_Reports_SendPlayerBehaviorReportOptions;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public abstract class AEOSBase<T extends EOSBaseOptions> {
	protected T options;
	protected EOS_Platform_Interface platform;
	private final static ScheduledExecutorService taskExecutor = Executors.newScheduledThreadPool(1);

	public AEOSBase<T> start(T baseOptions) throws EOSException {
		this.options = baseOptions;
		callApiSync(this::initPlatform);
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

	protected void callApi(Runnable runnable) {
		taskExecutor.execute(runnable);
	}

	protected void callApiSync(Runnable runnable) {
		try {
			taskExecutor.submit(runnable).get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Report player to EOS reports
	 * @param reporterUserId reporter EOS_ProductUserId string
	 * @param reportedUserId reported EOS_ProductUserId string
	 * @param category report category
	 * @param message report message
	 * @param context report context
	 */
	public void reportPlayer(String reporterUserId,
	                         String reportedUserId,
	                         EOS_EPlayerReportsCategory category,
	                         String message,
	                         String context) {
		callApi(() -> {
			final EOS_Reports_SendPlayerBehaviorReportOptions reportOptions = new EOS_Reports_SendPlayerBehaviorReportOptions(reporterUserId,
					reportedUserId,
					category,
					message,
					context);
			platform.getReportsInterface().sendPlayerBehaviorReport(reportOptions, null, callbackInfo -> {
				if (callbackInfo.ResultCode.isSuccess()) {
					log.info("Sent report from productUserId=[{}] to productUserId=[{}]", reporterUserId, reportedUserId);
				}
				else {
					log.error("Failed to send report from productUserId=[{}] to productUserId=[{}] resultCode=[{}]",
							reporterUserId,
							reportedUserId,
							callbackInfo.ResultCode);
				}
			});
		});
	}

	/**
	 * Event happens when EOS logging engine sends the message
	 * @param logMessage object with message data
	 */
	protected void onLogMessage(@NotNull EOS_LogMessage logMessage) {
		switch (logMessage.Level) {
			case EOS_LOG_Fatal:
			case EOS_LOG_Error:
				log.error(logMessage.Message);
				break;
			case EOS_LOG_Warning:
				log.warn(logMessage.Message);
				break;
			case EOS_LOG_Info:
				log.info(logMessage.Message);
				break;
			case EOS_LOG_Verbose:
			case EOS_LOG_VeryVerbose:
				log.debug(logMessage.Message);
				break;
		}
	}
}