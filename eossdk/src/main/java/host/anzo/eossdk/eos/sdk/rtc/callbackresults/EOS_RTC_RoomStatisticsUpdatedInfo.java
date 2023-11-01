package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_AddNotifyRoomStatisticsUpdated registered event.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "Statistic"})
public class EOS_RTC_RoomStatisticsUpdatedInfo extends Structure {
	/** Client-specified data passed into EOS_RTC_AddNotifyRoomStatisticsUpdated. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** Statistics in JSON format */
	public String Statistic;

	public EOS_RTC_RoomStatisticsUpdatedInfo() {
		super();
	}

	public EOS_RTC_RoomStatisticsUpdatedInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_RoomStatisticsUpdatedInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_RoomStatisticsUpdatedInfo implements Structure.ByValue {
	}
}