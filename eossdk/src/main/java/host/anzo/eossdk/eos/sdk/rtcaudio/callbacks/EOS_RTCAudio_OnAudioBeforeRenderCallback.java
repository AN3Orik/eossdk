package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_AudioBeforeRenderCallbackInfo;

/**
 * Callback for notification when local audio buffers are about to be encoded and sent.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnAudioBeforeRenderCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAudio_AddNotifyAudioBeforeRender}
	 * @param data An {@link EOS_RTCAudio_AudioBeforeRenderCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAudio_AudioBeforeRenderCallbackInfo data);
}