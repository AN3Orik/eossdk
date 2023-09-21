package host.anzo.eossdk.eos.sdk.achievements;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Achievements_Interface;
import host.anzo.eossdk.eos.sdk.achievements.options.EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions;
import host.anzo.eossdk.eos.sdk.achievements.options.EOS_Achievements_CopyPlayerAchievementByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single player achievement.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementId", "Progress", "UnlockTime", "StatInfoCount", "StatInfo", "DisplayName", "Description", "IconURL", "FlavorText"})
public class EOS_Achievements_PlayerAchievement extends Structure implements AutoCloseable {
	public static final int EOS_ACHIEVEMENTS_PLAYERACHIEVEMENT_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_PLAYERACHIEVEMENT_API_LATEST. */
	public int ApiVersion;
	/** This achievement's unique identifier. */
	public String AchievementId;
	/** Progress towards completing this achievement (as a percentage). */
	public double Progress;
	/** The POSIX timestamp when the achievement was unlocked. If the achievement has not been unlocked, this value will be {@link EOS_Achievements_UnlockedAchievement#EOS_ACHIEVEMENTS_ACHIEVEMENT_UNLOCKTIME_UNDEFINED}. */
	public long UnlockTime;
	/** The number of player stat info entries associated with this achievement. */
	public int StatInfoCount;
	/** Array of EOS_Achievements_PlayerStatInfo structures containing information about stat thresholds used to unlock the achievement and the player's current values for those stats. */
	public EOS_Achievements_PlayerStatInfo.ByReference[] StatInfo;
	/**
	 * Localized display name for the achievement based on this specific player's current progress on the achievement.<br>
	 * <b>The current progress is updated when EOS_Achievements_QueryPlayerAchievements succeeds and when an achievement is unlocked.</b>
	 */
	public String DisplayName;
	/**
	 * Localized description for the achievement based on this specific player's current progress on the achievement.<br>
	 * <b>The current progress is updated when EOS_Achievements_QueryPlayerAchievements succeeds and when an achievement is unlocked.</b>
	 */
	public String Description;
	/**
	 * URL of an icon to display for the achievement based on this specific player's current progress on the achievement. This may be null if there is no data configured in the dev portal.<br>
	 * <b>The current progress is updated when EOS_Achievements_QueryPlayerAchievements succeeds and when an achievement is unlocked.</b>
	 */
	public String IconURL;
	/** Localized flavor text that can be used by the game in an arbitrary manner. This may be null if there is no data configured in the dev portal. */
	public String FlavorText;

	public EOS_Achievements_PlayerAchievement() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_PLAYERACHIEVEMENT_API_LATEST;
	}

	public EOS_Achievements_PlayerAchievement(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with a player achievement. This must be called on data retrieved from
	 * EOS_Achievements_CopyPlayerAchievementByIndex or EOS_Achievements_CopyPlayerAchievementByAchievementId.
	 *
	 * @see EOS_Achievements_PlayerAchievement
	 * @see EOS_Achievements_Interface#copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions, EOS_Achievements_PlayerAchievement[])
	 * @see EOS_Achievements_Interface#copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions, EOS_Achievements_PlayerAchievement[])
	 */
	public void release() {
		EOSLibrary.instance.EOS_Achievements_PlayerAchievement_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Achievements_PlayerAchievement implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_PlayerAchievement implements Structure.ByValue {
	}
}