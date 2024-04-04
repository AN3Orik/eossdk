package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_LogoutCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 3/23/2024
 */
public interface EOS_Connect_OnLogoutCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_Logout
	 * @param data a EOS_Connect_LogoutCallbackInfo containing the result.
	 */
	void apply(EOS_Connect_LogoutCallbackInfo data);
}