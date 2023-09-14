package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_OnCustomInviteRejectedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "TargetUserId", "LocalUserId", "CustomInviteId", "Payload"})
public class EOS_CustomInvites_CustomInviteRejectedCallbackInfo extends Structure {
	/** Context that was passed into EOS_CustomInvites_AddNotifyCustomInviteRejected */
	public Pointer ClientData;
	/** User that sent the custom invite */
	public EOS_ProductUserId TargetUserId;
	/** Recipient Local user id */
	public EOS_ProductUserId LocalUserId;
	/** Id of the rejected Custom Invite */
	public String CustomInviteId;
	/** Payload of the rejected Custom Invite */
	public String Payload;

	public EOS_CustomInvites_CustomInviteRejectedCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_CustomInviteRejectedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_CustomInviteRejectedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_CustomInviteRejectedCallbackInfo implements Structure.ByValue {
	}
}