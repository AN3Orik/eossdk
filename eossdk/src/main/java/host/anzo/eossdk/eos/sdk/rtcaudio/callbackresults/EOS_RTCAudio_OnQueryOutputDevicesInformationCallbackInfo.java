package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_OnQueryOutputDevicesInformationCallback.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_RTCAudio_OnQueryOutputDevicesInformationCallbackInfo extends Structure {
	/**
	 * This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if the operation succeeded.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTCAudio_QueryOutputDevicesInformation. */
	public Pointer ClientData;

	public EOS_RTCAudio_OnQueryOutputDevicesInformationCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_OnQueryOutputDevicesInformationCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_OnQueryOutputDevicesInformationCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_OnQueryOutputDevicesInformationCallbackInfo implements Structure.ByValue {
	}
}