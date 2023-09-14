package host.anzo.eossdk.eos.sdk.friends.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.friends.callbackresults.EOS_Friends_RejectInviteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Friends_OnRejectInviteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Friends_RejectInvite
	 * @param data A EOS_Friends_RejectInviteCallbackInfo containing output information and the result.
	 */
	void apply(EOS_Friends_RejectInviteCallbackInfo data);
}