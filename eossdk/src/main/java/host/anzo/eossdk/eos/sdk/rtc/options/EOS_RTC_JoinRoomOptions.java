package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtc.enums.EOS_RTC_JoinRoomOptions_Flags;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTC_JoinRoom.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "ClientBaseUrl", "ParticipantToken", "ParticipantId", "Flags", "IsManualAudioInputEnabled", "IsManualAudioOutputEnabled"})
public class EOS_RTC_JoinRoomOptions extends Structure {
	/** The most recent version of the EOS_RTC_JoinRoom API. */
	public final static int EOS_RTC_JOINROOM_API_LATEST = 1;

	/** API Version: Set this to EOS_RTC_JOINROOM_API_LATEST. */
	public int ApiVersion;
	/** The product user id of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room the user would like to join. */
	public String RoomName;
	/** The room the user would like to join. */
	public String ClientBaseUrl;
	/** Authorization credential token to join the room. */
	public String ParticipantToken;
	/** The participant id used to join the room. If set to NULL the LocalUserId will be used instead. */
	public EOS_ProductUserId ParticipantId;
	/** Join room flags, e.g. {@link EOS_RTC_JoinRoomOptions_Flags#EOS_RTC_JOINROOMFLAGS_ENABLE_ECHO}. This is a bitwise-or union of the defined flags. */
	public EOS_RTC_JoinRoomOptions_Flags Flags;
	/**
	 * Enable or disable Manual Audio Input. If manual audio input is enabled audio recording is not started and the audio
	 * buffers must be passed manually using EOS_RTCAudio_SendAudio.
	 */
	public EOS_Bool IsManualAudioInputEnabled;
	/**
	 * Enable or disable Manual Audio Output. If manual audio output is enabled audio rendering is not started and the audio
	 * buffers must be received with EOS_RTCAudio_AddNotifyAudioBeforeRender and rendered manually.
	 */
	public EOS_Bool IsManualAudioOutputEnabled;

	public EOS_RTC_JoinRoomOptions() {
		super();
		ApiVersion = EOS_RTC_JOINROOM_API_LATEST;
	}

	public EOS_RTC_JoinRoomOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_JoinRoomOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_JoinRoomOptions implements Structure.ByValue {
	}
}