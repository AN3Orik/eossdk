package host.anzo.eossdk.eos.sdk.stats.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Stats_CopyStatByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "StatIndex"})
public class EOS_Stats_CopyStatByIndexOptions extends Structure {
	/** The most recent version of the EOS_Stats_CopyStatByIndexOptions struct. */
	public static int EOS_STATS_COPYSTATBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_STATS_COPYSTATBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user who owns the stat */
	public EOS_ProductUserId TargetUserId;
	/** Index of the stat to retrieve from the cache */
	public int StatIndex;

	public EOS_Stats_CopyStatByIndexOptions() {
		super();
		ApiVersion = EOS_STATS_COPYSTATBYINDEX_API_LATEST;
	}

	public EOS_Stats_CopyStatByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_CopyStatByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_CopyStatByIndexOptions implements Structure.ByValue {
	}
}