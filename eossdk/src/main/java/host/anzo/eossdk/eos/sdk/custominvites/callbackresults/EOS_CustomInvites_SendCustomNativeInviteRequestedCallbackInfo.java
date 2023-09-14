package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_UI_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.ui.options.EOS_UI_AcknowledgeEventIdOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_OnSendCustomNativeInviteRequestedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "UiEventId", "LocalUserId", "TargetNativeAccountType", "TargetUserNativeAccountId", "InviteId"})
public class EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo extends Structure {
	/** Context that was passed into EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested */
	public Pointer ClientData;
	/**
	 * Identifies this event which will need to be acknowledged with EOS_UI_AcknowledgeEventId().
	 * @see EOS_UI_Interface#acknowledgeEventId(EOS_UI_AcknowledgeEventIdOptions)
	 */
	public long UiEventId;
	/** The Product User ID of the local user who is inviting. */
	public EOS_ProductUserId LocalUserId;
	/**
	 * The Native Platform Account Type. If only a single integrated platform is configured then
	 * this will always reference that platform.
	 */
	public String TargetNativeAccountType;
	/** The Native Platform Account ID of the target user being invited. */
	public String TargetUserNativeAccountId;
	/** Invite ID that the user is being invited to */
	public String InviteId;

	public EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo implements Structure.ByValue {
	}
}