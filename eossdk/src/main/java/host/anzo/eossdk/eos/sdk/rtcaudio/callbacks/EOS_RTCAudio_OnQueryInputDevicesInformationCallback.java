package host.anzo.eossdk.eos.sdk.rtcaudio.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_OnQueryInputDevicesInformationCallbackInfo;

/**
 * Callback for completion of query input devices information request.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
public interface EOS_RTCAudio_OnQueryInputDevicesInformationCallback extends Callback {
	void apply(EOS_RTCAudio_OnQueryInputDevicesInformationCallbackInfo data);
}