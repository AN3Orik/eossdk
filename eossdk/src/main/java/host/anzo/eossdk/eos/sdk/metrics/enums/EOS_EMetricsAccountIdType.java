package host.anzo.eossdk.eos.sdk.metrics.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Account ID type for EOS_Metrics_BeginPlayerSession and EOS_Metrics_EndPlayerSession.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_EMetricsAccountIdType implements NativeMapped {
	/** An Epic Account ID. */
	EOS_MAIT_Epic(0),
	/** An external service Account ID. */
	EOS_MAIT_External(1);

	private final int id;

	private static final Map<Integer, EOS_EMetricsAccountIdType> values = new HashMap<>();

	static {
		for (EOS_EMetricsAccountIdType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EMetricsAccountIdType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_MAIT_Epic);
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