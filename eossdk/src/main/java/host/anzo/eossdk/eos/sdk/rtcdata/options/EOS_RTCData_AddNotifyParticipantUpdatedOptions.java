package host.anzo.eossdk.eos.sdk.rtcdata.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCData_AddNotifyDataReceived.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName"})
public class EOS_RTCData_AddNotifyParticipantUpdatedOptions extends Structure {
	/** The most recent version of the EOS_RTCData_AddNotifyDataReceived API. */
	public static final int EOS_RTCDATA_ADDNOTIFYDATARECEIVED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCDATA_ADDNOTIFYDATARECEIVED_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;

	public EOS_RTCData_AddNotifyParticipantUpdatedOptions() {
		super();
		ApiVersion = EOS_RTCDATA_ADDNOTIFYDATARECEIVED_API_LATEST;
	}

	public EOS_RTCData_AddNotifyParticipantUpdatedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCData_AddNotifyParticipantUpdatedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_AddNotifyParticipantUpdatedOptions implements Structure.ByValue {
	}
}