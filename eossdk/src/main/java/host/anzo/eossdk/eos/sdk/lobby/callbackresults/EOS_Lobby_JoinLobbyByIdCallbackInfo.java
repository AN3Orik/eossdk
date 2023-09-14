package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_JoinLobbyById function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_JoinLobbyByIdCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br/>
	 * {@link EOS_EResult#EOS_Success} if join successfully<br/>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_JoinLobbyById */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_JoinLobbyByIdCallbackInfo() {
		super();
	}

	public EOS_Lobby_JoinLobbyByIdCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_JoinLobbyByIdCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_JoinLobbyByIdCallbackInfo implements Structure.ByValue {
	}
}