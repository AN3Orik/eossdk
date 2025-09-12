package host.anzo.eossdk.eos.sdk.auth.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.auth.callbackresults.EOS_Auth_LoginStatusChangedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Auth_OnLoginStatusChangedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Auth_AddNotifyLoginStatusChanged
	 * @param data A EOS_Auth_LoginStatusChangedCallbackInfo containing the output information and result
	 */
	void run(EOS_Auth_LoginStatusChangedCallbackInfo data);
}