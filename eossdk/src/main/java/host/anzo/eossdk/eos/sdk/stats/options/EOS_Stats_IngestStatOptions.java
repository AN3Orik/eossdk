package host.anzo.eossdk.eos.sdk.stats.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.stats.EOS_Stats_IngestData;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Stats_IngestStat function.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Stats", "StatsCount", "TargetUserId"})
public class EOS_Stats_IngestStatOptions extends Structure {
	/** Maximum number of stats that can be ingested in a single EOS_Stats_IngestStat operation. */
	public static final int EOS_STATS_MAX_INGEST_STATS = 3000;

	/** The most recent version of the EOS_Stats_IngestStat struct. */
	public static final int EOS_STATS_INGESTSTAT_API_LATEST = 3;

	/** API Version: Set this to EOS_STATS_INGESTSTAT_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user requesting the ingest.  Set to null for dedicated server. */
	public EOS_ProductUserId LocalUserId;
	/** Stats to ingest. */
	public EOS_Stats_IngestData.ByReference Stats;
	/** The number of stats to ingest, may not exceed {@link EOS_Stats_IngestStatOptions#EOS_STATS_MAX_INGEST_STATS}. */
	public int StatsCount;
	/** The Product User ID for the user whose stat is being ingested. */
	public EOS_ProductUserId TargetUserId;

	public EOS_Stats_IngestStatOptions() {
		super();
		ApiVersion = EOS_STATS_INGESTSTAT_API_LATEST;
	}

	public EOS_Stats_IngestStatOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_IngestStatOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_IngestStatOptions implements Structure.ByValue {
	}
}