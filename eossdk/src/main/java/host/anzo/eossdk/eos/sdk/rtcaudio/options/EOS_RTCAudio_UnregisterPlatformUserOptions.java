package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to remove a user from the audio system.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "PlatformUserId"})
public class EOS_RTCAudio_UnregisterPlatformUserOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_UnregisterPlatformUser API. */
	public static final int EOS_RTCAUDIO_UNREGISTERPLATFORMUSER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_UNREGISTERPLATFORMUSER_API_LATEST}. */
	public int ApiVersion;
	/** The account of a user associated with this event. */
	public String PlatformUserId;

	public EOS_RTCAudio_UnregisterPlatformUserOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_UNREGISTERPLATFORMUSER_API_LATEST;
	}

	public EOS_RTCAudio_UnregisterPlatformUserOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UnregisterPlatformUserOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UnregisterPlatformUserOptions implements Structure.ByValue {
	}
}