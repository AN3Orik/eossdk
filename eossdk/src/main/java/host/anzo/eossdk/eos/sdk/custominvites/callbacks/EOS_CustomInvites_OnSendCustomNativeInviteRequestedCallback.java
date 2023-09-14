package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_UI_Interface;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo;
import host.anzo.eossdk.eos.sdk.ui.options.EOS_UI_AcknowledgeEventIdOptions;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_CustomInvites_OnSendCustomNativeInviteRequestedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested<br>
	 * <b>After processing the callback EOS_UI_AcknowledgeEventId must be called.</b>
	 * @param data A EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo containing the output information and result
	 *
	 * @see EOS_UI_Interface#acknowledgeEventId(EOS_UI_AcknowledgeEventIdOptions)
	 */
	void apply(EOS_CustomInvites_SendCustomNativeInviteRequestedCallbackInfo data);
}