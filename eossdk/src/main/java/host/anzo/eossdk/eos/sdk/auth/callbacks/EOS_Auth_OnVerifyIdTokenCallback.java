package host.anzo.eossdk.eos.sdk.auth.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.auth.callbackresults.EOS_Auth_VerifyIdTokenCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Auth_OnVerifyIdTokenCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed into EOS_Auth_VerifyIdToken.
	 * @param data A EOS_Auth_VerifyIdTokenCallbackInfo containing the output information and result.
	 */
	void run(EOS_Auth_VerifyIdTokenCallbackInfo data);
}