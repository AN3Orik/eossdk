package host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for a kick participant request.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_RTCAdmin_KickCompleteCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the kick request */
	public Pointer ClientData;

	public EOS_RTCAdmin_KickCompleteCallbackInfo() {
		super();
	}

	public EOS_RTCAdmin_KickCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_KickCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_KickCompleteCallbackInfo implements Structure.ByValue {
	}
}