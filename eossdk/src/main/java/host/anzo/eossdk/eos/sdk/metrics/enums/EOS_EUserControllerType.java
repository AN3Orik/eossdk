package host.anzo.eossdk.eos.sdk.metrics.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * User game controller types.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_EUserControllerType implements NativeMapped {
	/** The game controller type is unknown. */
	EOS_UCT_Unknown(0),
	/** Mouse and keyboard controller. */
	EOS_UCT_MouseKeyboard(1),
	/** Gamepad controller. */
	EOS_UCT_GamepadControl(2),
	/** Touch controller. */
	EOS_UCT_TouchControl(3);

	private final int id;

	private static final Map<Integer, EOS_EUserControllerType> values = new HashMap<>();

	static {
		for (EOS_EUserControllerType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EUserControllerType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_UCT_Unknown);
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