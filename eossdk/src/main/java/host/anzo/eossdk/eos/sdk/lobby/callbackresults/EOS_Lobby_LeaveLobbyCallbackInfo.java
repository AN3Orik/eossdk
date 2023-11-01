package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_LeaveLobby function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_LeaveLobbyCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} if the leave completes successfully
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 * {@link EOS_EResult#EOS_AlreadyPending} if the lobby is already marked for leave
	 * {@link EOS_EResult#EOS_NotFound} if a lobby to be left does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_LeaveLobby */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_LeaveLobbyCallbackInfo() {
		super();
	}

	public EOS_Lobby_LeaveLobbyCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LeaveLobbyCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LeaveLobbyCallbackInfo implements Structure.ByValue {
	}
}