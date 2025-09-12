package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Details of a player's movement state
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonPlayerMovementState implements NativeMapped {
	/** No particular state applies */
	EOS_ACCPMS_None(0),
	/** Player is crouching */
	EOS_ACCPMS_Crouching(1),
	/** Player is prone */
	EOS_ACCPMS_Prone(2),
	/** Player is mounted in a vehicle or similar */
	EOS_ACCPMS_Mounted(3),
	/** Player is swimming in a fluid volume */
	EOS_ACCPMS_Swimming(4),
	/** Player is falling under the effects of gravity, such as when jumping or walking off the edge of a surface */
	EOS_ACCPMS_Falling(5),
	/** Player is flying, ignoring the effects of gravity */
	EOS_ACCPMS_Flying(6),
	/** Player is on a ladder */
	EOS_ACCPMS_OnLadder(7);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonPlayerMovementState> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonPlayerMovementState result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonPlayerMovementState(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCPMS_None);
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