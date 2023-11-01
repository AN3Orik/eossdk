package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Anti-cheat operating modes
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public @Getter enum EOS_EAntiCheatClientMode implements NativeMapped {
	/** Not used */
	EOS_ACCM_Invalid(0),
	/** Dedicated or listen server mode */
	EOS_ACCM_ClientServer(1),
	/** Full mesh peer-to-peer mode */
	EOS_ACCM_PeerToPeer(2);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatClientMode> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatClientMode result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatClientMode(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCM_Invalid);
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