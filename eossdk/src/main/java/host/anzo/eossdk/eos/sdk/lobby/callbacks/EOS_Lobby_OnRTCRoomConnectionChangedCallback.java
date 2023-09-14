package host.anzo.eossdk.eos.sdk.lobby.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_Lobby_Interface;
import host.anzo.eossdk.eos.sdk.lobby.callbackresults.EOS_Lobby_RTCRoomConnectionChangedCallbackInfo;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_IsRTCRoomConnectedOptions;

import java.nio.IntBuffer;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Lobby_OnRTCRoomConnectionChangedCallback extends Callback {
	/**
	 * Function prototype definition for notifications that comes from EOS_Lobby_AddNotifyRTCRoomConnectionChanged
	 *
	 * @param data containing the connection state of the RTC Room for a lobby
	 *
	 * @see EOS_Lobby_Interface#isRTCRoomConnected(EOS_Lobby_IsRTCRoomConnectedOptions, IntBuffer)
	 */
	void apply(EOS_Lobby_RTCRoomConnectionChangedCallbackInfo data);
}