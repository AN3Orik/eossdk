package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_LeaveLobby function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "LobbyId"})
public class EOS_Lobby_LeaveLobbyOptions extends Structure {
	/** The most recent version of the EOS_Lobby_LeaveLobby API. */
	private static final int EOS_LOBBY_LEAVELOBBY_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_LEAVELOBBY_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user leaving the lobby */
	public EOS_ProductUserId LocalUserId;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_LeaveLobbyOptions() {
		super();
		ApiVersion = EOS_LOBBY_LEAVELOBBY_API_LATEST;
	}

	public EOS_Lobby_LeaveLobbyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LeaveLobbyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LeaveLobbyOptions implements Structure.ByValue {
	}
}