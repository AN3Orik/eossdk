package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo;

/**
 * Callback for completion of unregister platform user request.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnUnregisterPlatformUserCallback extends Callback {
	void apply(EOS_RTCAudio_OnUnregisterPlatformUserCallbackInfo data);
}