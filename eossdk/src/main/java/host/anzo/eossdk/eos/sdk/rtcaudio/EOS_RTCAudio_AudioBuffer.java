package host.anzo.eossdk.eos.sdk.rtcaudio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.nio.ShortBuffer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to represent an audio buffer received in callbacks from EOS_RTCAudio_AddNotifyAudioBeforeSend and EOS_RTCAudio_AddNotifyAudioBeforeRender.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "Frames", "FramesCount", "SampleRate", "Channels"})
public class EOS_RTCAudio_AudioBuffer extends Structure {
	/** The most recent version of the EOS_RTCAudio_AudioBuffer API */
	public static final int EOS_RTCAUDIO_AUDIOBUFFER_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_AUDIOBUFFER_API_LATEST. */
	public int ApiVersion;
	/** Pointer to the data with the interleaved audio frames in signed 16 bits format. */
	public ShortBuffer Frames;
	public int FramesCount;
	public int SampleRate;
	public int Channels;

	public EOS_RTCAudio_AudioBuffer() {
		super();
		ApiVersion = EOS_RTCAUDIO_AUDIOBUFFER_API_LATEST;
	}

	public EOS_RTCAudio_AudioBuffer(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AudioBuffer implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AudioBuffer implements Structure.ByValue {
	}
}