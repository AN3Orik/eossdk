package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_LinkAccountCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnLinkAccountCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_QueryExternalAccountMappings.
	 * @param data A EOS_Connect_QueryExternalAccountMappingsCallbackInfo containing the output information and result.
	 */
	void run(EOS_Connect_LinkAccountCallbackInfo data);
}