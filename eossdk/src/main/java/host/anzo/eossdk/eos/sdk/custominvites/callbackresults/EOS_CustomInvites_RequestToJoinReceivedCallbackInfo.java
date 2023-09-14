package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_AddNotifyRequestToJoinReceived function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "FromUserId", "ToUserId"})
public class EOS_CustomInvites_RequestToJoinReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_CustomInvites_AddNotifyRequestToJoinReceived */
	public Pointer ClientData;
	/** User that sent this response */
	public EOS_ProductUserId FromUserId;
	/** Recipient Local user id */
	public EOS_ProductUserId ToUserId;

	public EOS_CustomInvites_RequestToJoinReceivedCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_RequestToJoinReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_RequestToJoinReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_RequestToJoinReceivedCallbackInfo implements Structure.ByValue {
	}
}