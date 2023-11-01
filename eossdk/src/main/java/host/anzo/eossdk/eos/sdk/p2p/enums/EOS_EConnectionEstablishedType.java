package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Type of established connection
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public @Getter enum EOS_EConnectionEstablishedType implements NativeMapped {
	/** The connection is brand new */
	EOS_CET_NewConnection(0),
	/** The connection is reestablished (reconnection) */
	EOS_CET_Reconnection(1);

	private final int id;

	private static final Map<Integer, EOS_EConnectionEstablishedType> values = new HashMap<>();

	static {
		for (EOS_EConnectionEstablishedType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EConnectionEstablishedType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_CET_NewConnection);
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