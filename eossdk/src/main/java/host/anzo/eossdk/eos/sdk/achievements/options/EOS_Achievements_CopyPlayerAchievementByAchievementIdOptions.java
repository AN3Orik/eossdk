package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyPlayerAchievementByAchievementId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "AchievementId", "LocalUserId"})
public class EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions extends Structure {
	/** The most recent version of the EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions struct. */
	public static final int EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYACHIEVEMENTID_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYACHIEVEMENTID_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user whose achievement is to be retrieved. */
	public EOS_ProductUserId TargetUserId;
	/** Achievement ID to search for when retrieving player achievement data from the cache. */
	public String AchievementId;
	/** The Product User ID for the user who is querying for a player achievement. For a Dedicated Server this should be null. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYPLAYERACHIEVEMENTBYACHIEVEMENTID_API_LATEST;
	}

	public EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions implements Structure.ByValue {
	}
}