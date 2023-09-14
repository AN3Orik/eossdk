package host.anzo.eossdk.eos.sdk.friends.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.friends.callbackresults.EOS_Friends_AcceptInviteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Friends_OnAcceptInviteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Friends_AcceptInvite
	 * @param data A EOS_Friends_AcceptInviteCallbackInfo containing the output information and result.
	 */
	void apply(EOS_Friends_AcceptInviteCallbackInfo data);
}