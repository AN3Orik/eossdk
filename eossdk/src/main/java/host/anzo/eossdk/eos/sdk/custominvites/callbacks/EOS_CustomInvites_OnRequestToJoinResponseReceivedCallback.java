package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_RequestToJoinResponseReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_CustomInvites_OnRequestToJoinResponseReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_CustomInvites_AddNotifyRequestToJoinResponseReceived
	 *
	 * @param data A EOS_CustomInvites_RequestToJoinResponseReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_CustomInvites_RequestToJoinResponseReceivedCallbackInfo data);
}