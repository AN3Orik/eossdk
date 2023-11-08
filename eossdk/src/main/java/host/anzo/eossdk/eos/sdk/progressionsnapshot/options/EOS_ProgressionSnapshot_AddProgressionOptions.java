package host.anzo.eossdk.eos.sdk.progressionsnapshot.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "SnapshotId", "Key", "Value"})
public class EOS_ProgressionSnapshot_AddProgressionOptions extends Structure {
	public static final int EOS_PROGRESSIONSNAPSHOT_ADDPROGRESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PROGRESSIONSNAPSHOT_ADDPROGRESSION_API_LATEST}. */
	public int ApiVersion;
	/** The Snapshot Id received via a EOS_ProgressionSnapshot_BeginSnapshot function. */
	public int SnapshotId;
	/** The key in a key/value pair of progression entry */
	public String Key;
	/** The value in a key/value pair of progression entry */
	public String Value;

	public EOS_ProgressionSnapshot_AddProgressionOptions() {
		super();
		ApiVersion = EOS_PROGRESSIONSNAPSHOT_ADDPROGRESSION_API_LATEST;
	}

	public EOS_ProgressionSnapshot_AddProgressionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_AddProgressionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_AddProgressionOptions implements Structure.ByValue {
	}
}