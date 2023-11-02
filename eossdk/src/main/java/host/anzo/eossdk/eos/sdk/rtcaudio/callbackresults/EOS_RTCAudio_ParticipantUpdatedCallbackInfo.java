package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.enums.EOS_ERTCAudioStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_AddNotifyParticipantUpdated registered event.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "ParticipantId", "IsSpeaking", "AudioStatus"})
public class EOS_RTCAudio_ParticipantUpdatedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCAudio_AddNotifyParticipantUpdated. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** The participant updated. */
	public EOS_ProductUserId ParticipantId;
	/** The participant speaking / non-speaking status. */
	public EOS_Bool IsSpeaking;
	/** The participant audio status (enabled, disabled). */
	public EOS_ERTCAudioStatus AudioStatus;

	public EOS_RTCAudio_ParticipantUpdatedCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_ParticipantUpdatedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_ParticipantUpdatedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_ParticipantUpdatedCallbackInfo implements Structure.ByValue {
	}
}