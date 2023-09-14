package host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbackresults.EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_ProgressionSnapshot_OnSubmitSnapshotCallback extends Callback {
	void apply(EOS_ProgressionSnapshot_SubmitSnapshotCallbackInfo Data);
}