package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_OnUpdateReceivingCallback.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "ParticipantId", "IsAudioEnabled"})
public class EOS_RTCAudio_UpdateReceivingCallbackInfo extends Structure {
	/**
	 * This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if receiving of channels of remote users was successfully enabled/disabled.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect.<br>
	 * {@link EOS_EResult#EOS_NotFound} if the participant isn't found by ParticipantId.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCAudio_UpdateReceiving. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** The participant to modify or null to update the global configuration */
	public EOS_ProductUserId ParticipantId;
	/** Muted or unmuted audio track */
	public EOS_Bool IsAudioEnabled;

	public EOS_RTCAudio_UpdateReceivingCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_UpdateReceivingCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateReceivingCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateReceivingCallbackInfo implements Structure.ByValue {
	}
}