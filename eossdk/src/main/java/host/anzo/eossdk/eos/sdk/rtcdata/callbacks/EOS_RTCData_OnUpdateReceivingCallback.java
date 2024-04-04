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
	void apply(EOS_RTCData_UpdateReceivingCallbackInfo data);
}