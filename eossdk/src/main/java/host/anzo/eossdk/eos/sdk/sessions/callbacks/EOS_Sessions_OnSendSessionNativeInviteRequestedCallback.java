package host.anzo.eossdk.eos.sdk.sessions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_UI_Interface;
import host.anzo.eossdk.eos.sdk.sessions.callbackresults.EOS_Sessions_SendSessionNativeInviteRequestedCallbackInfo;
import host.anzo.eossdk.eos.sdk.ui.options.EOS_UI_AcknowledgeEventIdOptions;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public interface EOS_Sessions_OnSendSessionNativeInviteRequestedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Sessions_AddNotifySendSessionNativeInviteRequested<br>
	 * <b>After processing the callback EOS_UI_AcknowledgeEventId must be called.</b>
	 * @param data A EOS_Sessions_SendSessionNativeInviteRequestedCallbackInfo containing the output information and result
	 *
	 * @see EOS_UI_Interface#acknowledgeEventId(EOS_UI_AcknowledgeEventIdOptions)
	 */
	void apply(EOS_Sessions_SendSessionNativeInviteRequestedCallbackInfo data);
}