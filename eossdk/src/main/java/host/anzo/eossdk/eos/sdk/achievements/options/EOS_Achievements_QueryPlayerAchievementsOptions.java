package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_QueryPlayerAchievements function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "LocalUserId"})
public class EOS_Achievements_QueryPlayerAchievementsOptions extends Structure {
	/** The most recent version of the EOS_Achievements_QueryPlayerAchievements struct. */
	public static final int EOS_ACHIEVEMENTS_QUERYPLAYERACHIEVEMENTS_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_QUERYPLAYERACHIEVEMENTS_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user whose achievements are to be retrieved. */
	public EOS_ProductUserId TargetUserId;
	/** The Product User ID for the user who is querying for player achievements. For a Dedicated Server this should be null. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Achievements_QueryPlayerAchievementsOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_QUERYPLAYERACHIEVEMENTS_API_LATEST;
	}

	public EOS_Achievements_QueryPlayerAchievementsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_QueryPlayerAchievementsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_QueryPlayerAchievementsOptions implements Structure.ByValue {
	}
}