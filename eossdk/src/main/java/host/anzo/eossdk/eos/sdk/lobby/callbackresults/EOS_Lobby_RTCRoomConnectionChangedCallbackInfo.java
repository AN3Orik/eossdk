package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ClientData", "LobbyId", "LocalUserId", "bIsConnected", "DisconnectReason"})
public class EOS_Lobby_RTCRoomConnectionChangedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Lobby_AddNotifyRTCRoomConnectionChanged */
	public Pointer ClientData;
	/** The ID of the lobby which had a RTC Room connection state change */
	public String LobbyId;
	/** The Product User ID of the local user who is in the lobby and registered for notifications */
	public EOS_ProductUserId LocalUserId;
	/** The new connection state of the room */
	public int bIsConnected;
	/**
	 * If bIsConnected is EOS_FALSE, this result will be the reason we were disconnected.
	 * {@link EOS_EResult#EOS_Success}: The room was left locally. This may be because: the associated lobby was Left or Destroyed, the connection to the lobby was interrupted, or because the SDK is being shutdown. If the lobby connection returns (lobby did not permanently go away), we will reconnect.<br>
	 * {@link EOS_EResult#EOS_NoConnection}: There was a network issue connecting to the server. We will attempt to reconnect soon.<br>
	 * {@link EOS_EResult#EOS_RTC_UserKicked}: The user has been kicked by the server. We will not reconnect.<br>
	 * {@link EOS_EResult#EOS_RTC_UserBanned}: The user has been banned by the server. We will not reconnect.<br>
	 * {@link EOS_EResult#EOS_ServiceFailure}: A known error occurred during interaction with the server. We will attempt to reconnect soon.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError}: Unexpected error. We will attempt to reconnect soon.
	 */
	public EOS_EResult DisconnectReason;

	public EOS_Lobby_RTCRoomConnectionChangedCallbackInfo() {
		super();
	}

	public EOS_Lobby_RTCRoomConnectionChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_RTCRoomConnectionChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_RTCRoomConnectionChangedCallbackInfo implements Structure.ByValue {
	}
}