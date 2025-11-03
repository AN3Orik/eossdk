package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_Lobby_AddNotifyLobbyInviteRejected} function.
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Lobby_AddNotifyLobbyInviteRejectedOptions extends Structure {
	/** The most recent version of the EOS_Lobby_AddNotifyLobbyInviteRejected API. */
	public static final int EOS_LOBBY_ADDNOTIFYLOBBYINVITEREJECTED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_ADDNOTIFYLOBBYINVITEREJECTED_API_LATEST}. */
	public int ApiVersion;

	public EOS_Lobby_AddNotifyLobbyInviteRejectedOptions() {
		super();
		ApiVersion = EOS_LOBBY_ADDNOTIFYLOBBYINVITEREJECTED_API_LATEST;
	}

	public EOS_Lobby_AddNotifyLobbyInviteRejectedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_AddNotifyLobbyInviteRejectedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_AddNotifyLobbyInviteRejectedOptions implements Structure.ByValue {
	}
}