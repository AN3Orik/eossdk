package host.anzo.eossdk.eos.sdk.sanctions.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.sanctions.callbackresults.EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 3/24/2024
 */
public interface EOS_Sanctions_CreatePlayerSanctionAppealCallback extends Callback {
	/**
	 * Function definition for callbacks passed to EOS_Sanctions_CreatePlayerSanctionAppeal.
	 * @param data EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo containing the output information and result.
	 */
	void apply(EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo data);
}