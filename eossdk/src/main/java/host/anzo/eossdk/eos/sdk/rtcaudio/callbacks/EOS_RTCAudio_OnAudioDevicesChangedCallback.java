package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioDevicesChangedCallbackInfo;

/**
 * Callback for notification when the audio device changed
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioDevicesChangedCallback extends Callback {
	void apply(EOS_RTCAudio_AudioDevicesChangedCallbackInfo data);
}