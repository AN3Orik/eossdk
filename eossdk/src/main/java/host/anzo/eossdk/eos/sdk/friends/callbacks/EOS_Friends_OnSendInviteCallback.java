package host.anzo.eossdk.eos.sdk.friends.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.friends.callbackresults.EOS_Friends_SendInviteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Friends_OnSendInviteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Friends_SendInvite
	 * @param data A EOS_Friends_SendInviteCallbackInfo containing the output information and result.
	 */
	void apply(EOS_Friends_SendInviteCallbackInfo data);
}