package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_CreateDeviceIdCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnCreateDeviceIdCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_CreateDeviceId.
	 * @param data A {@link EOS_Connect_CreateDeviceIdCallbackInfo} containing the output information and result.
	 */
	void run(EOS_Connect_CreateDeviceIdCallbackInfo data);
}