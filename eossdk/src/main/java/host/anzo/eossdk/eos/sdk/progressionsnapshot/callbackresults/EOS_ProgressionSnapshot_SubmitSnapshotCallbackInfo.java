package host.anzo.eossdk.eos.sdk.progressionsnapshot.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "SnapshotId", "ClientData"})
public class EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** The Snapshot Id used in the Submit function. */
	public int SnapshotId;
	/** Context that was passed into EOS_ProgressionSnapshot_SubmitSnapshot. */
	public Pointer ClientData;

	public EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo() {
		super();
	}

	public EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo implements Structure.ByValue {
	}
}