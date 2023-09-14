package host.anzo.eossdk.eos.sdk.titlestorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbackresults.EOS_TitleStorage_ReadFileDataCallbackInfo;
import host.anzo.eossdk.eos.sdk.titlestorage.enums.EOS_TitleStorage_EReadResult;

/**
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_TitleStorage_OnReadFileDataCallback extends Callback {
	/**
	 * Callback for when we have data ready to be read from the requested file. It is undefined how often this will be called during a single tick.
	 *
	 * @param data Struct containing a chunk of data to read, as well as some metadata for the file being read
	 * @return The result of the read operation. If this value is not {@link EOS_TitleStorage_EReadResult#EOS_TS_RR_ContinueReading}, this callback will not be called again for the same request
	 */
	EOS_TitleStorage_EReadResult apply(EOS_TitleStorage_ReadFileDataCallbackInfo data);
}