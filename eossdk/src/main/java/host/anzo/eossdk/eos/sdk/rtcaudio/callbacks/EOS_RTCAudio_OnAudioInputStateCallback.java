package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioInputStateCallbackInfo;

/**
 * Callback for notification when the audio device input state changed
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioInputStateCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAudio_AddNotifyAudioInputState}
	 * @param data An {@link EOS_RTCAudio_AudioInputStateCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAudio_AudioInputStateCallbackInfo data);
}