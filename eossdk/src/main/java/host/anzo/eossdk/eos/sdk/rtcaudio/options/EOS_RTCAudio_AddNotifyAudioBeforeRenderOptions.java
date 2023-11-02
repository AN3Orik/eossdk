package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCAudio_AddNotifyAudioBeforeRender.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "IsUnmixedAudio"})
public class EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_AddNotifyAudioBeforeRender API. */
	public static final int EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORERENDER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORERENDER_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;
	/** Mixed audio or unmixed audio. */
	public EOS_Bool IsUnmixedAudio;

	public EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_ADDNOTIFYAUDIOBEFORERENDER_API_LATEST;
	}

	public EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions implements Structure.ByValue {
	}
}