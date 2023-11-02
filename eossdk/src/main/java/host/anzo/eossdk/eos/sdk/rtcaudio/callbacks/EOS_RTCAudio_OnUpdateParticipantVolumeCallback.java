package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_UpdateParticipantVolumeCallbackInfo;

/**
 * Callback for completion of update participant volume request.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnUpdateParticipantVolumeCallback extends Callback {
	void apply(EOS_RTCAudio_UpdateParticipantVolumeCallbackInfo data);
}