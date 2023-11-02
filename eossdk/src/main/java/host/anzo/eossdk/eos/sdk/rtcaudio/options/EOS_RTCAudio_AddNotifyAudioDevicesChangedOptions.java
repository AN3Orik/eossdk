package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCAudio_AddNotifyAudioDevicesChanged.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_AddNotifyAudioDevicesChanged API. */
	public static final int EOS_RTCAUDIO_ADDNOTIFYAUDIODEVICESCHANGED_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_ADDNOTIFYAUDIODEVICESCHANGED_API_LATEST. */
	public int ApiVersion;

	public EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_ADDNOTIFYAUDIODEVICESCHANGED_API_LATEST;
	}

	public EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions implements Structure.ByValue {
	}
}