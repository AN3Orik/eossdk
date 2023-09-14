package host.anzo.eossdk.eos.sdk.titlestorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbackresults.EOS_TitleStorage_QueryFileListCallbackInfo;

/**
 * Callback for when EOS_TitleStorage_QueryFileList completes
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_TitleStorage_OnQueryFileListCompleteCallback extends Callback {
	void apply(EOS_TitleStorage_QueryFileListCallbackInfo data);
}
