package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_OnRequestToJoinRejectedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "TargetUserId", "LocalUserId"})
public class EOS_CustomInvites_OnRequestToJoinRejectedCallbackInfo extends Structure {
	/** Context that was passed into EOS_CustomInvites_AddNotifyCustomInviteRejected */
	public Pointer ClientData;
	/** User that sent the custom invite */
	public EOS_ProductUserId TargetUserId;
	/** Recipient Local user id */
	public EOS_ProductUserId LocalUserId;

	public EOS_CustomInvites_OnRequestToJoinRejectedCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_OnRequestToJoinRejectedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_OnRequestToJoinRejectedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_OnRequestToJoinRejectedCallbackInfo implements Structure.ByValue {
	}
}