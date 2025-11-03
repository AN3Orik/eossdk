package host.anzo.eossdk.eos.sdk.progressionsnapshot.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the {@link EOSLibrary#EOS_ProgressionSnapshot_DeleteSnapshot} Function.
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "LocalUserId", "ClientData"})
public class EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** The Product User ID of the local user to whom the key/value pair belong */
	public EOS_ProductUserId LocalUserId;
	/** Context that was passed into EOS_ProgressionSnapshot_SubmitSnapshot. */
	public Pointer ClientData;

	public EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo() {
		super();
	}

	public EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo implements Structure.ByValue {
	}
}