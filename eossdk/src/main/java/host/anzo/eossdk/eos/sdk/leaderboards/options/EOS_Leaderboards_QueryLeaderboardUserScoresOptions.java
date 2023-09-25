package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_UserScoresQueryStatInfo;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_QueryLeaderboardUserScores function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "UserIds", "UserIdsCount", "StatInfo", "StatInfoCount", "StartTime", "EndTime", "LocalUserId"})
public class EOS_Leaderboards_QueryLeaderboardUserScoresOptions extends Structure {
	public static final int EOS_LEADERBOARDS_QUERYLEADERBOARDUSERSCORES_API_LATEST = 2;

	/** API Version: Set this to EOS_LEADERBOARDS_QUERYLEADERBOARDUSERSCORES_API_LATEST. */
	public int ApiVersion;
	/** An array of Product User IDs indicating the users whose scores you want to retrieve */
	public EOS_ProductUserId UserIds;
	/** The number of users included in query */
	public int UserIdsCount;
	/** The stats to be collected, along with the sorting method to use when determining rank order for each stat */
	public EOS_Leaderboards_UserScoresQueryStatInfo.ByReference StatInfo;
	/** The number of stats to query */
	public int StatInfoCount;
	/** An optional POSIX timestamp, or {@link EOS_Leaderboards_QueryLeaderboardDefinitionsOptions#EOS_LEADERBOARDS_TIME_UNDEFINED}; results will only include scores made after this time */
	public long StartTime;
	/** An optional POSIX timestamp, or {@link EOS_Leaderboards_QueryLeaderboardDefinitionsOptions#EOS_LEADERBOARDS_TIME_UNDEFINED}; results will only include scores made before this time */
	public long EndTime;
	/**
	 * Product User ID for user who is querying user scores.
	 * Must be set when using a client policy that requires a valid logged in user.
	 * Not used for Dedicated Server where no user is available.
	 */
	public EOS_ProductUserId LocalUserId;

	public EOS_Leaderboards_QueryLeaderboardUserScoresOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_QUERYLEADERBOARDUSERSCORES_API_LATEST;
	}

	public EOS_Leaderboards_QueryLeaderboardUserScoresOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_QueryLeaderboardUserScoresOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_QueryLeaderboardUserScoresOptions implements Structure.ByValue {
	}
}