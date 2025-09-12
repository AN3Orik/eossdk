package host.anzo.eossdk.eos.sdk.auth.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.auth.callbackresults.EOS_Auth_VerifyUserAuthCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Auth_OnVerifyUserAuthCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Auth_VerifyUserAuth
	 * @param data A EOS_Auth_VerifyUserAuthCallbackInfo containing the output information and result
	 */
	void run(EOS_Auth_VerifyUserAuthCallbackInfo data);
}