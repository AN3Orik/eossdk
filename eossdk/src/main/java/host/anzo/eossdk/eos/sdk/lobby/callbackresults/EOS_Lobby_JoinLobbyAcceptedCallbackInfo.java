package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_OnJoinLobbyAcceptedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "UiEventId"})
public class EOS_Lobby_JoinLobbyAcceptedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyJoinLobbyAccepted */
	public Pointer ClientData;
	/** The Product User ID of the local user who is joining */
	public EOS_ProductUserId LocalUserId;
	/**
	 * The UI Event associated with this Join Game event.
	 * This should be used with EOS_Lobby_CopyLobbyDetailsHandleByUiEventId to get a handle to be used
	 * when calling EOS_Lobby_JoinLobby.
	 */
	public long UiEventId;

	public EOS_Lobby_JoinLobbyAcceptedCallbackInfo() {
		super();
	}

	public EOS_Lobby_JoinLobbyAcceptedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_JoinLobbyAcceptedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_JoinLobbyAcceptedCallbackInfo implements Structure.ByValue {
	}
}