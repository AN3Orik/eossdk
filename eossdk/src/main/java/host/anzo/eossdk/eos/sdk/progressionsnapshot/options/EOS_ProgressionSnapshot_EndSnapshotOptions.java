package host.anzo.eossdk.eos.sdk.progressionsnapshot.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "SnapshotId"})
public class EOS_ProgressionSnapshot_EndSnapshotOptions extends Structure {
	public static final int EOS_PROGRESSIONSNAPSHOT_ENDSNAPSHOT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PROGRESSIONSNAPSHOT_ENDSNAPSHOT_API_LATEST}. */
	public int ApiVersion;
	/** The Snapshot Id received via a EOS_ProgressionSnapshot_BeginSnapshot function. */
	public int SnapshotId;

	public EOS_ProgressionSnapshot_EndSnapshotOptions() {
		super();
		ApiVersion = EOS_PROGRESSIONSNAPSHOT_ENDSNAPSHOT_API_LATEST;
	}

	public EOS_ProgressionSnapshot_EndSnapshotOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_EndSnapshotOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_EndSnapshotOptions implements Structure.ByValue {
	}
}
