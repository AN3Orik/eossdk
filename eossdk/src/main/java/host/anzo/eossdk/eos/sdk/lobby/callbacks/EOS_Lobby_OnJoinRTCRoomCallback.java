package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_JoinRTCRoomCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 2/26/2025
 */
public interface EOS_Lobby_OnJoinRTCRoomCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_JoinRTCRoom
	 * @param data A EOS_Lobby_JoinRTCRoom CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_JoinRTCRoomCallbackInfo data);
}