package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Flags describing the input device used by a remote client, if known. These can be updated during a play session.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientInput implements NativeMapped {
	/** Unknown input device */
	EOS_ACCCI_Unknown(0),
	/** The client is using mouse and keyboard */
	EOS_ACCCI_MouseKeyboard(1),
	/** The client is using a gamepad or game controller */
	EOS_ACCCI_Gamepad(2),
	/** The client is using a touch input device (e.g. phone/tablet screen) */
	EOS_ACCCI_TouchInput(3);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientInput> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientInput result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientInput(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCI_Unknown);
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