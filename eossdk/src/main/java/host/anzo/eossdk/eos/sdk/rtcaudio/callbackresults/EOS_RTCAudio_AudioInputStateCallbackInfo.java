package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.enums.EOS_ERTCAudioInputStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_AddNotifyAudioInputState registered event.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "Status"})
public class EOS_RTCAudio_AudioInputStateCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCAudio_AddNotifyAudioInputState. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** The status of the audio input. */
	public EOS_ERTCAudioInputStatus Status;

	public EOS_RTCAudio_AudioInputStateCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_AudioInputStateCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AudioInputStateCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AudioInputStateCallbackInfo implements Structure.ByValue {
	}
}