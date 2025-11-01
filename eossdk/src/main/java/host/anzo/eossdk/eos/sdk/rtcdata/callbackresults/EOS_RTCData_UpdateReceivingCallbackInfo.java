package host.anzo.eossdk.eos.sdk.rtcdata.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCData_OnUpdateReceivingCallback.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "ParticipantId", "IsDataEnabled"})
public class EOS_RTCData_UpdateReceivingCallbackInfo extends Structure {
	/**
	 * This returns:
	 * <p>
	 * {@link EOS_EResult#EOS_Success} if the operation succeeded
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect
	 * {@link EOS_EResult#EOS_NotFound} if either the local user or specified participant are not in the room
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCData_UpdateReceiving. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** The participant to modify or null to update the global configuration */
	public EOS_ProductUserId ParticipantId;
	/** Created or destroyed data channel */
	public EOS_Bool IsDataEnabled;

	public EOS_RTCData_UpdateReceivingCallbackInfo() {
		super();
	}

	public EOS_RTCData_UpdateReceivingCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCData_UpdateReceivingCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_UpdateReceivingCallbackInfo implements Structure.ByValue {
	}
}