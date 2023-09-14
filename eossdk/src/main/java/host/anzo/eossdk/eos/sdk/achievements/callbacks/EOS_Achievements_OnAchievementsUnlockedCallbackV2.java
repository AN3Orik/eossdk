package host.anzo.eossdk.eos.sdk.achievements.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.achievements.callbackresults.EOS_Achievements_OnAchievementsUnlockedCallbackV2Info;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Achievements_OnAchievementsUnlockedCallbackV2 extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Achievements_AddNotifyAchievementsUnlockedV2
	 *
	 * @param data An EOS_Achievements_OnAchievementsUnlockedCallbackV2Info containing the output information and result
	 */
	void apply(EOS_Achievements_OnAchievementsUnlockedCallbackV2Info data);
}