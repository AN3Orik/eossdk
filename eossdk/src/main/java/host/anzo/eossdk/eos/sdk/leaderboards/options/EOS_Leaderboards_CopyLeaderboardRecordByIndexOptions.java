package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardRecordByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardRecordIndex"})
public class EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions struct. */
	public final static int EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYINDEX_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** Index of the leaderboard record to retrieve from the cache */
	public int LeaderboardRecordIndex;

	public EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYINDEX_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions implements Structure.ByValue {
	}
}
