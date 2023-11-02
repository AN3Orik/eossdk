package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTC_AddNotifyDisconnected.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName"})
public class EOS_RTC_AddNotifyDisconnectedOptions extends Structure {
	/** The most recent version of the EOS_RTC_AddNotifyDisconnected API. */
	public static final int EOS_RTC_ADDNOTIFYDISCONNECTED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTC_ADDNOTIFYDISCONNECTED_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;

	public EOS_RTC_AddNotifyDisconnectedOptions() {
		super();
		ApiVersion = EOS_RTC_ADDNOTIFYDISCONNECTED_API_LATEST;
	}

	public EOS_RTC_AddNotifyDisconnectedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_AddNotifyDisconnectedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_AddNotifyDisconnectedOptions implements Structure.ByValue {
	}
}