package host.anzo.eossdk.eos.sdk.leaderboards;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Leaderboards_Interface;
import host.anzo.eossdk.eos.sdk.leaderboards.enums.EOS_ELeaderboardAggregation;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single leaderboard definition
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardId", "StatName", "Aggregation", "StartTime", "EndTime"})
public class EOS_Leaderboards_Definition extends Structure implements AutoCloseable {
	public static final int EOS_LEADERBOARDS_DEFINITION_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_DEFINITION_API_LATEST. */
	public int ApiVersion;
	/** Unique ID to identify leaderboard. */
	public String LeaderboardId;
	/** Name of stat used to rank leaderboard. */
	public String StatName;
	/**
	 * Aggregation used to sort leaderboard.
	 */
	public EOS_ELeaderboardAggregation Aggregation;
	/** The POSIX timestamp for the start time, or EOS_LEADERBOARDS_TIME_UNDEFINED. */
	public long StartTime;
	/** The POSIX timestamp for the end time, or EOS_LEADERBOARDS_TIME_UNDEFINED. */
	public long EndTime;

	public EOS_Leaderboards_Definition() {
		super();
		ApiVersion = EOS_LEADERBOARDS_DEFINITION_API_LATEST;
	}

	public EOS_Leaderboards_Definition(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOS_Leaderboards_Interface.releaseDefinition(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Leaderboards_Definition implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_Definition implements Structure.ByValue {
	}
}