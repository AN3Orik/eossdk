package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_OnLeaveRoomCallback.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName"})
public class EOS_RTC_LeaveRoomCallbackInfo extends Structure {
	/** This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if the channel was successfully left.<br>
	 * {@link EOS_EResult#EOS_AccessDenied} if the room name belongs to the Lobby voice system.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTC_LeaveRoomOptions. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room the user was trying to leave. */
	public String RoomName;

	public EOS_RTC_LeaveRoomCallbackInfo() {
		super();
	}

	public EOS_RTC_LeaveRoomCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_LeaveRoomCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_LeaveRoomCallbackInfo implements Structure.ByValue {
	}
}