package host.anzo.eossdk.eos.sdk.rtcadmin.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public interface EOS_RTCAdmin_OnQueryJoinRoomTokenCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_RTCAdmin_QueryJoinRoomToken
	 * @param data An EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo containing the output information and result
	 */
	void apply(EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo data);
}