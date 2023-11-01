package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_OnBlockParticipantCallback.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RoomName", "ParticipantId", "IsBlocked"})
public class EOS_RTC_BlockParticipantCallbackInfo extends Structure {
	/** This returns:<br>
	 * {@link EOS_EResult#EOS_Success} if the channel was successfully blocked<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if either the local user or specified participant are not in the specified room<br>
	 * {@link EOS_EResult#EOS_RTC_UserIsInBlocklist} if the user is in one of the platform's applicable block lists and thus an RTC unblock is not allowed.<br>
	 * {@link EOS_EResult#EOS_UnexpectedError} otherwise.
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_RTC_BlockParticipant. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room the users should be blocked on. */
	public String RoomName;
	/** The Product User ID of the participant being blocked */
	public EOS_ProductUserId ParticipantId;
	/** The block state that should have been set */
	public EOS_Bool IsBlocked;

	public EOS_RTC_BlockParticipantCallbackInfo() {
		super();
	}

	public EOS_RTC_BlockParticipantCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_BlockParticipantCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_BlockParticipantCallbackInfo implements Structure.ByValue {
	}
}