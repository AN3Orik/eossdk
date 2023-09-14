package host.anzo.eossdk.eos.sdk.titlestorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbackresults.EOS_TitleStorage_FileTransferProgressCallbackInfo;

/**
 * Callback for when there is a progress update for a file transfer in progress
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_TitleStorage_OnFileTransferProgressCallback extends Callback {
	void apply(EOS_TitleStorage_FileTransferProgressCallbackInfo data);
}
