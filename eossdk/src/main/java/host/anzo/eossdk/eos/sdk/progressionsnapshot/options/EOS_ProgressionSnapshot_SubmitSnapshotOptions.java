package host.anzo.eossdk.eos.sdk.progressionsnapshot.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_ProgressionSnapshot_SubmitSnapshot} function.
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "SnapshotId"})
public class EOS_ProgressionSnapshot_SubmitSnapshotOptions extends Structure {
	/** The most recent version of the EOS_ProgressionSnapshot_SubmitSnapshot API. */
	public static final int EOS_PROGRESSIONSNAPSHOT_SUBMITSNAPSHOT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PROGRESSIONSNAPSHOT_SUBMITSNAPSHOT_API_LATEST}. */
	public int ApiVersion;
	/** The Snapshot Id received via a EOS_ProgressionSnapshot_BeginSnapshot function. */
	public int SnapshotId;

	public EOS_ProgressionSnapshot_SubmitSnapshotOptions() {
		super();
		ApiVersion = EOS_PROGRESSIONSNAPSHOT_SUBMITSNAPSHOT_API_LATEST;
	}

	public EOS_ProgressionSnapshot_SubmitSnapshotOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_SubmitSnapshotOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_SubmitSnapshotOptions implements Structure.ByValue {
	}
}