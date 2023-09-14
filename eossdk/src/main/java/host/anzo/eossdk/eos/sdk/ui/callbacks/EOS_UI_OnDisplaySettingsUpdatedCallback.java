package host.anzo.eossdk.eos.sdk.ui.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.ui.callbackresults.EOS_UI_OnDisplaySettingsUpdatedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/9/2023
 */
public interface EOS_UI_OnDisplaySettingsUpdatedCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_UI_AddNotifyDisplaySettingsUpdated
	 * @param data A EOS_UI_OnDisplaySettingsUpdatedCallbackInfo containing the current display state.
	 */
	void apply(EOS_UI_OnDisplaySettingsUpdatedCallbackInfo data);
}