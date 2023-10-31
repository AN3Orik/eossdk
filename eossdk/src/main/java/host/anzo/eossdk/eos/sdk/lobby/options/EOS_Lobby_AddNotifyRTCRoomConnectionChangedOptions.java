package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_AddNotifyRTCRoomConnectionChanged function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LobbyId_DEPRECATED", "LocalUserId_DEPRECATED"})
public class EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions extends Structure {
	/** The most recent version of the EOS_Lobby_AddNotifyRTCRoomConnectionChanged API. */
	public static final int EOS_LOBBY_ADDNOTIFYRTCROOMCONNECTIONCHANGED_API_LATEST = 2;

	/** API Version: Set this to EOS_LOBBY_ADDNOTIFYRTCROOMCONNECTIONCHANGED_API_LATEST. */
	public int ApiVersion;
	/**
	 * The ID of the lobby to receive RTC Room connection change notifications for
	 * This is deprecated and no longer needed. The notification is raised for any LobbyId or LocalUserId. If any filtering is required, the callback struct (EOS_Lobby_RTCRoomConnectionChangedCallbackInfo) has both a LobbyId and LocalUserId field.
	 */
	public String LobbyId_DEPRECATED;
	/**
	 * The Product User ID of the local user in the lobby
	 * This is deprecated and no longer needed. The notification is raised for any LobbyId or LocalUserId. If any filtering is required, the callback struct (EOS_Lobby_RTCRoomConnectionChangedCallbackInfo) has both a LobbyId and LocalUserId field.
	 */
	public EOS_ProductUserId LocalUserId_DEPRECATED;

	public EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions() {
		super();
		ApiVersion = EOS_LOBBY_ADDNOTIFYRTCROOMCONNECTIONCHANGED_API_LATEST;
	}

	public EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions implements Structure.ByValue {
	}
}