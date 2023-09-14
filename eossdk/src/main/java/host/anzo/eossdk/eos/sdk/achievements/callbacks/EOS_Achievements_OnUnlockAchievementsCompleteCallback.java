package host.anzo.eossdk.eos.sdk.achievements.callbacks;

import host.anzo.eossdk.eos.sdk.achievements.callbackresults.EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo;

import javax.security.auth.callback.Callback;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Achievements_OnUnlockAchievementsCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Achievements_UnlockAchievements
	 * @param data An EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo data);
}