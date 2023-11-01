package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_JoinRoomCallbackInfo;

/**
 * Callback for completion of room join request.
 *
 * @author ANZO
 * @since 11/1/2023
 */
public interface EOS_RTC_OnJoinRoomCallback extends Callback {
	void apply(EOS_RTC_JoinRoomCallbackInfo data);
}
