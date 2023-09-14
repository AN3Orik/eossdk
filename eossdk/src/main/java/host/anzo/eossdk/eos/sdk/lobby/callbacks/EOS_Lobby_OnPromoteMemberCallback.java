package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_PromoteMemberCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/18/2023
 */
public interface EOS_Lobby_OnPromoteMemberCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_PromoteMember
	 * @param data A EOS_Lobby_PromoteMember CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_PromoteMemberCallbackInfo data);
}