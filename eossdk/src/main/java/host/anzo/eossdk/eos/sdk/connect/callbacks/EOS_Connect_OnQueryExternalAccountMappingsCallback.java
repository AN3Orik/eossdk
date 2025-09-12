package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_QueryExternalAccountMappingsCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnQueryExternalAccountMappingsCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_LinkAccount.
	 * @param data A EOS_Connect_LinkAccountCallbackInfo containing the output information and result.
	 */
	void run(EOS_Connect_QueryExternalAccountMappingsCallbackInfo data);
}