package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_CreateLobby function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_CreateLobbyCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the creation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_LimitExceeded} if the number of allowed lobbies is exceeded<br>
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_CreateLobby */
	public Pointer ClientData;
	/** The new lobby's ID */
	public String LobbyId;

	public EOS_Lobby_CreateLobbyCallbackInfo() {
		super();
	}

	public EOS_Lobby_CreateLobbyCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CreateLobbyCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_CreateLobbyCallbackInfo implements Structure.ByValue {
	}
}