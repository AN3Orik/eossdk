package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_JoinLobbyByIdCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/17/2023
 */
public interface EOS_Lobby_OnJoinLobbyByIdCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_JoinLobbyById
	 * @param Data A EOS_Lobby_JoinLobbyById CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_JoinLobbyByIdCallbackInfo Data);
}