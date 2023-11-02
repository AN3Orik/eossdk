package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_QueryInputDevicesInformation.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_RTCAudio_QueryInputDevicesInformationOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_QueryInputDevicesInformation API. */
	public static final int EOS_RTCAUDIO_QUERYINPUTDEVICESINFORMATION_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_QUERYINPUTDEVICESINFORMATION_API_LATEST. */
	public int ApiVersion;

	public EOS_RTCAudio_QueryInputDevicesInformationOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_QUERYINPUTDEVICESINFORMATION_API_LATEST;
	}

	public EOS_RTCAudio_QueryInputDevicesInformationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_QueryInputDevicesInformationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_QueryInputDevicesInformationOptions implements Structure.ByValue {
	}
}