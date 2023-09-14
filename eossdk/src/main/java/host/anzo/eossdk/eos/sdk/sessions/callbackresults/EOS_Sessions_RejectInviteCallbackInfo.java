package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sessions_RejectInvite function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_Sessions_RejectInviteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the invite rejection completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if the invite does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sessions_RejectInvite */
	public Pointer ClientData;

	public EOS_Sessions_RejectInviteCallbackInfo() {
		super();
	}

	public EOS_Sessions_RejectInviteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_RejectInviteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_RejectInviteCallbackInfo implements Structure.ByValue {
	}
}