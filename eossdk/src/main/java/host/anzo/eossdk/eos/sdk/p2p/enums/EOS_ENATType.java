package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Categories of NAT strictness.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_ENATType implements NativeMapped {
	/** NAT type either unknown (remote) or we are unable to determine it (local) */
	EOS_NAT_Unknown(0),
	/** All peers can directly-connect to you */
	EOS_NAT_Open(1),
	/** You can directly-connect to other Moderate and Open peers */
	EOS_NAT_Moderate(2),
	/** You can only directly-connect to Open peers */
	EOS_NAT_Strict(3);

	private final int id;

	private static final Map<Integer, EOS_ENATType> values = new HashMap<>();

	static {
		for (EOS_ENATType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ENATType(int id) {
		this.id = id;
	}

	@SuppressWarnings("unused")
	public static EOS_ENATType fromId(Integer id) {
		return values.getOrDefault(id, EOS_NAT_Unknown);
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_NAT_Unknown);
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