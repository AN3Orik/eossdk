package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.EOS_LobbyModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_UpdateLobby function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LobbyModificationHandle"})
public class EOS_Lobby_UpdateLobbyOptions extends Structure {
	/** The most recent version of the EOS_Lobby_UpdateLobby API. */
	public static final int EOS_LOBBY_UPDATELOBBY_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_UPDATELOBBY_API_LATEST}. */
	public int ApiVersion;
	/** Builder handle */
	public EOS_LobbyModification LobbyModificationHandle;

	public EOS_Lobby_UpdateLobbyOptions() {
		super();
		ApiVersion = EOS_LOBBY_UPDATELOBBY_API_LATEST;
	}

	public EOS_Lobby_UpdateLobbyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_UpdateLobbyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_UpdateLobbyOptions implements Structure.ByValue {
	}
}