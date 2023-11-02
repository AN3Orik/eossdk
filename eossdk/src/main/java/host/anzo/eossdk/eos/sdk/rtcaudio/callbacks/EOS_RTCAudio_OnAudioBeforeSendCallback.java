package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioBeforeSendCallbackInfo;

/**
 * Callback for notification when remote audio buffers before they are rendered.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioBeforeSendCallback extends Callback {
	void apply(EOS_RTCAudio_AudioBeforeSendCallbackInfo data);
}