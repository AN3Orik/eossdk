package host.anzo.eossdk.eos.sdk.achievements.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.achievements.callbackresults.EOS_Achievements_OnAchievementsUnlockedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Achievements_OnAchievementsUnlockedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Achievements_AddNotifyAchievementsUnlocked
	 *
	 * @param data A EOS_Achievements_OnAchievementsUnlockedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Achievements_OnAchievementsUnlockedCallbackInfo data);
}