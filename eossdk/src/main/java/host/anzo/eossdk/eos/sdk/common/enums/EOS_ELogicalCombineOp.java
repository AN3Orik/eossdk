package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * The EOS Logical Combine Operator.
 *
 * @author Anton Lasevich
 * @since 9/12/2026
 */
public @Getter enum EOS_ELogicalCombineOp implements NativeMapped {
	/** The AND operator used to logically combine comparison operations. */
	EOS_LCO_AND(0),
	/** The OR operator used to logically combine comparison operations. */
	EOS_LCO_OR(1);

	private final int id;

	private static final Map<Integer, EOS_ELogicalCombineOp> values = new HashMap<>();

	static {
		for (EOS_ELogicalCombineOp result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELogicalCombineOp(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_LCO_AND);
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