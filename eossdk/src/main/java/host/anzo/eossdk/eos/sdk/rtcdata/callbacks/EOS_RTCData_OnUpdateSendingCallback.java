package host.anzo.eossdk.eos.sdk.rtcdata.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcdata.callbackresults.EOS_RTCData_UpdateSendingCallbackInfo;

/**
 * Callback for completion of update sending request.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
public interface EOS_RTCData_OnUpdateSendingCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link host.anzo.eossdk.eos.sdk.EOSLibrary#EOS_RTCData_UpdateSending}
	 * @param data An {@link EOS_RTCData_UpdateSendingCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCData_UpdateSendingCallbackInfo data);
}