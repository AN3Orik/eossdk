package host.anzo.eossdk.eos.sdk.leaderboards.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbackresults.EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public interface EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Leaderboards_QueryLeaderboardRanks
	 * @param data A EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo data);
}