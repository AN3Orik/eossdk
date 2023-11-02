package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * This struct is used to call EOS_RTCAudio_AddNotifyParticipantUpdated.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName"})
public class EOS_RTCAudio_AddNotifyParticipantUpdatedOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_AddNotifyParticipantUpdated API. */
	public static final int EOS_RTCAUDIO_ADDNOTIFYPARTICIPANTUPDATED_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_ADDNOTIFYPARTICIPANTUPDATED_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;

	public EOS_RTCAudio_AddNotifyParticipantUpdatedOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_ADDNOTIFYPARTICIPANTUPDATED_API_LATEST;
	}

	public EOS_RTCAudio_AddNotifyParticipantUpdatedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AddNotifyParticipantUpdatedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AddNotifyParticipantUpdatedOptions implements Structure.ByValue {
	}
}