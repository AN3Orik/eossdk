package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

/**
 * @author ANZO
 * @since 9/20/2023
 */
public @Getter class EOS_Bool implements NativeMapped {
	public static final EOS_Bool EOS_TRUE = new EOS_Bool(true);
	public static final EOS_Bool EOS_FALSE = new EOS_Bool(false);

	private final Boolean value;

	public EOS_Bool() {
		value = null;
	}

	private EOS_Bool(boolean value) {
		this.value = value;
	}

	public static EOS_Bool of(boolean value) {
		return value ? EOS_TRUE : EOS_FALSE;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		if(nativeValue == null) {
			return EOS_Bool.EOS_FALSE;
		}
		else {
			final int value = (int) nativeValue;
			return value == 1 ? EOS_Bool.EOS_TRUE : EOS_Bool.EOS_FALSE;
		}
	}

	@Override
	public Object toNative() {
		return value != null && value ? 1 : 0;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}