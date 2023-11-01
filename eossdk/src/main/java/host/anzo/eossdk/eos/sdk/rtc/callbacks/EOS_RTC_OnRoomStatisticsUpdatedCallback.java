package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_RoomStatisticsUpdatedInfo;

/**
 * Callback for room statistic update event
 * @author ANZO
 * @since 11/1/2023
 */
public interface EOS_RTC_OnRoomStatisticsUpdatedCallback extends Callback {
	void apply(EOS_RTC_RoomStatisticsUpdatedInfo data);
}