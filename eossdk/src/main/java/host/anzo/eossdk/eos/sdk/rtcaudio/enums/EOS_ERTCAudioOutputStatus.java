package host.anzo.eossdk.eos.sdk.rtcaudio.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different audio output device statuses.
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public enum EOS_ERTCAudioOutputStatus implements NativeMapped {
	/** The device is not in used right now (e.g: you are alone in the room). In such cases, the hardware resources are not allocated. */
	EOS_RTCAOS_Idle(0),
	/** Device is in use */
	EOS_RTCAOS_Playing(1),
	/** Something failed while trying to use the device */
	EOS_RTCAOS_Failed(2);

	private final int id;

	private static final Map<Integer, EOS_ERTCAudioOutputStatus> values = new HashMap<>();

	static {
		for (EOS_ERTCAudioOutputStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCAudioOutputStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTCAOS_Idle);
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