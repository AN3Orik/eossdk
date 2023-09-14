package host.anzo.eossdk.example;

import host.anzo.eossdk.eosex.AEOSServer;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import host.anzo.eossdk.eosex.IEOSNetworkClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public class EOSServer extends AEOSServer {
	@Getter(lazy = true)
	private final static EOSServer instance = new EOSServer();

	@Override
	protected void onLogMessage(@NotNull EOS_LogMessage logMessage) {
		switch (logMessage.Level) {
			case EOS_LOG_Fatal, EOS_LOG_Error -> log.error(logMessage.Message);
			case EOS_LOG_Warning -> log.warn(logMessage.Message);
			case EOS_LOG_Info -> log.info(logMessage.Message);
			case EOS_LOG_Verbose, EOS_LOG_VeryVerbose -> log.debug(logMessage.Message);
		}
	}

	@Override
	protected void onNetworkClientAdded(@NotNull IEOSNetworkClient antiCheatClient) {
		// TODO: Implement me
	}
}