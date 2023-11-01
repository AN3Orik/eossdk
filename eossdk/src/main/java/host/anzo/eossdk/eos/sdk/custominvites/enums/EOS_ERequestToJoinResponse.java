package host.anzo.eossdk.eos.sdk.custominvites.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Response to an invite request.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public @Getter enum EOS_ERequestToJoinResponse implements NativeMapped {
	/** The target of the invite request has accepted. */
	EOS_RTJR_ACCEPTED(0),
	/** The target of the invite request has rejected. */
	EOS_RTJR_REJECTED(1);

	private final int id;

	private static final Map<Integer, EOS_ERequestToJoinResponse> values = new HashMap<>();

	static {
		for (EOS_ERequestToJoinResponse result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERequestToJoinResponse(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_RTJR_ACCEPTED);
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