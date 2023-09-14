package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_UpdateParentEmailOptions Function. These parameters are received through the callback provided to EOS_KWS_UpdateParentEmail
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_KWS_UpdateParentEmailCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} if contact information update completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed requests is exceeded
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_KWS_UpdateParentEmail */
	public Pointer ClientData;
	/** Local user updating their parental email */
	public EOS_ProductUserId LocalUserId;

	public EOS_KWS_UpdateParentEmailCallbackInfo() {
		super();
	}

	public EOS_KWS_UpdateParentEmailCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_UpdateParentEmailCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_UpdateParentEmailCallbackInfo implements Structure.ByValue {
	}
}