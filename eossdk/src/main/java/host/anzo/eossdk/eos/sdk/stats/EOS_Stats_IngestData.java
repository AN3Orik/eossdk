package host.anzo.eossdk.eos.sdk.stats;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single stat to ingest.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "StatName", "IngestAmount"})
public class EOS_Stats_IngestData extends Structure {
	/** The most recent version of the EOS_Stats_IngestData struct. */
	public static final int EOS_STATS_INGESTDATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_STATS_INGESTDATA_API_LATEST}. */
	public int ApiVersion;
	/** The name of the stat to ingest. */
	public String StatName;
	/** The amount to ingest the stat. */
	public int IngestAmount;

	public EOS_Stats_IngestData() {
		super();
		ApiVersion = EOS_STATS_INGESTDATA_API_LATEST;
	}

	public EOS_Stats_IngestData(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_IngestData implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_IngestData implements Structure.ByValue {
	}
}