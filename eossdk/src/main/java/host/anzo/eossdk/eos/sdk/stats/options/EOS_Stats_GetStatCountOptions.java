package host.anzo.eossdk.eos.sdk.stats.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Stats_GetStatsCount function.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_Stats_GetStatCountOptions extends Structure {
	/** The most recent version of the EOS_Stats_GetStatsCount API. */
	public static final int EOS_STATS_GETSTATSCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_STATS_GETSTATSCOUNT_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID for the user whose stats are being counted */
	public EOS_ProductUserId TargetUserId;

	public EOS_Stats_GetStatCountOptions() {
		super();
		ApiVersion = EOS_STATS_GETSTATSCOUNT_API_LATEST;
	}

	public EOS_Stats_GetStatCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_GetStatCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_GetStatCountOptions implements Structure.ByValue {
	}
}