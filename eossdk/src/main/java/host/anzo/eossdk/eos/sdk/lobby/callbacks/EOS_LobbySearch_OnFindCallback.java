package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_LobbySearch_FindCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public interface EOS_LobbySearch_OnFindCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_LobbySearch_Find
	 * @param data A EOS_LobbySearch_Find CallbackInfo containing the output information and result
	 */
	void apply(EOS_LobbySearch_FindCallbackInfo data);
}