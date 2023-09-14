package host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults.EOS_PlayerDataStorage_DuplicateFileCallbackInfo;

/**
 * Callback for when EOS_PlayerDataStorage_DuplicateFile completes
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_PlayerDataStorage_OnDuplicateFileCompleteCallback extends Callback {
	void apply(EOS_PlayerDataStorage_DuplicateFileCallbackInfo data);
}