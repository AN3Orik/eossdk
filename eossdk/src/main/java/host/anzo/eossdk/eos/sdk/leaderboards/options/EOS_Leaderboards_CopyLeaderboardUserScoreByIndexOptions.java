package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardUserScoreByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardUserScoreIndex", "StatName"})
public class EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions struct. */
	public static final int EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** Index of the sorted leaderboard user score to retrieve from the cache. */
	public int LeaderboardUserScoreIndex;
	/** Name of the stat used to rank the leaderboard. */
	public String StatName;

	public EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYINDEX_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions implements Structure.ByValue {
	}
}