package host.anzo.eossdk.eos.sdk.rtc.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Participant RTC's status change
 *
 * @author ANZO
 * @since 11/1/2023
 */
public @Getter enum EOS_ERTCParticipantStatus implements NativeMapped {
	/** Participant joined the room */
	EOS_RTCPS_Joined(0),
	/** Participant left the room */
	EOS_RTCPS_Left(1);

	private final int id;

	private static final Map<Integer, EOS_ERTCParticipantStatus> values = new HashMap<>();

	static {
		for (EOS_ERTCParticipantStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERTCParticipantStatus(int id) {
		this.id = id;
	}

	public EOS_ERTCParticipantStatus valueOf(int id) {
		return values.getOrDefault(id, EOS_RTCPS_Joined);
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return valueOf((int) nativeValue);
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