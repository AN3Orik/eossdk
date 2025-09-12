package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_AuthExpirationCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnAuthExpirationCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Connect_AddNotifyAuthExpiration.
	 *
	 * @param data A EOS_Connect_AuthExpirationCallbackInfo containing the output information and result.
	 */
	void run(EOS_Connect_AuthExpirationCallbackInfo data);
}