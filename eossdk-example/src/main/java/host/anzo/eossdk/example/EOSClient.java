package host.anzo.eossdk.example;

import host.anzo.eossdk.eosex.AEOSClient;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public class EOSClient extends AEOSClient {
	@Getter(lazy = true)
	private final static EOSClient instance = new EOSClient();

	@Override
	protected void onLogMessage(@NotNull EOS_LogMessage logMessage) {
		switch (logMessage.Level) {
			case EOS_LOG_Fatal, EOS_LOG_Error -> log.error(logMessage.Message);
			case EOS_LOG_Warning -> log.warn(logMessage.Message);
			case EOS_LOG_Info -> log.info(logMessage.Message);
			case EOS_LOG_Verbose, EOS_LOG_VeryVerbose -> log.debug(logMessage.Message);
		}
	}
}
