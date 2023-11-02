package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.EOS_RTCAudio_AudioBuffer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_AddNotifyAudioBeforeRender registered event.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "Buffer", "ParticipantId"})
public class EOS_RTCAudio_AudioBeforeRenderCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCAudio_AddNotifyAudioBeforeRender. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** Audio buffer. */
	public EOS_RTCAudio_AudioBuffer.ByReference Buffer;
	/**
	 * The Product User ID of the participant if bUnmixedAudio was set to true when setting the notifications, or empty if
	 * bUnmixedAudio was set to false and thus the buffer is the mixed audio of all participants
	 */
	public EOS_ProductUserId ParticipantId;

	public EOS_RTCAudio_AudioBeforeRenderCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_AudioBeforeRenderCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AudioBeforeRenderCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AudioBeforeRenderCallbackInfo implements Structure.ByValue {
	}
}