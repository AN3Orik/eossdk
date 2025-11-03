package host.anzo.eossdk.eos.sdk.presence.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing the types that may be passed as template data.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
public @Getter enum EOS_EPresenceModificationTemplateType implements NativeMapped {
	/** (32-bit) integer type */
	EOS_PMT_INT(1),
	/** UTF8 String as an identifier */
	EOS_PMT_STRING(2);

	private final int id;

	private static final Map<Integer, EOS_EPresenceModificationTemplateType> values = new HashMap<>();

	static {
		for (EOS_EPresenceModificationTemplateType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EPresenceModificationTemplateType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_PMT_INT);
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