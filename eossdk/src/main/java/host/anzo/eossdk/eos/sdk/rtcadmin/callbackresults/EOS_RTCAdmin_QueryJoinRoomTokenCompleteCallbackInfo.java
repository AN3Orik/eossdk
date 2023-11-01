package host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_RTC_Admin_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtcadmin.options.EOS_RTCAdmin_CopyUserTokenByIndexOptions;
import host.anzo.eossdk.eos.sdk.rtcadmin.options.EOS_RTCAdmin_CopyUserTokenByUserIdOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for a query join room token request.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ResultCode", "ClientData", "RoomName", "ClientBaseUrl", "QueryId", "TokenCount"})
public class EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_RTCAdmin_QueryJoinRoomToken. */
	public Pointer ClientData;
	/** Room the request was made for. */
	public String RoomName;
	/** URL passed to backend to join room. */
	public String ClientBaseUrl;
	/**
	 * If the query completed successfully, this contains an identifier that should be used to retrieve the tokens.
	 * This identifier is only valid for the duration of the callback.
	 *
	 * @see EOS_RTC_Admin_Interface#copyUserTokenByIndex(EOS_RTCAdmin_CopyUserTokenByIndexOptions)
	 * @see EOS_RTC_Admin_Interface#copyUserTokenByUserId(EOS_RTCAdmin_CopyUserTokenByUserIdOptions)
	 */
	public int QueryId;
	/** How many token received as result of the query */
	public int TokenCount;

	public EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo() {
		super();
	}

	public EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo implements Structure.ByValue {
	}
}
