package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_UpdateReceivingCallbackInfo;

/**
 * Callback for completion of update receiving request
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnUpdateReceivingCallback extends Callback {
	void apply(EOS_RTCAudio_UpdateReceivingCallbackInfo data);
};