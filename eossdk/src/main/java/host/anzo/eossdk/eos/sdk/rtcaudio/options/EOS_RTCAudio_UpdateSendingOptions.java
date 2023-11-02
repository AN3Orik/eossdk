package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.enums.EOS_ERTCAudioStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_UpdateSending
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "AudioStatus"})
public class EOS_RTCAudio_UpdateSendingOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_UpdateSending API. */
	public static final int EOS_RTCAUDIO_UPDATESENDING_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_UPDATESENDING_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** Muted or unmuted audio track status */
	public EOS_ERTCAudioStatus AudioStatus;

	public EOS_RTCAudio_UpdateSendingOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_UPDATESENDING_API_LATEST;
	}

	public EOS_RTCAudio_UpdateSendingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateSendingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateSendingOptions implements Structure.ByValue {
	}
}