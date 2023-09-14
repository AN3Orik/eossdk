package host.anzo.eossdk.eos.sdk.stats.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.stats.EOS_Stats_Stat;
import host.anzo.eossdk.eos.sdk.stats.callbackresults.EOS_Stats_OnQueryStatsCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/31/2023
 */
public interface EOS_Stats_OnQueryStatsCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Stats_QueryStats
	 *
	 * @param data A EOS_Stats_OnQueryStatsCompleteCallbackInfo containing the output information and result
	 *
	 * @see EOS_Stats_Stat#release()
	 */
	void apply(EOS_Stats_OnQueryStatsCompleteCallbackInfo data);
}