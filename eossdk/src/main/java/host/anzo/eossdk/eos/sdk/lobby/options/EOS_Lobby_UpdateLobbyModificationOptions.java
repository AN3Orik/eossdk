package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_UpdateLobbyModification function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "LobbyId"})
public class EOS_Lobby_UpdateLobbyModificationOptions extends Structure {
	public static final int EOS_LOBBY_UPDATELOBBYMODIFICATION_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_UPDATELOBBYMODIFICATION_API_LATEST. */
	public int ApiVersion;
	/** The ID of the local user making modifications. Must be the owner to modify lobby data, but any lobby member can modify their own attributes. */
	public EOS_ProductUserId LocalUserId;
	/** The ID of the lobby */
	public Pointer LobbyId;

	public EOS_Lobby_UpdateLobbyModificationOptions() {
		super();
		ApiVersion = EOS_LOBBY_UPDATELOBBYMODIFICATION_API_LATEST;
	}

	public EOS_Lobby_UpdateLobbyModificationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_UpdateLobbyModificationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_UpdateLobbyModificationOptions implements Structure.ByValue {
	}
}