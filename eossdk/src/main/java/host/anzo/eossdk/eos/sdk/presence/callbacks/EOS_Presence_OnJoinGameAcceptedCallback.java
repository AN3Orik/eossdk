package host.anzo.eossdk.eos.sdk.presence.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.presence.callbackresults.EOS_Presence_JoinGameAcceptedCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_Presence_OnJoinGameAcceptedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that come from EOS_Presence_AddNotifyJoinGameAccepted<br>
	 * <b>EOS_UI_AcknowledgeEventId must be called with any valid UiEventId passed via the data.</b>
	 * @param data A EOS_Presence_JoinGameAcceptedCallbackInfo containing the output information and result
	 */
	void apply(EOS_Presence_JoinGameAcceptedCallbackInfo data);
}