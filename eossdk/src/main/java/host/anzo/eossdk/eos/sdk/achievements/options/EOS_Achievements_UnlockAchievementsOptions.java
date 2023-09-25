package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_UnlockAchievements function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UserId", "AchievementIds", "AchievementsCount"})
public class EOS_Achievements_UnlockAchievementsOptions extends Structure {
	/** The most recent version of the EOS_Achievements_UnlockAchievements struct. */
	public static final int EOS_ACHIEVEMENTS_UNLOCKACHIEVEMENTS_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_UNLOCKACHIEVEMENTS_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user whose achievements we want to unlock. */
	public EOS_ProductUserId UserId;
	/** An array of Achievement IDs to unlock. */
	public StringArray AchievementIds;
	/** The number of achievements to unlock. */
	public int AchievementsCount;

	public EOS_Achievements_UnlockAchievementsOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_UNLOCKACHIEVEMENTS_API_LATEST;
	}

	public EOS_Achievements_UnlockAchievementsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_UnlockAchievementsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_UnlockAchievementsOptions implements Structure.ByValue {
	}
}