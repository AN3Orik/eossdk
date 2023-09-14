package host.anzo.eossdk.eos.sdk.achievements.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.achievements.callbackresults.EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Achievements_OnQueryDefinitionsCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Achievements_QueryDefinitions
	 * @param data An EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo data);
}