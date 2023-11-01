package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_BlockParticipantCallbackInfo;

/**
 * Callback for completion of block participants request.
 *
 * @author ANZO
 * @since 11/1/2023
 */
public interface EOS_RTC_OnBlockParticipantCallback extends Callback {
	void apply(EOS_RTC_BlockParticipantCallbackInfo data);
}
