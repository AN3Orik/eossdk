package host.anzo.eossdk.eos.sdk.rtc.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtc.callbackresults.EOS_RTC_RoomStatisticsUpdatedInfo;

/**
 * Callback for room statistic update event
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public interface EOS_RTC_OnRoomStatisticsUpdatedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from {@link EOSLibrary#EOS_RTC_AddNotifyRoomStatisticsUpdated}
	 *
	 * @param data A {@link EOS_RTC_RoomStatisticsUpdatedInfo} containing the output information and result
	 */
	void apply(EOS_RTC_RoomStatisticsUpdatedInfo data);
}