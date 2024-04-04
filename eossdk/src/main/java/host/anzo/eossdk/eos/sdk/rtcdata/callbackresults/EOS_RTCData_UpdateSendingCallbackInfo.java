package host.anzo.eossdk.eos.sdk.rtcdata.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.*;

/**
 * This struct is passed in with a call to EOS_RTCData_OnUpdateSendingCallback.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "IsDataEnabled"})
public class EOS_RTCData_UpdateSendingCallbackInfo extends Structure {
	/**
	 * This returns:
	 * <p>
	 * {@link EOS_EResult#EOS_Success} if the operation succeeded<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if the local user is not in the room
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCData_UpdateSending. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** Created or destroyed data channel */
	public EOS_Bool IsDataEnabled;

	public EOS_RTCData_UpdateSendingCallbackInfo() {
		super();
	}

	public EOS_RTCData_UpdateSendingCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCData_UpdateSendingCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_UpdateSendingCallbackInfo implements Structure.ByValue {
	}
}