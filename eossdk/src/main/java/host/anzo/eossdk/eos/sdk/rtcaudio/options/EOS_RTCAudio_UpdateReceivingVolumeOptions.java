package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_UpdateReceivingVolume
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "Volume"})
public class EOS_RTCAudio_UpdateReceivingVolumeOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_UpdateReceivingVolume API. */
	public static final int EOS_RTCAUDIO_UPDATERECEIVINGVOLUME_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_UPDATERECEIVINGVOLUME_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/**
	 * The volume to be set for received audio (range 0.0 to 100.0). Volume 50 means that the audio volume is not modified
	 * and stays in its source value.
	 */
	public float Volume;

	public EOS_RTCAudio_UpdateReceivingVolumeOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_UPDATERECEIVINGVOLUME_API_LATEST;
	}

	public EOS_RTCAudio_UpdateReceivingVolumeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateReceivingVolumeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateReceivingVolumeOptions implements Structure.ByValue {
	}
}