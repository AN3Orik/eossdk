package host.anzo.eossdk.eos.sdk.sessions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.sessions.callbackresults.EOS_Sessions_SessionInviteReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public interface EOS_Sessions_OnSessionInviteReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Sessions_AddNotifySessionInviteReceived
	 *
	 * @param data A EOS_Sessions_SessionInviteReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Sessions_SessionInviteReceivedCallbackInfo data);
}