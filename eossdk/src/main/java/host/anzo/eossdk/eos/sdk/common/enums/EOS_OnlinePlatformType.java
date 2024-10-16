package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public @Getter enum EOS_OnlinePlatformType implements NativeMapped {
	EOS_OPT_Unknown(0),
	EOS_OPT_Epic(100),
	EOS_OPT_PSN(1000),
	EOS_OPT_Nintendo(2000),
	EOS_OPT_XBL(3000),
	EOS_OPT_Steam(4000);

	private final int id;

	private static final Map<Integer, EOS_OnlinePlatformType> values = new HashMap<>();

	static {
		for (EOS_OnlinePlatformType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_OnlinePlatformType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_OPT_Unknown);
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