package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Output parameters for the EOS_Lobby_LeaveRTCRoom function.
 * @author Anton Lasevich
 * @since 2/26/2025
 */
public class EOS_Lobby_LeaveRTCRoomCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if leave completes successfully
	 * {@link EOS_EResult#EOS_NotFound} if the lobby does not exist
	 * {@link EOS_EResult#EOS_Disabled} if the lobby exists, but did not have the RTC Room feature enabled when leaves
	 * {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer on invalid length for any of the parameters
	 * {@link EOS_EResult#EOS_NoChange} if call does not affect the state of the RTC Room
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_LeaveRTCRoom */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;

	public EOS_Lobby_LeaveRTCRoomCallbackInfo() {
		super();
	}

	public EOS_Lobby_LeaveRTCRoomCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_LeaveRTCRoomCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_LeaveRTCRoomCallbackInfo implements Structure.ByValue {
	}
}