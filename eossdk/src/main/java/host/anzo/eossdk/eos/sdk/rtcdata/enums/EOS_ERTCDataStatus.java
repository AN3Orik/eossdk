package host.anzo.eossdk.eos.sdk.rtcdata.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different data channel statuses.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
public enum EOS_ERTCDataStatus implements NativeMapped {
	/** Data unsupported */
	EOS_RTCDS_Unsupported(0),
	/** Data enabled */
	EOS_RTCDS_Enabled(1),
	/** Data disabled */
	EOS_RTCDS_Disabled(2);

	private final int id;

	private static final Map<Integer, EOS_ERTCDataStatus> values = new HashMap<>();

	static {
		for (EOS_ERTCDataStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCDataStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTCDS_Unsupported);
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