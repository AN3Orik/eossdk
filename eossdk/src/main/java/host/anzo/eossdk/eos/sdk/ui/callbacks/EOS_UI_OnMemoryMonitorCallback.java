package host.anzo.eossdk.eos.sdk.ui.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.ui.callbackresults.EOS_UI_MemoryMonitorCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/9/2023
 */
public interface EOS_UI_OnMemoryMonitorCallback extends Callback {
	void apply(EOS_UI_MemoryMonitorCallbackInfo data);
}