package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_ParticipantStatusChangedCallbackInfo;

/**
 * Callback called when room participant status changed
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public interface EOS_RTC_OnParticipantStatusChangedCallback extends Callback {
	void apply(EOS_RTC_ParticipantStatusChangedCallbackInfo data);
}
