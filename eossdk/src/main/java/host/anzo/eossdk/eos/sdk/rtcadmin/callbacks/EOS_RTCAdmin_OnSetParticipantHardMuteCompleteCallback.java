package host.anzo.eossdk.eos.sdk.rtcadmin.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_SetParticipantHardMuteCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public interface EOS_RTCAdmin_OnSetParticipantHardMuteCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to {@link EOSLibrary#EOS_RTCAdmin_SetParticipantHardMute}
	 * @param data An {@link EOS_RTCAdmin_SetParticipantHardMuteCompleteCallbackInfo} containing the output information and result
	 */
	void apply(EOS_RTCAdmin_SetParticipantHardMuteCompleteCallbackInfo data);
}