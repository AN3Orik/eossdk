package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/18/2023
 */
public interface EOS_Lobby_OnLobbyMemberUpdateReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyLobbyMemberUpdateReceived
	 *
	 * @param data A EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_LobbyMemberUpdateReceivedCallbackInfo data);
}