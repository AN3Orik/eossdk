package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_GetRTCRoomName function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId"})
public class EOS_Lobby_GetRTCRoomNameOptions extends Structure {
	public static final int EOS_LOBBY_GETRTCROOMNAME_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_GETRTCROOMNAME_API_LATEST. */
	public int ApiVersion;
	/** The ID of the lobby to get the RTC Room name for */
	public String LobbyId;
	/** The Product User ID of the local user in the lobby */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_GetRTCRoomNameOptions() {
		super();
		ApiVersion = EOS_LOBBY_GETRTCROOMNAME_API_LATEST;
	}

	public EOS_Lobby_GetRTCRoomNameOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_GetRTCRoomNameOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_GetRTCRoomNameOptions implements Structure.ByValue {
	}
}