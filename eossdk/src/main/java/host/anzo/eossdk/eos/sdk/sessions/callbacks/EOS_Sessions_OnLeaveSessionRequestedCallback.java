package host.anzo.eossdk.eos.sdk.sessions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.sessions.callbackresults.EOS_Sessions_LeaveSessionRequestedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public interface EOS_Sessions_OnLeaveSessionRequestedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Sessions_AddNotifyLeaveSessionRequested.
	 *
	 * @param data A pointer to EOS_Sessions_LeaveSessionRequestedCallbackInfo containing the output information.
	 */
	void apply(EOS_Sessions_LeaveSessionRequestedCallbackInfo data);
}