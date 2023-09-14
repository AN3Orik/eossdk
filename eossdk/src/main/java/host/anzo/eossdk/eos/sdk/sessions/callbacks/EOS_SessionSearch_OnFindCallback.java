package host.anzo.eossdk.eos.sdk.sessions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.sessions.callbackresults.EOS_SessionSearch_FindCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/6/2023
 */
public interface EOS_SessionSearch_OnFindCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_SessionSearch_Find
	 * @param data A EOS_SessionSearch_FindCallbackInfo containing the output information and result
	 */
	void apply(EOS_SessionSearch_FindCallbackInfo data);
}