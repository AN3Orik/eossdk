package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtc.EOS_RTC_Option;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_OnJoinRoomCallback.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "RoomOptionsCount", "RoomOptions"})
public class EOS_RTC_JoinRoomCallbackInfo extends Structure {
	/** This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if the channel was successfully joined.<br>
	 * {@link EOS_EResult#EOS_NoConnection}: unable to connect to RTC servers (retryable).<br>
	 * {@link EOS_EResult#EOS_InvalidAuth}: if the token is invalid (not retryable).<br>
	 * {@link EOS_EResult#EOS_RTC_TooManyParticipants}: if the room cannot accept more participants (not retryable).<br>
	 * {@link EOS_EResult#EOS_AccessDenied}: if the room name belongs to the Lobby voice system (not retryable).<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise (retryable).
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTC_JoinRoom. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room the user was trying to join. */
	public String RoomName;
	/** The room option items count. */
	public int RoomOptionsCount;
	/** The room option items. */
	public EOS_RTC_Option.ByReference RoomOptions;

	public EOS_RTC_JoinRoomCallbackInfo() {
		super();
	}

	public EOS_RTC_JoinRoomCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_JoinRoomCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_JoinRoomCallbackInfo implements Structure.ByValue {
	}
}