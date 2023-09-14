package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_CreateLobbyCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/17/2023
 */
public interface EOS_Lobby_OnCreateLobbyCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_CreateLobby
	 * @param data A EOS_Lobby_CreateLobby CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_CreateLobbyCallbackInfo data);
}