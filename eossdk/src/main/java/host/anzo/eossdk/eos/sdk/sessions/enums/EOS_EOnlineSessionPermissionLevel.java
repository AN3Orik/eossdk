package host.anzo.eossdk.eos.sdk.sessions.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Permission level gets more restrictive further down
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public @Getter enum EOS_EOnlineSessionPermissionLevel implements NativeMapped {
	/** Anyone can find this session as long as it isn't full */
	EOS_OSPF_PublicAdvertised(0),
	/** Players who have access to presence can see this session */
	EOS_OSPF_JoinViaPresence(1),
	/** Only players with invites registered can see this session */
	EOS_OSPF_InviteOnly(2);

	private final int id;

	private static final Map<Integer, EOS_EOnlineSessionPermissionLevel> values = new HashMap<>();

	static {
		for (EOS_EOnlineSessionPermissionLevel result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EOnlineSessionPermissionLevel(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_OSPF_PublicAdvertised);
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
