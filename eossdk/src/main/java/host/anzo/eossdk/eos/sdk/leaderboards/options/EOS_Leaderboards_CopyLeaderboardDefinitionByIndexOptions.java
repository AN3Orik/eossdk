package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardDefinitionByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardIndex"})
public class EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions struct. */
	public static final int EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Index of the leaderboard definition to retrieve from the cache */
	public int LeaderboardIndex;

	public EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYINDEX_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions implements Structure.ByValue {
	}
}