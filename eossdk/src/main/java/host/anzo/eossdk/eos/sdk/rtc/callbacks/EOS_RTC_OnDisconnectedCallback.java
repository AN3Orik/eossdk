package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_DisconnectedCallbackInfo;

/**
 * Callback for completion of room disconnect request.
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public interface EOS_RTC_OnDisconnectedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from {@link EOSLibrary#EOS_RTC_AddNotifyDisconnected}
	 *
	 * @param data A {@link EOS_RTC_DisconnectedCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTC_DisconnectedCallbackInfo data);
}
