package host.anzo.eossdk.eos.sdk.leaderboards;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Leaderboards_Interface;
import host.anzo.eossdk.eos.sdk.leaderboards.enums.EOS_ELeaderboardAggregation;
import host.anzo.eossdk.eos.sdk.leaderboards.options.EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions;
import host.anzo.eossdk.eos.sdk.leaderboards.options.EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions;
import host.anzo.eossdk.eos.sdk.leaderboards.options.EOS_Leaderboards_QueryLeaderboardDefinitionsOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single leaderboard definition
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LeaderboardId", "StatName", "Aggregation", "StartTime", "EndTime"})
public class EOS_Leaderboards_Definition extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Leaderboards_Definition struct. */
	public static final int EOS_LEADERBOARDS_DEFINITION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_DEFINITION_API_LATEST}. */
	public int ApiVersion;
	/** Unique ID to identify leaderboard. */
	public String LeaderboardId;
	/** Name of stat used to rank leaderboard. */
	public String StatName;
	/**
	 * Aggregation used to sort leaderboard.
	 */
	public EOS_ELeaderboardAggregation Aggregation;
	/** The POSIX timestamp for the start time, or {@link EOS_Leaderboards_QueryLeaderboardDefinitionsOptions#EOS_LEADERBOARDS_TIME_UNDEFINED}. */
	public long StartTime;
	/** The POSIX timestamp for the end time, or {@link EOS_Leaderboards_QueryLeaderboardDefinitionsOptions#EOS_LEADERBOARDS_TIME_UNDEFINED}. */
	public long EndTime;

	public EOS_Leaderboards_Definition() {
		super();
		ApiVersion = EOS_LEADERBOARDS_DEFINITION_API_LATEST;
	}

	public EOS_Leaderboards_Definition(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with leaderboard record. This must be called on data retrieved from
	 * EOS_Leaderboards_CopyLeaderboardRecordByIndex or EOS_Leaderboards_CopyLeaderboardRecordByUserId.
	 *
	 * @see EOS_Leaderboards_LeaderboardRecord
	 * @see EOS_Leaderboards_Interface#copyLeaderboardRecordByIndex(EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions)
	 * @see EOS_Leaderboards_Interface#copyLeaderboardRecordByUserId(EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Leaderboards_Definition_Release(this);
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