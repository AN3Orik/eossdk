package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyUnlockedAchievementByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UserId", "AchievementIndex"})
public class EOS_Achievements_CopyUnlockedAchievementByIndexOptions extends Structure {
	public static final int EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user who is copying the unlocked achievement */
	public EOS_ProductUserId UserId;
	/** Index of the unlocked achievement to retrieve from the cache */
	public int AchievementIndex;

	public EOS_Achievements_CopyUnlockedAchievementByIndexOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYUNLOCKEDACHIEVEMENTBYINDEX_API_LATEST;
	}

	public EOS_Achievements_CopyUnlockedAchievementByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyUnlockedAchievementByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyUnlockedAchievementByIndexOptions implements Structure.ByValue {
	}
}