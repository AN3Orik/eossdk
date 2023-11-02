package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_RTCAudio_CopyOutputDeviceInformationByIndex function.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "DeviceIndex"})
public class EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_CopyOutputDeviceInformationByIndex API. */
	public static final int EOS_RTCAUDIO_COPYOUTPUTDEVICEINFORMATIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_COPYOUTPUTDEVICEINFORMATIONBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** Index of the audio output device's information to retrieve. */
	public int DeviceIndex;

	public EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_COPYOUTPUTDEVICEINFORMATIONBYINDEX_API_LATEST;
	}

	public EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions implements Structure.ByValue {
	}
}