package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_SendCustomInviteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_CustomInvites_OnSendCustomInviteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_CustomInvites_SendCustomInvite
	 * @param data A EOS_CustomInvites_SendCustomInviteCallbackInfo containing the output information and result
	 */
	void apply(EOS_CustomInvites_SendCustomInviteCallbackInfo data);
}