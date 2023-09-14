package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sessions_OnLeaveSessionRequestedCallback Function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "SessionName"})
public class EOS_Sessions_LeaveSessionRequestedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Sessions_OnLeaveSessionRequestedCallback */
	public Pointer ClientData;
	/** The Product User ID of the local user who received the leave session notification. */
	public EOS_ProductUserId LocalUserId;
	/** Name of the session associated with the leave session request. */
	public String SessionName;

	public EOS_Sessions_LeaveSessionRequestedCallbackInfo() {
		super();
	}

	public EOS_Sessions_LeaveSessionRequestedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_LeaveSessionRequestedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_LeaveSessionRequestedCallbackInfo implements Structure.ByValue {
	}
}