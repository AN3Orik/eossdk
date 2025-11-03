package host.anzo.eossdk.eos.sdk.progressionsnapshot.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_ProgressionSnapshot_DeleteSnapshot} function.
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_ProgressionSnapshot_DeleteSnapshotOptions extends Structure {
	/** The most recent version of the EOS_ProgressionSnapshot_DeleteSnapshot API. */
	public static final int EOS_PROGRESSIONSNAPSHOT_DELETESNAPSHOT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PROGRESSIONSNAPSHOT_DELETESNAPSHOT_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user to whom the key/value pair belong */
	public EOS_ProductUserId LocalUserId;

	public EOS_ProgressionSnapshot_DeleteSnapshotOptions() {
		super();
		ApiVersion = EOS_PROGRESSIONSNAPSHOT_DELETESNAPSHOT_API_LATEST;
	}

	public EOS_ProgressionSnapshot_DeleteSnapshotOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_DeleteSnapshotOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_DeleteSnapshotOptions implements Structure.ByValue {
	}
}
