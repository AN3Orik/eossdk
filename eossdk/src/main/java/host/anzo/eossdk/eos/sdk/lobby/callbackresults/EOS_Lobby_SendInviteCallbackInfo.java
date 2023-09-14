package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_SendInvite function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_SendInviteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the send invite completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if the lobby to send the invite from does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_SendInvite */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_SendInviteCallbackInfo() {
		super();
	}

	public EOS_Lobby_SendInviteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_SendInviteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_SendInviteCallbackInfo implements Structure.ByValue {
	}
}