package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_JoinLobbyCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/17/2023
 */
public interface EOS_Lobby_OnJoinLobbyCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_JoinLobby
	 * @param data A EOS_Lobby_JoinLobby CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_JoinLobbyCallbackInfo data);
}