package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_AddNotifyLobbyMemberStatusReceived function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ClientData", "LobbyId", "TargetUserId", "CurrentStatus"})
public class EOS_Lobby_LobbyMemberStatusReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyLobbyMemberStatusReceived */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the lobby member */
	public EOS_ProductUserId TargetUserId;
	/** Latest status of the user */
	public int CurrentStatus;

	public EOS_Lobby_LobbyMemberStatusReceivedCallbackInfo() {
		super();
	}

	public EOS_Lobby_LobbyMemberStatusReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LobbyMemberStatusReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LobbyMemberStatusReceivedCallbackInfo implements Structure.ByValue {
	}
}