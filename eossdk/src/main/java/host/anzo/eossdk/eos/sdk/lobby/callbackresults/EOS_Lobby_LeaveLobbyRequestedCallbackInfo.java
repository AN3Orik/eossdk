package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * Output parameters for the EOS_Lobby_OnLeaveLobbyRequestedCallback Function.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ClientData", "LocalUserId", "LobbyId"})
public class EOS_Lobby_LeaveLobbyRequestedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_OnLeaveLobbyRequestedCallback */
	public Pointer ClientData;
	/** The Product User ID of the local user who received the leave lobby notification. */
	public EOS_ProductUserId LocalUserId;
	/** Lobby ID associated with the leave lobby request. */
	public String LobbyId;

	public EOS_Lobby_LeaveLobbyRequestedCallbackInfo() {
		super();
	}

	public EOS_Lobby_LeaveLobbyRequestedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LeaveLobbyRequestedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LeaveLobbyRequestedCallbackInfo implements Structure.ByValue {
	}
}