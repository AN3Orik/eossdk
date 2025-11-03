package host.anzo.eossdk.eos.sdk.rtcdata.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcdata.callbackresults.EOS_RTCData_ParticipantUpdatedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 4/4/2024
 */
public interface EOS_RTCData_OnParticipantUpdatedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from {@link EOSLibrary#EOS_RTCData_AddNotifyParticipantUpdated}
	 *
	 * @param data A {@link EOS_RTCData_ParticipantUpdatedCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCData_ParticipantUpdatedCallbackInfo data);
}