package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioOutputStateCallbackInfo;

/**
 * Callback for notification when the audio device output state changed
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioOutputStateCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAudio_AddNotifyAudioOutputState}
	 * @param data An {@link EOS_RTCAudio_AudioOutputStateCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAudio_AudioOutputStateCallbackInfo data);
}
