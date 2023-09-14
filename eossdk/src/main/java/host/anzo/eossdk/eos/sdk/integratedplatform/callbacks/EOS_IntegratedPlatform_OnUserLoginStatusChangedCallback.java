package host.anzo.eossdk.eos.sdk.integratedplatform.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbackresults.EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo;

/**
 * The callback function for when a local integrated platform user's login status has changed.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback extends Callback {
	void apply(EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo Data);
}