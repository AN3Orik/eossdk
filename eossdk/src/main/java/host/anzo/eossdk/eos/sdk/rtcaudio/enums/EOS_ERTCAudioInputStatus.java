package host.anzo.eossdk.eos.sdk.rtcaudio.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different audio input device statuses.
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public enum EOS_ERTCAudioInputStatus implements NativeMapped {
	/** The device is not in used right now (e.g: you are alone in the room). In such cases, the hardware resources are not allocated. */
	EOS_RTCAIS_Idle(0),
	/** The device is being used and capturing audio */
	EOS_RTCAIS_Recording(1),
	/**
	 * The SDK is in a recording state, but actually capturing silence because the device is exclusively being used by the platform at the moment.
	 * This only applies to certain platforms.
	 */
	EOS_RTCAIS_RecordingSilent(2),
	/**
	 * The SDK is in a recording state, but actually capturing silence because the device is disconnected (e.g: the microphone is not plugged in).
	 * This only applies to certain platforms.
	 */
	EOS_RTCAIS_RecordingDisconnected(3),
	/** Something failed while trying to use the device */
	EOS_RTCAIS_Failed(4);

	private final int id;

	private static final Map<Integer, EOS_ERTCAudioInputStatus> values = new HashMap<>();

	static {
		for (EOS_ERTCAudioInputStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCAudioInputStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTCAIS_Idle);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}