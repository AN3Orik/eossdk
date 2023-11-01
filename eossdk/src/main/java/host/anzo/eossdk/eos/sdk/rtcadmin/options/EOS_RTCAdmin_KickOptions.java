package host.anzo.eossdk.eos.sdk.rtcadmin.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAdmin_Kick function.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "RoomName", "TargetUserId"})
public class EOS_RTCAdmin_KickOptions extends Structure {
	/** The most recent version of the EOS_RTCAdmin_Kick API */
	public static final int EOS_RTCADMIN_KICK_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCADMIN_KICK_API_LATEST. */
	public int ApiVersion;
	/** Room name to kick the participant from */
	public String RoomName;
	/** Product User ID of the participant to kick from the room */
	public EOS_ProductUserId TargetUserId;

	public EOS_RTCAdmin_KickOptions() {
		super();
		ApiVersion = EOS_RTCADMIN_KICK_API_LATEST;
	}

	public EOS_RTCAdmin_KickOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_KickOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_KickOptions implements Structure.ByValue {
	}
}
