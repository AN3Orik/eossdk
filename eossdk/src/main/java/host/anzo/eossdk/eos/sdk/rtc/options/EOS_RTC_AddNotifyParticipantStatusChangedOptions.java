package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTC_AddNotifyParticipantStatusChanged.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName"})
public class EOS_RTC_AddNotifyParticipantStatusChangedOptions extends Structure {
	/** The most recent version of the EOS_RTC_AddNotifyParticipantStatusChanged API. */
	public static final int EOS_RTC_ADDNOTIFYPARTICIPANTSTATUSCHANGED_API_LATEST = 1;

	/** API Version: Set this to EOS_RTC_ADDNOTIFYPARTICIPANTSTATUSCHANGED_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;

	public EOS_RTC_AddNotifyParticipantStatusChangedOptions() {
		super();
		ApiVersion = EOS_RTC_ADDNOTIFYPARTICIPANTSTATUSCHANGED_API_LATEST;
	}

	public EOS_RTC_AddNotifyParticipantStatusChangedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_AddNotifyParticipantStatusChangedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_AddNotifyParticipantStatusChangedOptions implements Structure.ByValue {
	}
}