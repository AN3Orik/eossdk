package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_QueryLeaderboardDefinitions function.
 * StartTime and EndTime are optional parameters, they can be used to limit the list of definitions
 * to overlap the time window specified.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "StartTime", "EndTime", "LocalUserId"})
public class EOS_Leaderboards_QueryLeaderboardDefinitionsOptions extends Structure {
	/** Timestamp value representing an undefined time for EOS_HLeaderboards. */
	public static final int EOS_LEADERBOARDS_TIME_UNDEFINED = -1;

	/** The most recent version of the EOS_Leaderboards_QueryLeaderboardDefinitions struct. */
	public static final int EOS_LEADERBOARDS_QUERYLEADERBOARDDEFINITIONS_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_QUERYLEADERBOARDDEFINITIONS_API_LATEST. */
	public int ApiVersion;
	/** An optional POSIX timestamp for the leaderboard's start time, or {@link #EOS_LEADERBOARDS_TIME_UNDEFINED} */
	public long StartTime;
	/** An optional POSIX timestamp for the leaderboard's end time, or {@link #EOS_LEADERBOARDS_TIME_UNDEFINED} */
	public long EndTime;
	/**
	 * Product User ID for user who is querying definitions.
	 * Must be set when using a client policy that requires a valid logged in user.
	 * Not used for Dedicated Server where no user is available.
	 */
	public EOS_ProductUserId LocalUserId;

	public EOS_Leaderboards_QueryLeaderboardDefinitionsOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_QUERYLEADERBOARDDEFINITIONS_API_LATEST;
	}

	public EOS_Leaderboards_QueryLeaderboardDefinitionsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_QueryLeaderboardDefinitionsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_QueryLeaderboardDefinitionsOptions implements Structure.ByValue {
	}
}