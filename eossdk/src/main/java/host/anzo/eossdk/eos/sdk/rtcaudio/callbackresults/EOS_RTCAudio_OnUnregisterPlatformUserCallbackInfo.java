package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_OnUnregisterPlatformUserCallback.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ResultCode", "ClientData", "PlatformUserId"})
public class EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo extends Structure {
	/**
	 * This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if the user was successfully unregistered.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCAudio_UnregisterPlatformUser. */
	public Pointer ClientData;
	/** Platform dependent user id. */
	public String PlatformUserId;

	public EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo implements Structure.ByValue {
	}
}