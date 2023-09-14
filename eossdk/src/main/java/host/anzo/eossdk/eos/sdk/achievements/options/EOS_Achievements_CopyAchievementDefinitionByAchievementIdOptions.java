package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_CopyAchievementDefinitionByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementId"})
public class EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions extends Structure {
	public static final int EOS_ACHIEVEMENTS_COPYDEFINITIONBYACHIEVEMENTID_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYDEFINITIONBYACHIEVEMENTID_API_LATEST. */
	public int ApiVersion;
	/** Achievement ID to look for when copying definition from the cache */
	public Pointer AchievementId;

	public EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYDEFINITIONBYACHIEVEMENTID_API_LATEST;
	}

	public EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions implements Structure.ByValue {
	}
}