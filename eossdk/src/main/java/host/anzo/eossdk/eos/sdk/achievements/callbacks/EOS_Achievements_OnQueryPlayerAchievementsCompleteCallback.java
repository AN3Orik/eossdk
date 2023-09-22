package host.anzo.eossdk.eos.sdk.achievements.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_PlayerAchievement;
import host.anzo.eossdk.eos.sdk.achievements.callbackresults.EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Achievements_OnQueryPlayerAchievementsCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Achievements_QueryPlayerAchievements
	 *
	 * @param data An EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo containing the output information and result
	 *
	 * @see EOS_Achievements_PlayerAchievement#release()
	 */
	void apply(EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo data);
}