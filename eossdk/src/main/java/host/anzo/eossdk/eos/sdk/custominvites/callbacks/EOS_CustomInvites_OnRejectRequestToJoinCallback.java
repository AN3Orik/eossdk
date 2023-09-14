package host.anzo.eossdk.eos.sdk.custominvites.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.custominvites.callbackresults.EOS_CustomInvites_RejectRequestToJoinCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_CustomInvites_OnRejectRequestToJoinCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_CustomInvites_RejectRequestToJoin
	 * @param data A EOS_CustomInvites_OnRejectRequestToJoinCallback containing the output information and result
	 */
	void apply(EOS_CustomInvites_RejectRequestToJoinCallbackInfo data);
}