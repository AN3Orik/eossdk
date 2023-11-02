package host.anzo.eossdk.eos.sdk.rtcadmin.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAdmin_SetParticipantHardMute function.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "RoomName", "TargetUserId", "IsMute"})
public class EOS_RTCAdmin_SetParticipantHardMuteOptions extends Structure {
	/** The most recent version of the EOS_RTCAdmin_SetParticipantHardMuteOptions struct. */
	public static final int EOS_RTCADMIN_SETPARTICIPANTHARDMUTE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCADMIN_SETPARTICIPANTHARDMUTE_API_LATEST}. */
	public int ApiVersion;
	/** Room to kick the participant from */
	public String RoomName;
	/** Product User ID of the participant to hard mute for every participant in the room. */
	public EOS_ProductUserId TargetUserId;
	/** Hard mute status (Mute on or off) */
	public EOS_Bool IsMute;

	public EOS_RTCAdmin_SetParticipantHardMuteOptions() {
		super();
		ApiVersion = EOS_RTCADMIN_SETPARTICIPANTHARDMUTE_API_LATEST;
	}

	public EOS_RTCAdmin_SetParticipantHardMuteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_SetParticipantHardMuteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_SetParticipantHardMuteOptions implements Structure.ByValue {
	}
}