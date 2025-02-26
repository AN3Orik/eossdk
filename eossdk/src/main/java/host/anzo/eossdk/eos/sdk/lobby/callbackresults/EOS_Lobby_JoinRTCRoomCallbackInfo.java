package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Output parameters for the EOS_Lobby_JoinRTCRoom function.
 * @author ANZO
 * @since 2/26/2025
 */
public class EOS_Lobby_JoinRTCRoomCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if creation completes successfully<br>
	 * {@link EOS_EResult#EOS_NotFound} if the lobby does not exist<br>
	 * {@link EOS_EResult#EOS_Disabled} if the lobby exists, but did not have the RTC Room feature enabled when created<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer on invalid length for any of the parameters<br>
	 * {@link EOS_EResult#EOS_NoChange} if call does not affect the state of the RTC Room<br>
	 * {@link EOS_EResult#EOS_InvalidState} if call to join is made when RTC Room state is not disconnected/disconnecting
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_JoinRTCRoom */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_JoinRTCRoomCallbackInfo() {
		super();
	}

	public EOS_Lobby_JoinRTCRoomCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_JoinRTCRoomCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_JoinRTCRoomCallbackInfo implements Structure.ByValue {
	}
}