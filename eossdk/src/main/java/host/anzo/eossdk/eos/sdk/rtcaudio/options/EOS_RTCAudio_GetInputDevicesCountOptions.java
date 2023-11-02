package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAudio_GetInputDevicesCount function.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_RTCAudio_GetInputDevicesCountOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_GetInputDevicesCount API. */
	public static final int EOS_RTCAUDIO_GETINPUTDEVICESCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_GETINPUTDEVICESCOUNT_API_LATEST}. */
	public int ApiVersion;

	public EOS_RTCAudio_GetInputDevicesCountOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_GETINPUTDEVICESCOUNT_API_LATEST;
	}

	public EOS_RTCAudio_GetInputDevicesCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_GetInputDevicesCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_GetInputDevicesCountOptions implements Structure.ByValue {
	}
}