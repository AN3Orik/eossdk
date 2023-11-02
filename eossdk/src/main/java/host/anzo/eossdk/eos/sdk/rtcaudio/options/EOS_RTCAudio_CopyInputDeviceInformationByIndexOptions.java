package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAudio_CopyInputDeviceInformationByIndex function.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "DeviceIndex"})
public class EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_CopyInputDeviceInformationByIndex API. */
	public static final int EOS_RTCAUDIO_COPYINPUTDEVICEINFORMATIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_COPYINPUTDEVICEINFORMATIONBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** Index of the audio input device's information to retrieve. */
	public int DeviceIndex;

	public EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_COPYINPUTDEVICEINFORMATIONBYINDEX_API_LATEST;
	}

	public EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions implements Structure.ByValue {
	}
}