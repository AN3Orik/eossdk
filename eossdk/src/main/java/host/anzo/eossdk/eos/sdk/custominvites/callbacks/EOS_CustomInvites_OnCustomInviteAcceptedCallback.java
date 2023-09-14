package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_OnCustomInviteAcceptedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_CustomInvites_OnCustomInviteAcceptedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_CustomInvites_AddNotifyCustomInviteAccepted
	 *
	 * @param data A EOS_CustomInvites_OnCustomInviteAcceptedCallbackInfo containing the output information and result
	 */
	void apply(EOS_CustomInvites_OnCustomInviteAcceptedCallbackInfo data);
}