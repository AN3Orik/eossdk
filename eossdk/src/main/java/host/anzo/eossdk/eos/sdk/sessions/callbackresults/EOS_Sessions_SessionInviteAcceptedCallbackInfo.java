package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sessions_OnSessionInviteAcceptedCallback function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ClientData", "SessionId", "LocalUserId", "TargetUserId", "InviteId"})
public class EOS_Sessions_SessionInviteAcceptedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Sessions_AddNotifySessionInviteAccepted */
	public Pointer ClientData;
	/** Session ID that should be used for joining */
	public String SessionId;
	/** The Product User ID of the user who accepted the invitation */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the user who sent the invitation */
	public EOS_ProductUserId TargetUserId;
	/** Invite ID that was accepted */
	public String InviteId;

	public EOS_Sessions_SessionInviteAcceptedCallbackInfo() {
		super();
	}

	public EOS_Sessions_SessionInviteAcceptedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_SessionInviteAcceptedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_SessionInviteAcceptedCallbackInfo implements Structure.ByValue {
	}
}