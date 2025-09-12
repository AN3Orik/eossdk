package host.anzo.eossdk.eos.sdk.auth.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.auth.callbackresults.EOS_Auth_QueryIdTokenCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Auth_OnQueryIdTokenCallback extends Callback {
	void run(EOS_Auth_QueryIdTokenCallbackInfo data);
}