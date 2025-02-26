package host.anzo.eossdk.eos.sdk.ecom.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration defining the possible orientation for the checkout page. This will be used on mobile.
 * @author Anton Lasevich
 * @since 2/26/2025
 */
public enum EOS_ECheckoutOrientation implements NativeMapped {
	/** Current orientation will be used */
	EOS_ECO_Default(0),
	/** Portrait orientation */
	EOS_ECO_Portrait(1),
	/** Landscape orientation */
	EOS_ECO_Landscape(2);

	private final int id;

	private static final Map<Integer, EOS_ECheckoutOrientation> values = new HashMap<>();

	static {
		for (EOS_ECheckoutOrientation result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ECheckoutOrientation(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ECO_Default);
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