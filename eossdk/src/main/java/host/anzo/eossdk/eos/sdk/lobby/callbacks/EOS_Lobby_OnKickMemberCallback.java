package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_KickMemberCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/18/2023
 */
public interface EOS_Lobby_OnKickMemberCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Lobby_KickMember
	 * @param data A EOS_Lobby_KickMember CallbackInfo containing the output information and result
	 */
	void apply(EOS_Lobby_KickMemberCallbackInfo data);
}