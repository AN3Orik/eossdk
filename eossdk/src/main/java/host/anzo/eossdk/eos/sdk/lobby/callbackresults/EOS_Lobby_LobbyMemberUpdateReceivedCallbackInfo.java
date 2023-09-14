package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_OnLobbyMemberUpdateReceivedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ClientData", "LobbyId", "TargetUserId"})
public class EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyLobbyMemberUpdateReceived */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the lobby member */
	public EOS_ProductUserId TargetUserId;

	public EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo() {
		super();
	}

	public EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo implements Structure.ByValue {
	}
}