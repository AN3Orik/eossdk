package host.anzo.eossdk.eos.sdk.logging.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;

/**
 * @author Anton Lasevich
 * @since 8/8/2023
 */
public interface EOS_LogMessageFunc extends Callback {
	/**
	 * Function prototype definition for functions that receive log messages.
	 * @param message A EOS_LogMessage containing the log category, log level, and message.
	 * @see EOS_LogMessage
	 */
	void run(EOS_LogMessage message);
}