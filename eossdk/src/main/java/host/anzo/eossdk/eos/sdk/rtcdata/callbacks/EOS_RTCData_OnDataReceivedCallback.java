package host.anzo.eossdk.eos.sdk.rtcdata.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcdata.callbackresults.EOS_RTCData_DataReceivedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 4/4/2024
 */
public interface EOS_RTCData_OnDataReceivedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from {@link EOSLibrary#EOS_RTCData_AddNotifyDataReceived}
	 *
	 * @param data A {@link EOS_RTCData_DataReceivedCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCData_DataReceivedCallbackInfo data);
}