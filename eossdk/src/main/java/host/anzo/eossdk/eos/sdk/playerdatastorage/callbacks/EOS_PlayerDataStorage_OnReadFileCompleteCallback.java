package host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults.EOS_PlayerDataStorage_ReadFileCallbackInfo;

/**
 * Callback for when EOS_PlayerDataStorage_ReadFile completes
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_PlayerDataStorage_OnReadFileCompleteCallback extends Callback {
	void apply(EOS_PlayerDataStorage_ReadFileCallbackInfo Data);
}