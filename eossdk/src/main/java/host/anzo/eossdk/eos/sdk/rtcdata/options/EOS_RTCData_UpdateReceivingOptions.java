package host.anzo.eossdk.eos.sdk.rtcdata.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCData_UpdateReceiving.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "ParticipantId", "IsDataEnabled"})
public class EOS_RTCData_UpdateReceivingOptions extends Structure {
	/** The most recent version of the EOS_RTCData_UpdateReceiving API. */
	private final static int EOS_RTCDATA_UPDATERECEIVING_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCDATA_UPDATERECEIVING_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** The participant to modify or null to update the global configuration */
	public EOS_ProductUserId ParticipantId;
	/** Creates or destroys data channel subscription */
	public int IsDataEnabled;

	public EOS_RTCData_UpdateReceivingOptions() {
		super();
		ApiVersion = EOS_RTCDATA_UPDATERECEIVING_API_LATEST;
	}

	public EOS_RTCData_UpdateReceivingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCData_UpdateReceivingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_UpdateReceivingOptions implements Structure.ByValue {
	}
}