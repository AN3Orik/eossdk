package host.anzo.eossdk.eos.sdk.mods.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * The type of mod enumeration.
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public @Getter enum EOS_EModEnumerationType implements NativeMapped {
	/** Installed mods */
	EOS_MET_INSTALLED(0),
	/** All available mods*/
	EOS_MET_ALL_AVAILABLE(1);

	private final int id;

	private static final Map<Integer, EOS_EModEnumerationType> values = new HashMap<>();

	static {
		for (EOS_EModEnumerationType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EModEnumerationType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_MET_INSTALLED);
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