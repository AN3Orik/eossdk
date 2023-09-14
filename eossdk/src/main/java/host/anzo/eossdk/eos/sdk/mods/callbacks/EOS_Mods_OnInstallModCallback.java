package host.anzo.eossdk.eos.sdk.mods.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.mods.callbackresults.EOS_Mods_InstallModCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_Mods_OnInstallModCallback extends Callback {
	void apply(EOS_Mods_InstallModCallbackInfo Data);
}