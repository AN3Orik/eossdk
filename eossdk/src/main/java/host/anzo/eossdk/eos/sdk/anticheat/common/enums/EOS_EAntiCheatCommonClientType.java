package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Flags describing the type of a remote client
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientType implements NativeMapped {
	/** An ordinary player that requires anti-cheat client protection to play */
	EOS_ACCCT_ProtectedClient(0),
	/** The player does not need the anti-cheat client to play because of their platform or other factors */
	EOS_ACCCT_UnprotectedClient(1),
	/** The client is an AI bot, not an actual human */
	EOS_ACCCT_AIBot(2);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientType> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCT_ProtectedClient);
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