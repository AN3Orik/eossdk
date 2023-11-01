package host.anzo.eossdk.eos.sdk.ui.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOS_UI_Interface;
import host.anzo.eossdk.eos.sdk.ui.options.EOS_UI_SetDisplayPreferenceOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Notification locations to be used to set the preference
 * for pop-up.
 *
 * @see EOS_UI_Interface#setDisplayPreference(EOS_UI_SetDisplayPreferenceOptions)
 *
 * @author Anton Lasevich
 * @since 9/8/2023
 */
public @Getter enum EOS_UI_ENotificationLocation implements NativeMapped {
	EOS_UNL_TopLeft(0),
	EOS_UNL_TopRight(1),
	EOS_UNL_BottomLeft(2),
	EOS_UNL_BottomRight(3);

	private final int id;

	private static final Map<Integer, EOS_UI_ENotificationLocation> values = new HashMap<>();

	static {
		for (EOS_UI_ENotificationLocation result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_UI_ENotificationLocation(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_UNL_TopLeft);
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