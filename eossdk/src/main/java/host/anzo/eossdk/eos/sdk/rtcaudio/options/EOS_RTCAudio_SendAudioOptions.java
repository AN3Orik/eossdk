package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.EOS_RTCAudio_AudioBuffer;

/**
 * This struct is used to call EOS_RTCAudio_SendAudio.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "Buffer"})
public class EOS_RTCAudio_SendAudioOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_SendAudio API. */
	public static final int EOS_RTCAUDIO_SENDAUDIO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_SENDAUDIO_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;
	/**
	 * Audio buffer, which must have a duration of 10 ms.<br>
	 * <b>The SDK makes a copy of buffer. There is no need to keep the buffer around after calling EOS_RTCAudio_SendAudio</b>
	 */
	public EOS_RTCAudio_AudioBuffer.ByReference Buffer;

	public EOS_RTCAudio_SendAudioOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_SENDAUDIO_API_LATEST;
	}

	public EOS_RTCAudio_SendAudioOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_SendAudioOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_SendAudioOptions implements Structure.ByValue {
	}
}