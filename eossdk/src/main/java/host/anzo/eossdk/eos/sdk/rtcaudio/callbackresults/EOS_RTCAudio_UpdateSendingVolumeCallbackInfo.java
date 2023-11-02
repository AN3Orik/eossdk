package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_OnUpdateSendingVolumeCallback.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "Volume"})
public class EOS_RTCAudio_UpdateSendingVolumeCallbackInfo extends Structure {
	/**
	 * This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if sending volume of channels of the local user was successfully changed.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if the local user is not in the room<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCAudio_UpdateSendingVolume. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room this settings should be applied on. */
	public String RoomName;
	/** The volume that was set for sent audio (range 0.0 to 100.0). */
	public float Volume;

	public EOS_RTCAudio_UpdateSendingVolumeCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_UpdateSendingVolumeCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_UpdateSendingVolumeCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_UpdateSendingVolumeCallbackInfo implements Structure.ByValue {
	}
}