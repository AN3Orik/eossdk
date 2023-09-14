package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyUnlockedAchievementByAchievementId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UserId", "AchievementId"})
public class EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions extends Structure {
	/** The most recent version of the EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions struct. */
	public static final int EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYACHIEVEMENTID_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYACHIEVEMENTID_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user who is copying the unlocked achievement */
	public EOS_ProductUserId UserId;
	/** AchievementId of the unlocked achievement to retrieve from the cache */
	public String AchievementId;

	public EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYACHIEVEMENTID_API_LATEST;
	}

	public EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions implements Structure.ByValue {
	}
}