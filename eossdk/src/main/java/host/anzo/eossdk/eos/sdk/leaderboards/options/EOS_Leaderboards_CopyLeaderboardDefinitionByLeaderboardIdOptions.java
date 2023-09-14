package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardId function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardId"})
public class EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions extends Structure {
	public static final int EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYLEADERBOARDID_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYLEADERBOARDID_API_LATEST. */
	public int ApiVersion;

	/** The ID of the leaderboard whose definition you want to copy from the cache */
	public String LeaderboardId;

	public EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDDEFINITIONBYLEADERBOARDID_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions implements Structure.ByValue {
	}
}