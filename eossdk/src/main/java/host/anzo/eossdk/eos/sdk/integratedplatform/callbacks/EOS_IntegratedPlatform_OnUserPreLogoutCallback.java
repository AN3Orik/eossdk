package host.anzo.eossdk.eos.sdk.integratedplatform.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbackresults.EOS_IntegratedPlatform_UserPreLogoutCallbackInfo;

/**
 * The callback function for when an integrated platform user is detected to have logged-out.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_IntegratedPlatform_OnUserPreLogoutCallback extends Callback {
	int apply(EOS_IntegratedPlatform_UserPreLogoutCallbackInfo Data);
}