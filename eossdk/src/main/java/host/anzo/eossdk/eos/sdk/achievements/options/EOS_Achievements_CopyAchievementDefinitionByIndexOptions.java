package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementIndex"})
public class EOS_Achievements_CopyAchievementDefinitionByIndexOptions extends Structure {
	public static final int EOS_ACHIEVEMENTS_COPYACHIEVEMENTDEFINITIONV2BYINDEX_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_COPYDEFINITIONBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Index of the achievement definition to retrieve from the cache */
	public int AchievementIndex;

	public EOS_Achievements_CopyAchievementDefinitionByIndexOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_COPYACHIEVEMENTDEFINITIONV2BYINDEX_API_LATEST;
	}

	public EOS_Achievements_CopyAchievementDefinitionByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_CopyAchievementDefinitionByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_CopyAchievementDefinitionByIndexOptions implements Structure.ByValue {
	}
}