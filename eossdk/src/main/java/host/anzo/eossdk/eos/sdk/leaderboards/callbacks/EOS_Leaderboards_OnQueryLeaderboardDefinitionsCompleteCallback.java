package host.anzo.eossdk.eos.sdk.leaderboards.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbackresults.EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public interface EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Leaderboards_QueryLeaderboardDefinitions
	 * @param data A EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallbackInfo data);
}