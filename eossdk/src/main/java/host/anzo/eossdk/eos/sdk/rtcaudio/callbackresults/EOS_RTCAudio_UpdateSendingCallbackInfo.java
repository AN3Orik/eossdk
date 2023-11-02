package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtcaudio.enums.EOS_ERTCAudioStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_OnUpdateSendingCallback.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "AudioStatus"})
public class EOS_RTCAudio_UpdateSendingCallbackInfo extends Structure {
	/**
	 * This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if sending of channels of the local user was successfully enabled/disabled.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrectv
	 * {@link EOS_EResult#EOS_NotFound} if the local user is not in the room<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCAudio_UpdateSending. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** Muted or unmuted audio track status */
	public EOS_ERTCAudioStatus AudioStatus;

	public EOS_RTCAudio_UpdateSendingCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_UpdateSendingCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateSendingCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateSendingCallbackInfo implements Structure.ByValue {
	}
}