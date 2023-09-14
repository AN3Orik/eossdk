package host.anzo.eossdk.eos.sdk.achievements.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Achievements_OnAchievementsUnlockedCallbackV2 Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ClientData", "UserId", "AchievementId", "UnlockTime"})
public class EOS_Achievements_OnAchievementsUnlockedCallbackV2Info extends Structure {
	/** Context that was passed into EOS_Achievements_AddNotifyAchievementsUnlocked */
	public Pointer ClientData;
	/** The Product User ID for the user who received the unlocked achievements notification */
	public EOS_ProductUserId UserId;
	/** The Achievement ID for the achievement that was unlocked. Pass this to EOS_Achievements_CopyPlayerAchievementByAchievementId to get the full achievement information. */
	public String AchievementId;
	/** POSIX timestamp when the achievement was unlocked. */
	public long UnlockTime;

	public EOS_Achievements_OnAchievementsUnlockedCallbackV2Info() {
		super();
	}

	public EOS_Achievements_OnAchievementsUnlockedCallbackV2Info(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_OnAchievementsUnlockedCallbackV2Info implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_OnAchievementsUnlockedCallbackV2Info implements Structure.ByValue {
	}
}