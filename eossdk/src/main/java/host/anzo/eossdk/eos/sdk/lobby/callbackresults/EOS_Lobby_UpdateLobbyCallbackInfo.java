package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_UpdateLobby function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_UpdateLobbyCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the update completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Lobby_NotOwner} if the lobby modification contains modifications that are only allowed by the owner<br>
	 * {@link EOS_EResult#EOS_NotFound} if the lobby to update does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_UpdateLobby */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_UpdateLobbyCallbackInfo() {
		super();
	}

	public EOS_Lobby_UpdateLobbyCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_UpdateLobbyCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_UpdateLobbyCallbackInfo implements Structure.ByValue {
	}
}