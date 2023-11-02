package host.anzo.eossdk.eos.sdk.rtcaudio.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different audio channel statuses.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public enum EOS_ERTCAudioStatus implements NativeMapped {
	/** Audio unsupported by the source (no devices) */
	EOS_RTCAS_Unsupported(0),
	/** Audio enabled */
	EOS_RTCAS_Enabled(1),
	/** Audio disabled */
	EOS_RTCAS_Disabled(2),
	/** Audio disabled by the administrator */
	EOS_RTCAS_AdminDisabled(3),
	/** Audio channel is disabled temporarily for both sending and receiving */
	EOS_RTCAS_NotListeningDisabled(4);

	private final int id;

	private static final Map<Integer, EOS_ERTCAudioStatus> values = new HashMap<>();

	static {
		for (EOS_ERTCAudioStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCAudioStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTCAS_Unsupported);
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