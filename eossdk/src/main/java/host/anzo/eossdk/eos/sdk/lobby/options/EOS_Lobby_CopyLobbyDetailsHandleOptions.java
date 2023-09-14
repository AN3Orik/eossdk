package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_CopyLobbyDetailsHandle function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId"})
public class EOS_Lobby_CopyLobbyDetailsHandleOptions extends Structure {
	public static final int EOS_LOBBY_COPYLOBBYDETAILSHANDLE_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_COPYLOBBYDETAILSHANDLE_API_LATEST. */
	public int ApiVersion;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the local user making the request */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_CopyLobbyDetailsHandleOptions() {
		super();
		ApiVersion = EOS_LOBBY_COPYLOBBYDETAILSHANDLE_API_LATEST;
	}

	public EOS_Lobby_CopyLobbyDetailsHandleOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CopyLobbyDetailsHandleOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_CopyLobbyDetailsHandleOptions implements Structure.ByValue {
	}
}