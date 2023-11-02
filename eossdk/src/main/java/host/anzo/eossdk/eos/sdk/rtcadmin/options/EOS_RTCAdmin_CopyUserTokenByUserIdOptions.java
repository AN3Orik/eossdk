package host.anzo.eossdk.eos.sdk.rtcadmin.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAdmin_CopyUserTokenByUserId function.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "QueryId"})
public class EOS_RTCAdmin_CopyUserTokenByUserIdOptions extends Structure {
	/** The most recent version of the EOS_RTCAdmin_CopyUserTokenByUserIdOptions struct. */
	public static final int EOS_RTCADMIN_COPYUSERTOKENBYUSERID_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_RTCADMIN_COPYUSERTOKENBYUSERID_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID for the user whose user token we're copying. */
	public EOS_ProductUserId TargetUserId;
	/**
	 * Query identifier received as part of a previous query.
	 * @see EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo
	 */
	public int QueryId;

	public EOS_RTCAdmin_CopyUserTokenByUserIdOptions() {
		super();
		ApiVersion = EOS_RTCADMIN_COPYUSERTOKENBYUSERID_API_LATEST;
	}

	public EOS_RTCAdmin_CopyUserTokenByUserIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_CopyUserTokenByUserIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_CopyUserTokenByUserIdOptions implements Structure.ByValue {
	}
}