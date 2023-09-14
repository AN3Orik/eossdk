package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementId"})
public class EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions extends Structure {
	/** The most recent version of the EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions struct. */
	public static final int EOS_ACHIEVEMENTS_COPYACHIEVEMENTDEFINITIONV2BYACHIEVEMENTID_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYACHIEVEMENTDEFINITIONV2BYACHIEVEMENTID_API_LATEST. */
	public int ApiVersion;
	/** Achievement ID to look for when copying the definition from the cache. */
	public String AchievementId;

	public EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYACHIEVEMENTDEFINITIONV2BYACHIEVEMENTID_API_LATEST;
	}

	public EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions implements Structure.ByValue {
	}
}