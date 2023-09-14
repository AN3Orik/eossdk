package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_OnLobbyInviteAcceptedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ClientData", "InviteId", "LocalUserId", "TargetUserId", "LobbyId"})
public class EOS_Lobby_LobbyInviteAcceptedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyLobbyInviteAccepted */
	public Pointer ClientData;
	/** The invite ID */
	public String InviteId;
	/** The Product User ID of the local user who received the invitation */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the user who sent the invitation */
	public EOS_ProductUserId TargetUserId;
	/** Lobby ID that the user has been invited to */
	public String LobbyId;

	public EOS_Lobby_LobbyInviteAcceptedCallbackInfo() {
		super();
	}

	public EOS_Lobby_LobbyInviteAcceptedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LobbyInviteAcceptedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LobbyInviteAcceptedCallbackInfo implements Structure.ByValue {
	}
}