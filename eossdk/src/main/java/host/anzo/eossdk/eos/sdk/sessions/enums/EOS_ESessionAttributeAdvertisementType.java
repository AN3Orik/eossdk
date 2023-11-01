package host.anzo.eossdk.eos.sdk.sessions.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Advertisement properties for a single attribute associated with a session
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
public @Getter enum EOS_ESessionAttributeAdvertisementType implements NativeMapped {
	/** Don't advertise via the online service */
	EOS_SAAT_DontAdvertise(0),
	/** Advertise via the online service only */
	EOS_SAAT_Advertise(1);

	private final int id;

	private static final Map<Integer, EOS_ESessionAttributeAdvertisementType> values = new HashMap<>();

	static {
		for (EOS_ESessionAttributeAdvertisementType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ESessionAttributeAdvertisementType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_SAAT_DontAdvertise);
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