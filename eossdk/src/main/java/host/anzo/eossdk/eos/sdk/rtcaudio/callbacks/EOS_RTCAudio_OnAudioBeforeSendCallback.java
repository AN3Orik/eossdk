package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioBeforeSendCallbackInfo;

/**
 * Callback for notification when remote audio buffers before they are rendered.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioBeforeSendCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAudio_AddNotifyAudioBeforeSend}
	 * @param data An {@link EOS_RTCAudio_AudioBeforeSendCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAudio_AudioBeforeSendCallbackInfo data);
}