package host.anzo.eossdk.eos.sdk.ecom.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.ecom.callbackresults.EOS_Ecom_CheckoutCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Ecom_OnCheckoutCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Ecom_Checkout
	 * @param data A EOS_Ecom_CheckoutCallbackInfo containing the output information and result
	 */
	void apply(EOS_Ecom_CheckoutCallbackInfo data);
}