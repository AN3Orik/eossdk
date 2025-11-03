package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_ParticipantUpdatedCallbackInfo;

/**
 * Callback for notification about participant update
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnParticipantUpdatedCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAudio_AddNotifyParticipantUpdated}
	 * @param data An {@link EOS_RTCAudio_ParticipantUpdatedCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAudio_ParticipantUpdatedCallbackInfo data);
}