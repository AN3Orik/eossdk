package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_QueryAgeGate Function. These parameters are received through the callback provided to EOS_KWS_QueryAgeGate
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData", "CountryCode", "AgeOfConsent"})
public class EOS_KWS_QueryAgeGateCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed queries is exceeded
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_KWS_QueryAgeGate */
	public Pointer ClientData;
	/** Country code determined for this request based on the local client's ip address that the backend resolves */
	public String CountryCode;
	/** Age of consent in the given country */
	public int AgeOfConsent;

	public EOS_KWS_QueryAgeGateCallbackInfo() {
		super();
	}

	public EOS_KWS_QueryAgeGateCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_QueryAgeGateCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_QueryAgeGateCallbackInfo implements Structure.ByValue {
	}
}