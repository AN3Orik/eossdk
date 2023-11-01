package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_AddNotifyDisconnected registered event.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName"})
public class EOS_RTC_DisconnectedCallbackInfo extends Structure {
	/** This returns:<br>
	 * {@link EOS_EResult#EOS_Success} The room was left cleanly.<br>
	 * {@link EOS_EResult#EOS_NoConnection}: There was a network issue connecting to the server (retryable).<br>
	 * {@link EOS_EResult#EOS_RTC_UserKicked}: The user has been kicked by the server (retryable).<br>
	 * {@link EOS_EResult#EOS_ServiceFailure}: A known error occurred during interaction with the server (retryable).<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} Unexpected error (retryable).
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTC_AddNotifyDisconnected. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;

	public EOS_RTC_DisconnectedCallbackInfo() {
		super();
	}

	public EOS_RTC_DisconnectedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_DisconnectedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_DisconnectedCallbackInfo implements Structure.ByValue {
	}
}