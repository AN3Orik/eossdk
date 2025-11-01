package host.anzo.eossdk.eos.sdk.rtcdata.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcdata.enums.EOS_ERTCDataStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCData_OnParticipantUpdatedCallback registered event.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "ParticipantId", "DataStatus"})
public class EOS_RTCData_ParticipantUpdatedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCData_AddNotifyParticipantUpdated. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** The participant updated. */
	public EOS_ProductUserId ParticipantId;
	/** The data channel status. */
	public EOS_ERTCDataStatus DataStatus;

	public EOS_RTCData_ParticipantUpdatedCallbackInfo() {
		super();
	}

	public EOS_RTCData_ParticipantUpdatedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCData_ParticipantUpdatedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_ParticipantUpdatedCallbackInfo implements Structure.ByValue {
	}
}