package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_Definition;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_QueryLeaderboardRanks function.
 *
 * @see EOS_Leaderboards_Definition
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardId", "LocalUserId"})
public class EOS_Leaderboards_QueryLeaderboardRanksOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_QueryLeaderboardRanks struct. */
	public static final int EOS_LEADERBOARDS_QUERYLEADERBOARDRANKS_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_QUERYLEADERBOARDRANKS_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the leaderboard whose information you want to retrieve. */
	public String LeaderboardId;
	/**
	 * Product User ID for user who is querying ranks.
	 * Must be set when using a client policy that requires a valid logged in user.
	 * Not used for Dedicated Server where no user is available.
	 */
	public EOS_ProductUserId LocalUserId;

	public EOS_Leaderboards_QueryLeaderboardRanksOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_QUERYLEADERBOARDRANKS_API_LATEST;
	}

	public EOS_Leaderboards_QueryLeaderboardRanksOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_QueryLeaderboardRanksOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_QueryLeaderboardRanksOptions implements Structure.ByValue {
	}
}