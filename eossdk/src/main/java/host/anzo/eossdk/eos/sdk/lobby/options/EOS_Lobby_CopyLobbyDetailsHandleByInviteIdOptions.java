package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_CopyLobbyDetailsHandleByInviteId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "InviteId"})
public class EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions extends Structure {
	public static final int EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYINVITEID_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYINVITEID_API_LATEST. */
	public int ApiVersion;
	/** The ID of an invitation to join the lobby */
	public String InviteId;

	public EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions() {
		super();
		ApiVersion = EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYINVITEID_API_LATEST;
	}

	public EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions implements Structure.ByValue {
	}
}
