package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Types of network connections.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public @Getter enum EOS_ENetworkConnectionType implements NativeMapped {
	/** There is no established connection */
	EOS_NCT_NoConnection(0),
	/** A direct connection to the peer over the Internet or Local Network */
	EOS_NCT_DirectConnection(1),
	/** A relayed connection using Epic-provided servers to the peer over the Internet */
	EOS_NCT_RelayedConnection(2);

	private final int id;

	private static final Map<Integer, EOS_ENetworkConnectionType> values = new HashMap<>();

	static {
		for (EOS_ENetworkConnectionType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ENetworkConnectionType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_NCT_NoConnection);
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