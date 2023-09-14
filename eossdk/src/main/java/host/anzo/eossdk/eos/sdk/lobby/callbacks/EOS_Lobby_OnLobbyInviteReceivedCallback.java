package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LobbyInviteReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnLobbyInviteReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyLobbyInviteReceived
	 *
	 * @param data A EOS_Lobby_LobbyInviteReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LobbyInviteReceivedCallbackInfo data);
}