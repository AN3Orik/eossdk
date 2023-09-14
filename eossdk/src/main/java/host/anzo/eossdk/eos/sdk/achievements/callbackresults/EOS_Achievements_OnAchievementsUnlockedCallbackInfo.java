package host.anzo.eossdk.eos.sdk.achievements.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Achievements_OnAchievementsUnlockedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ClientData", "UserId", "AchievementsCount", "AchievementIds"})
public class EOS_Achievements_OnAchievementsUnlockedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Achievements_AddNotifyAchievementsUnlocked */
	public Pointer ClientData;
	/** The Product User ID for the user who received the unlocked achievements notification */
	public EOS_ProductUserId UserId;
	/** The number of achievements. */
	public int AchievementsCount;
	/** This member is not used and will always be set to NULL. */
	public StringArray AchievementIds;

	public EOS_Achievements_OnAchievementsUnlockedCallbackInfo() {
		super();
	}

	public EOS_Achievements_OnAchievementsUnlockedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_OnAchievementsUnlockedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_OnAchievementsUnlockedCallbackInfo implements Structure.ByValue {
	}
}
