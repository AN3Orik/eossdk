package host.anzo.eossdk.eos.sdk.lobby.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the type of action to take against RTC room when joining a lobby
 * @author Anton Lasevich
 * @since 2/26/2025
 */
public enum EOS_ELobbyRTCRoomJoinActionType implements NativeMapped {
	/** Join RTC Room as soon as user joins the lobby */
	EOS_LRRJAT_AutomaticJoin(0),
	/** Do not join RTC Room when joining the lobby. User must manually call Join RTC Room */
	EOS_LRRJAT_ManualJoin(1);

	private final int id;

	private static final Map<Integer, EOS_ELobbyRTCRoomJoinActionType> values = new HashMap<>();

	static {
		for (EOS_ELobbyRTCRoomJoinActionType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELobbyRTCRoomJoinActionType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_LRRJAT_AutomaticJoin);
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