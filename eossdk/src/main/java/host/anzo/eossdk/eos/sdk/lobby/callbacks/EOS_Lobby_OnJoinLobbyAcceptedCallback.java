package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.sdk.EOS_Lobby_Interface;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_JoinLobbyAcceptedCallbackInfo;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_JoinLobbyOptions;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnJoinLobbyAcceptedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyJoinLobbyAccepted<br>
	 * <b>The lobby for the join game must be joined.</b>
	 * @param data A EOS_Lobby_JoinLobbyAcceptedCallbackInfo containing the output information and result
	 *
	 * @see EOS_Lobby_Interface#copyLobbyDetailsHandleByUiEventId(EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions, PointerByReference)
	 * @see EOS_Lobby_Interface#joinLobby(EOS_Lobby_JoinLobbyOptions, Pointer, EOS_Lobby_OnJoinLobbyCallback)
	 */
	void apply(EOS_Lobby_JoinLobbyAcceptedCallbackInfo data);
}