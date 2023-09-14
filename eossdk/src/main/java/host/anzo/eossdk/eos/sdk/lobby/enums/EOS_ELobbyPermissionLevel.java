package host.anzo.eossdk.eos.sdk.lobby.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Permission level gets more restrictive further down
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public @Getter enum EOS_ELobbyPermissionLevel implements NativeMapped {
	/** Anyone can find this lobby as long as it isn't full */
	EOS_LPL_PUBLICADVERTISED(0),
	/** Players who have access to presence can see this lobby */
	EOS_LPL_JOINVIAPRESENCE(1),
	/** Only players with invites registered can see this lobby */
	EOS_LPL_INVITEONLY(2);

	private final int id;

	private static final Map<Integer, EOS_ELobbyPermissionLevel> values = new HashMap<>();

	static {
		for (EOS_ELobbyPermissionLevel result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELobbyPermissionLevel(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_LPL_PUBLICADVERTISED);
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