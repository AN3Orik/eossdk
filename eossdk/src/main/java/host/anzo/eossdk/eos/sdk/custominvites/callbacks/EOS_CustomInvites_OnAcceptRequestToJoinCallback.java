package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_AcceptRequestToJoinCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_CustomInvites_OnAcceptRequestToJoinCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_CustomInvites_AcceptRequestToJoin
	 * @param data A EOS_CustomInvites_AcceptRequestToJoinCallbackInfo containing the output information and result
	 */
	void apply(EOS_CustomInvites_AcceptRequestToJoinCallbackInfo data);
}