package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_QueryProductUserIdMappingsCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnQueryProductUserIdMappingsCallback extends Callback {
	void run(EOS_Connect_QueryProductUserIdMappingsCallbackInfo data);
}
