package host.anzo.eossdk.eos.sdk.sanctions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.sanctions.callbackresults.EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Sanctions_OnQueryActivePlayerSanctionsCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Sanctions_QueryActivePlayerSanctions
	 * @param data A EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo containing the output information and result
	 */
	void apply(EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo data);
}