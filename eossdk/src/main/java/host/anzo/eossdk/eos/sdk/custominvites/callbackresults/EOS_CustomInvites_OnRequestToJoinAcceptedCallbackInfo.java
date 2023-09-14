package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_OnRequestToJoinAcceptedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "TargetUserId", "LocalUserId"})
public class EOS_CustomInvites_OnRequestToJoinAcceptedCallbackInfo extends Structure {
	/** Context that was passed into EOS_CustomInvites_AddNotifyRequestToJoinAccepted */
	public Pointer ClientData;
	/** User that sent the request to join */
	public EOS_ProductUserId TargetUserId;
	/** Local user ID of the Request to Join recipient */
	public EOS_ProductUserId LocalUserId;

	public EOS_CustomInvites_OnRequestToJoinAcceptedCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_OnRequestToJoinAcceptedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_OnRequestToJoinAcceptedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_OnRequestToJoinAcceptedCallbackInfo implements Structure.ByValue {
	}
}