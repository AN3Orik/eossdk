package host.anzo.eossdk.eos.sdk.stats.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.stats.callbackresults.EOS_Stats_IngestStatCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/31/2023
 */
public interface EOS_Stats_OnIngestStatCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Stats_IngestStat
	 * @param data A EOS_Stats_IngestStatCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Stats_IngestStatCompleteCallbackInfo data);
}