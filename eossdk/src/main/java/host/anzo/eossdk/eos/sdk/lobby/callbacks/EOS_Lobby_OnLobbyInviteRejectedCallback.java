package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LobbyInviteRejectedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnLobbyInviteRejectedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyLobbyInviteRejected
	 *
	 * @param data A EOS_Lobby_LobbyInviteRejectedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LobbyInviteRejectedCallbackInfo data);
}