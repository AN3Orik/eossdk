package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Types supported for custom gameplay behavior events.
 * These have a considerable impact on performance
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonEventType implements NativeMapped {
	/** Not used */
	EOS_ACCET_Invalid(0),
	/**
	 * A general game event that is not specific to any individual player.
	 * Low memory use which is constant with respect to the number of players.
	 */
	EOS_ACCET_GameEvent(1),
	/**
	 * An event that is logically associated with a specific player. Events logged in
	 * this category require a specific ClientHandle to which they will be attached.
	 * Higher memory use which scales according to the number of players.
	 */
	EOS_ACCET_PlayerEvent(2);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonEventType> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonEventType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonEventType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCET_Invalid);
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