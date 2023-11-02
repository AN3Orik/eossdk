package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCAudio_AddNotifyAudioBeforeSend.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName"})
public class EOS_RTCAudio_AddNotifyAudioBeforeSendOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_AddNotifyAudioBeforeSend API. */
	public static final int EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORESEND_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORESEND_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;

	public EOS_RTCAudio_AddNotifyAudioBeforeSendOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORESEND_API_LATEST;
	}

	public EOS_RTCAudio_AddNotifyAudioBeforeSendOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AddNotifyAudioBeforeSendOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AddNotifyAudioBeforeSendOptions implements Structure.ByValue {
	}
}