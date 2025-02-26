package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.*;

/**
 * Input parameters for the EOS_Lobby_LeaveRTCRoom function.
 * @author Anton Lasevich
 * @since 2/26/2025
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId"})
public class EOS_Lobby_LeaveRTCRoomOptions extends Structure {
	/** The most recent version of the EOS_Lobby_LeaveRTCRoom API. */
	private static final int EOS_LOBBY_LEAVERTCROOM_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_LEAVERTCROOM_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the lobby owning the RTC Room to leave */
	public String LobbyId;
	/** The Product User ID of the local user in the lobby */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_LeaveRTCRoomOptions() {
		super();
		ApiVersion = EOS_LOBBY_LEAVERTCROOM_API_LATEST;
	}

	public EOS_Lobby_LeaveRTCRoomOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LeaveRTCRoomOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LeaveRTCRoomOptions implements Structure.ByValue {
	}
}