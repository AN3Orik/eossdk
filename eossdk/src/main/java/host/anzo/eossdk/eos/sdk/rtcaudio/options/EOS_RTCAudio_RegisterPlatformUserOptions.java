package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to inform the audio system of a user.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "PlatformUserId"})
public class EOS_RTCAudio_RegisterPlatformUserOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_RegisterPlatformUser API. */
	public static final int EOS_RTCAUDIO_REGISTERPLATFORMUSER_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCAUDIO_REGISTERPLATFORMUSER_API_LATEST. */
	public int ApiVersion;
	/** Platform dependent user id. */
	public String PlatformUserId;

	public EOS_RTCAudio_RegisterPlatformUserOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_REGISTERPLATFORMUSER_API_LATEST;
	}

	public EOS_RTCAudio_RegisterPlatformUserOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_RegisterPlatformUserOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_RegisterPlatformUserOptions implements Structure.ByValue {
	}
}