package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LeaveRTCRoomCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 2/26/2025
 */
public interface EOS_Lobby_OnLeaveRTCRoomCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_LeaveRTCRoom
	 * @param data A EOS_Lobby_LeaveRTCRoom CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LeaveRTCRoomCallbackInfo data);
}