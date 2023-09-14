package host.anzo.eossdk.eos.sdk.leaderboards.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbackresults.EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public interface EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Leaderboards_QueryLeaderboardUserScores
	 * @param data A EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallbackInfo data);
}