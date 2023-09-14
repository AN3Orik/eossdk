package host.anzo.eossdk.eos.sdk.sessions.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Sessions_Interface;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;
import host.anzo.eossdk.eos.sdk.sessions.callbackresults.EOS_Sessions_SessionInviteRejectedCallbackInfo;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_CopySessionHandleByInviteIdOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_JoinSessionOptions;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public interface EOS_Sessions_OnSessionInviteRejectedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Sessions_AddNotifySessionInviteRejected
	 *
	 * @param data A EOS_Sessions_SessionInviteRejectedCallbackInfo containing the output information and result
	 *
	 * @see EOS_Sessions_Interface#copySessionHandleByInviteId(EOS_Sessions_CopySessionHandleByInviteIdOptions, EOS_SessionDetails)
	 * @see EOS_Sessions_Interface#joinSession(EOS_Sessions_JoinSessionOptions, Pointer, EOS_Sessions_OnJoinSessionCallback)
	 */
	void apply(EOS_Sessions_SessionInviteRejectedCallbackInfo data);
}