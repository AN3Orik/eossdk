package host.anzo.eossdk.eos.sdk.achievements;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Achievements_Interface;
import host.anzo.eossdk.eos.sdk.achievements.options.EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions;
import host.anzo.eossdk.eos.sdk.achievements.options.EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementId", "UnlockTime"})
public class EOS_Achievements_UnlockedAchievement extends Structure implements AutoCloseable {
	public static final int EOS_ACHIEVEMENTS_UNLOCKEDACHIEVEMENT_API_LATEST = 1;

	/** Timestamp value representing an undefined UnlockTime for EOS_Achievements_PlayerAchievement and EOS_Achievements_UnlockedAchievement */
	public static final int EOS_ACHIEVEMENTS_ACHIEVEMENT_UNLOCKTIME_UNDEFINED = -1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_UNLOCKEDACHIEVEMENT_API_LATEST. */
	public int ApiVersion;
	/** Achievement ID that can be used to uniquely identify the unlocked achievement. */
	public String AchievementId;
	/** If not {@link EOS_Achievements_UnlockedAchievement#EOS_ACHIEVEMENTS_ACHIEVEMENT_UNLOCKTIME_UNDEFINED} then this is the POSIX timestamp that the achievement was unlocked. */
	public long UnlockTime;

	public EOS_Achievements_UnlockedAchievement() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_UNLOCKEDACHIEVEMENT_API_LATEST;
	}

	public EOS_Achievements_UnlockedAchievement(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an unlocked achievement. This must be called on data retrieved from
	 * EOS_Achievements_CopyUnlockedAchievementByIndex or EOS_Achievements_CopyUnlockedAchievementByAchievementId.
	 *
	 * @see EOS_Achievements_UnlockedAchievement
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions, EOS_Achievements_DefinitionV2[])
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions, EOS_Achievements_DefinitionV2[])
	 */
	public void release() {
		EOSLibrary.instance.EOS_Achievements_UnlockedAchievement_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Achievements_UnlockedAchievement implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_UnlockedAchievement implements Structure.ByValue {
	}
}