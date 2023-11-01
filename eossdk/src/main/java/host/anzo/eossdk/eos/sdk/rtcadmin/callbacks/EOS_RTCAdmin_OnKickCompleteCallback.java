package host.anzo.eossdk.eos.sdk.rtcadmin.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_KickCompleteCallbackInfo;

/**
 * @author ANZO
 * @since 11/1/2023
 */
public interface EOS_RTCAdmin_OnKickCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_RTCAdmin_Kick
	 * @param data An EOS_RTCAdmin_KickCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_RTCAdmin_KickCompleteCallbackInfo data);
}
