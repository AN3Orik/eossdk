package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_OnCustomInviteReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_CustomInvites_OnCustomInviteReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_CustomInvites_AddNotifyCustomInviteReceived
	 *
	 * @param data A EOS_CustomInvites_OnCustomInviteReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_CustomInvites_OnCustomInviteReceivedCallbackInfo data);
}