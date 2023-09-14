package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_UI_Interface;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_SendLobbyNativeInviteRequestedCallbackInfo;
import host.anzo.eossdk.eos.sdk.ui.options.EOS_UI_AcknowledgeEventIdOptions;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnSendLobbyNativeInviteRequestedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifySendLobbyNativeInviteRequested<br>
	 * <b>After processing the callback EOS_UI_AcknowledgeEventId must be called.</b>
	 * @param data A EOS_Lobby_SendLobbyNativeInviteRequestedCallbackInfo containing the output information and result
	 * @see EOS_UI_Interface#acknowledgeEventId(EOS_UI_AcknowledgeEventIdOptions)
	 */
	void apply(EOS_Lobby_SendLobbyNativeInviteRequestedCallbackInfo data);
}