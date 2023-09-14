package host.anzo.eossdk.eos.sdk.kws.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.kws.callbackresults.EOS_KWS_QueryAgeGateCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public interface EOS_KWS_OnQueryAgeGateCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_KWS_QueryAgeGate
	 * @param data A EOS_KWS_QueryAgeGateCallbackInfo containing the output information and result
	 */
	void apply(EOS_KWS_QueryAgeGateCallbackInfo data);
}