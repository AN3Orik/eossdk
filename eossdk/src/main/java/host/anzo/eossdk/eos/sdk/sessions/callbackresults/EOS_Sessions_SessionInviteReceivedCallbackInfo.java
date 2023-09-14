package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sessions_OnSessionInviteReceivedCallback function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "TargetUserId", "InviteId"})
public class EOS_Sessions_SessionInviteReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Sessions_AddNotifySessionInviteReceived */
	public Pointer ClientData;
	/** The Product User ID of the user who received the invite */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the user who sent the invitation */
	public EOS_ProductUserId TargetUserId;
	/** Invite ID used to retrieve the actual session details */
	public String InviteId;

	public EOS_Sessions_SessionInviteReceivedCallbackInfo() {
		super();
	}

	public EOS_Sessions_SessionInviteReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_SessionInviteReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_SessionInviteReceivedCallbackInfo implements Structure.ByValue {
	}
}