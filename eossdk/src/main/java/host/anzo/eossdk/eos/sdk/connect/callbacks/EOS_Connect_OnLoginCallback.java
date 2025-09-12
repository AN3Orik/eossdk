package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_LoginCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnLoginCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_Login.
	 * @param data A EOS_Connect_LoginCallbackInfo containing the output information and result.
	 */
	void run(EOS_Connect_LoginCallbackInfo data) throws EOSException;
}