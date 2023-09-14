package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_DestroyLobby function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_DestroyLobbyCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the destroy completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_AlreadyPending} if the lobby is already marked for destroy<br>
	 * {@link EOS_EResult#EOS_NotFound} if the lobby to be destroyed does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_DestroyLobby */
	public Pointer ClientData;
	/** The destroyed lobby's ID */
	public String LobbyId;

	public EOS_Lobby_DestroyLobbyCallbackInfo() {
		super();
	}

	public EOS_Lobby_DestroyLobbyCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_DestroyLobbyCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_DestroyLobbyCallbackInfo implements Structure.ByValue {
	}
}