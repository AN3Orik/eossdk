package host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbackresults.EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_ProgressionSnapshot_OnDeleteSnapshotCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_ProgressionSnapshot_DeleteSnapshot
	 * @param data A {@link EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo} containing the output information and result
	 */
	void apply(EOS_ProgressionSnapshot_DeleteSnapshotCallbackInfo data);
}