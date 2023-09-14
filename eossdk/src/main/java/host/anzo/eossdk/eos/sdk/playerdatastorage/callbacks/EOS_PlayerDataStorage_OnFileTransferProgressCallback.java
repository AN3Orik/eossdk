package host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults.EOS_PlayerDataStorage_FileTransferProgressCallbackInfo;

/**
 * Callback for when there is a progress update for a file transfer in progress
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_PlayerDataStorage_OnFileTransferProgressCallback extends Callback {
	void apply(EOS_PlayerDataStorage_FileTransferProgressCallbackInfo data);
}