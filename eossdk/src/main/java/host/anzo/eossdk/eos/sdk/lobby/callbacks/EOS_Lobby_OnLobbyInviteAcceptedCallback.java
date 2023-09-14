package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LobbyInviteAcceptedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnLobbyInviteAcceptedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyLobbyInviteAccepted
	 *
	 * @param data A EOS_Lobby_LobbyInviteAcceptedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LobbyInviteAcceptedCallbackInfo data);
}