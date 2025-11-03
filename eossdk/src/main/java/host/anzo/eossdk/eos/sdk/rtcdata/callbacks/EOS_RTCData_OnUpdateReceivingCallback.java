package host.anzo.eossdk.eos.sdk.rtcdata.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcdata.callbackresults.EOS_RTCData_UpdateReceivingCallbackInfo;

/**
 * Callback for completion of update receiving request
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
public interface EOS_RTCData_OnUpdateReceivingCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link host.anzo.eossdk.eos.sdk.EOSLibrary#EOS_RTCData_UpdateReceiving}
	 * @param data An {@link EOS_RTCData_UpdateReceivingCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCData_UpdateReceivingCallbackInfo data);
}