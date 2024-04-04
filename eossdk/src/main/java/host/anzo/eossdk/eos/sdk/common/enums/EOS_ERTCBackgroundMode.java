package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All background modes supported by the RTC components
 *
 * @author Anton Lasevich
 * @since 10/31/2023
 */
public @Getter enum EOS_ERTCBackgroundMode implements NativeMapped {
	/**
	 * Upon entering a background application status, all logged in users leave any RTC rooms. All subsequent attempts to join any RTC rooms will be rejected.
	 * Upon returning to a foreground application status, all subsequent attempts to join any RTC rooms will be allowed.
	 */
	EOS_RTCBM_LeaveRooms(0),
	/**
	 * Application status has no effect on RTC rooms. Audio is captured from input devices and is played to output devices.
	 * Games should obtain consent from users and otherwise make users aware this is occurring.
	 */
	EOS_RTCBM_KeepRoomsAlive(1);

	private final int id;

	private static final Map<Integer, EOS_ERTCBackgroundMode> values = new HashMap<>();

	static {
		for (EOS_ERTCBackgroundMode result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCBackgroundMode(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTCBM_LeaveRooms);
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
