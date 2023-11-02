package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_RTCAudio_GetOutputDevicesCount function.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_RTCAudio_GetOutputDevicesCountOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_GetOutputDevicesCount API. */
	public static final int EOS_RTCAUDIO_GETOUTPUTDEVICESCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_GETOUTPUTDEVICESCOUNT_API_LATEST}. */
	public int ApiVersion;

	public EOS_RTCAudio_GetOutputDevicesCountOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_GETOUTPUTDEVICESCOUNT_API_LATEST;
	}

	public EOS_RTCAudio_GetOutputDevicesCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_GetOutputDevicesCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_GetOutputDevicesCountOptions implements Structure.ByValue {
	}
}