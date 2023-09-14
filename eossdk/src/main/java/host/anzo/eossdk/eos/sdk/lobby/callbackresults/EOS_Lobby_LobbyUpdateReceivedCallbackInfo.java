package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_OnLobbyUpdateReceivedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ClientData", "LobbyId"})
public class EOS_Lobby_LobbyUpdateReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyLobbyUpdateReceived */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_LobbyUpdateReceivedCallbackInfo() {
		super();
	}

	public EOS_Lobby_LobbyUpdateReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LobbyUpdateReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LobbyUpdateReceivedCallbackInfo implements Structure.ByValue {
	}
}
