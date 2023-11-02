package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * This struct is passed in with a call to EOS_RTCAudio_QueryOutputDevicesInformation.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public class EOS_RTCAudio_QueryOutputDevicesInformationOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_QueryOutputDevicesInformation API. */
	public static final int EOS_RTCAUDIO_QUERYOUTPUTDEVICESINFORMATION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_QUERYOUTPUTDEVICESINFORMATION_API_LATEST}. */
	public int ApiVersion;

	public EOS_RTCAudio_QueryOutputDevicesInformationOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_QUERYOUTPUTDEVICESINFORMATION_API_LATEST;
	}

	public EOS_RTCAudio_QueryOutputDevicesInformationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_QueryOutputDevicesInformationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_QueryOutputDevicesInformationOptions implements Structure.ByValue {
	}
}