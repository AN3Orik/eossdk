package host.anzo.eossdk.eos.sdk.titlestorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbackresults.EOS_TitleStorage_DeleteCacheCallbackInfo;

/**
 * Callback for when EOS_TitleStorage_DeleteCache completes
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_TitleStorage_OnDeleteCacheCompleteCallback extends Callback {
	void apply(EOS_TitleStorage_DeleteCacheCallbackInfo data);
}