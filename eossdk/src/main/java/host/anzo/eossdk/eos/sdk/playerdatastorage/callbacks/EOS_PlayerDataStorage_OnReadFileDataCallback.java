package host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults.EOS_PlayerDataStorage_ReadFileDataCallbackInfo;
import host.anzo.eossdk.eos.sdk.playerdatastorage.enums.EOS_PlayerDataStorage_EReadResult;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_PlayerDataStorage_OnReadFileDataCallback extends Callback {
	/**
	 * Callback for when we have data ready to be read from the requested file. It is undefined how often this will be called during a single tick.
	 *
	 * @param data Struct containing a chunk of data to read, as well as some metadata for the file being read
	 * @return The result of the read operation. If this value is not {@link EOS_PlayerDataStorage_EReadResult#EOS_RR_ContinueReading}, this callback will not be called again for the same request
	 */
	EOS_PlayerDataStorage_EReadResult apply(EOS_PlayerDataStorage_ReadFileDataCallbackInfo data);
}