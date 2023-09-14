package host.anzo.eossdk.eos.sdk.stats.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Stats_QueryStats function.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "StartTime", "EndTime", "StatNames", "StatNamesCount", "TargetUserId"})
public class EOS_Stats_QueryStatsOptions extends Structure {
	/** Maximum number of stats that can be queried in a single EOS_Stats_QueryStats operation. */
	public static int EOS_STATS_MAX_QUERY_STATS = 1000;

	/** The most recent version of the EOS_Stats_QueryStats struct. */
	public static int EOS_STATS_QUERYSTATS_API_LATEST = 3;

	/** API Version: Set this to EOS_STATS_QUERYSTATS_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user requesting the stats. Set to null for dedicated server. */
	public EOS_ProductUserId LocalUserId;
	/** If not EOS_STATS_TIME_UNDEFINED then this is the POSIX timestamp for start time (Optional). */
	public long StartTime;
	/** If not EOS_STATS_TIME_UNDEFINED then this is the POSIX timestamp for end time (Optional). */
	public long EndTime;
	/** An array of stat names to query for (Optional). */
	public PointerByReference StatNames;
	/** The number of stat names included in query (Optional), may not exceed {@link EOS_Stats_QueryStatsOptions#EOS_STATS_MAX_QUERY_STATS}. */
	public int StatNamesCount;
	/** The Product User ID for the user whose stats are being retrieved */
	public EOS_ProductUserId TargetUserId;

	public EOS_Stats_QueryStatsOptions() {
		super();
		ApiVersion = EOS_STATS_QUERYSTATS_API_LATEST;
	}

	public EOS_Stats_QueryStatsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_QueryStatsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_QueryStatsOptions implements Structure.ByValue {
	}
}