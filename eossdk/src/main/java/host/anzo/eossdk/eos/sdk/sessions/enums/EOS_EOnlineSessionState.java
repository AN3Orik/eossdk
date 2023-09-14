package host.anzo.eossdk.eos.sdk.sessions.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible states of an existing named session
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public @Getter enum EOS_EOnlineSessionState implements NativeMapped {
	/** An online session has not been created yet */
	EOS_OSS_NoSession(0),
	/** An online session is in the process of being created */
	EOS_OSS_Creating(1),
	/** Session has been created but the session hasn't started (pre match lobby) */
	EOS_OSS_Pending(2),
	/** Session has been asked to start (may take time due to communication with backend) */
	EOS_OSS_Starting(3),
	/** The current session has started. Sessions with join in progress disabled are no longer joinable */
	EOS_OSS_InProgress(4),
	/** The session is still valid, but the session is no longer being played (post match lobby) */
	EOS_OSS_Ending(5),
	/** The session is closed and any stats committed */
	EOS_OSS_Ended(6),
	/** The session is being destroyed */
	EOS_OSS_Destroying(7);

	private final int id;

	private static final Map<Integer, EOS_EOnlineSessionState> values = new HashMap<>();

	static {
		for (EOS_EOnlineSessionState result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EOnlineSessionState(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_OSS_NoSession);
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