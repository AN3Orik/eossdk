package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Flags describing a remote client. These can be updated during a play session
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientAuthStatus implements NativeMapped {
	/** Not used */
	EOS_ACCCAS_Invalid(0),
	/** The client/peer's anti-cheat functionality has been validated by this game server */
	EOS_ACCCAS_LocalAuthComplete(1),
	/** The client/peer's anti-cheat functionality has been validated by the anti-cheat backend service */
	EOS_ACCCAS_RemoteAuthComplete(2);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientAuthStatus> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientAuthStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientAuthStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCAS_Invalid);
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