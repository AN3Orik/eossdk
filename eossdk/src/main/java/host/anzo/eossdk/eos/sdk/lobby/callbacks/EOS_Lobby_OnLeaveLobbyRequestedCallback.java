package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_Lobby_Interface;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LeaveLobbyRequestedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 11/03/2025
 */
public interface EOS_Lobby_OnLeaveLobbyRequestedCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOS_Lobby_Interface#leaveLobby}
	 * @param data A EOS_Lobby_LeaveLobby CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LeaveLobbyRequestedCallbackInfo data);
}