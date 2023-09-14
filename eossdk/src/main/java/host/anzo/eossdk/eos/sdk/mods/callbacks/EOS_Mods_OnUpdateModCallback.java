package host.anzo.eossdk.eos.sdk.mods.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.mods.callbackresults.EOS_Mods_UpdateModCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_Mods_OnUpdateModCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Mods_UpdateMod
	 * @param data A EOS_Mods_UpdateModCallbackInfo containing the output information and result
	 */
	void apply(EOS_Mods_UpdateModCallbackInfo data);
}