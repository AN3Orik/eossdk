package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_QueryInvitesCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnQueryInvitesCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_QueryInvites
	 * @param data A EOS_Lobby_QueryInvites CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_QueryInvitesCallbackInfo data);
}