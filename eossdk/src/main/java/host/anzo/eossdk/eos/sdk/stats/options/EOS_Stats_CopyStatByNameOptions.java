package host.anzo.eossdk.eos.sdk.stats.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Stats_CopyStatByName function.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "Name"})
public class EOS_Stats_CopyStatByNameOptions extends Structure {
	/** The most recent version of the EOS_Stats_CopyStatByNameOptions struct. */
	public static final int EOS_STATS_COPYSTATBYNAME_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_STATS_COPYSTATBYNAME_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user who owns the stat */
	public EOS_ProductUserId TargetUserId;
	/** Name of the stat to retrieve from the cache */
	public String Name;

	public EOS_Stats_CopyStatByNameOptions() {
		super();
		ApiVersion = EOS_STATS_COPYSTATBYNAME_API_LATEST;
	}

	public EOS_Stats_CopyStatByNameOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_CopyStatByNameOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_CopyStatByNameOptions implements Structure.ByValue {
	}
}