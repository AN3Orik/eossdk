package host.anzo.eossdk.eos.sdk.kws.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.kws.callbackresults.EOS_KWS_PermissionsUpdateReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public interface EOS_KWS_OnPermissionsUpdateReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_KWS_AddNotifyPermissionsUpdateReceived
	 * @param data A EOS_KWS_PermissionsUpdateReceivedCallbackInfo containing the output information and result
	 */
	void apply(EOS_KWS_PermissionsUpdateReceivedCallbackInfo data);
}