package host.anzo.eossdk.eos.sdk.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.*;

/**
 * Options for initializing rtc functionality required for some platforms.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "XAudio29DllPath"})
public class EOS_Windows_RTCOptions extends Structure {
	/** The most recent version of the EOS_Windows_RTCOptions structure. */
	public static final int EOS_WINDOWS_RTCOPTIONS_API_LATEST = 1;

	/** API Version: Set this to EOS_RTC_ADDNOTIFYPARTICIPANTSTATUSCHANGED_API_LATEST. */
	public int ApiVersion;
	/** The absolute path to a `xaudio2_9redist.dll` dependency, including the file name. */
	public String XAudio29DllPath;

	public EOS_Windows_RTCOptions() {
		super();
		ApiVersion = EOS_WINDOWS_RTCOPTIONS_API_LATEST;
	}

	public EOS_Windows_RTCOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Windows_RTCOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Windows_RTCOptions implements Structure.ByValue {
	}
}