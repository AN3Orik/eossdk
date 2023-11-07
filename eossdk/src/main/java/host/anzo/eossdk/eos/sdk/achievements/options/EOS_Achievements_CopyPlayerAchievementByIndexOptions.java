package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyPlayerAchievementByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "AchievementIndex", "LocalUserId"})
public class EOS_Achievements_CopyPlayerAchievementByIndexOptions extends Structure {
	/** The most recent version of the EOS_Achievements_CopyPlayerAchievementByIndexOptions struct. */
	public static final int EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYINDEX_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID for the user whose achievement is to be retrieved. */
	public EOS_ProductUserId TargetUserId;
	/** The index of the player achievement data to retrieve from the cache. */
	public int AchievementIndex;
	/** The Product User ID for the user who is querying for a player achievement. For a Dedicated Server this should be null. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Achievements_CopyPlayerAchievementByIndexOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYINDEX_API_LATEST;
	}

	public EOS_Achievements_CopyPlayerAchievementByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyPlayerAchievementByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyPlayerAchievementByIndexOptions implements Structure.ByValue {
	}
}