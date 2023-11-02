package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_UpdateReceiving.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "ParticipantId", "IsAudioEnabled"})
public class EOS_RTCAudio_UpdateReceivingOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_UpdateReceiving API. */
	public static final int EOS_RTCAUDIO_UPDATERECEIVING_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_UPDATERECEIVING_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** The participant to modify or null to update the global configuration */
	public EOS_ProductUserId ParticipantId;
	/** Mute or unmute audio track */
	public EOS_Bool IsAudioEnabled;

	public EOS_RTCAudio_UpdateReceivingOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_UPDATERECEIVING_API_LATEST;
	}

	public EOS_RTCAudio_UpdateReceivingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateReceivingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateReceivingOptions implements Structure.ByValue {
	}
}