package host.anzo.eossdk.eos.sdk.rtcadmin.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAdmin_CopyUserTokenByIndex function.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "UserTokenIndex", "QueryId"})
public class EOS_RTCAdmin_CopyUserTokenByIndexOptions extends Structure {
	/** The most recent version of the EOS_RTCAdmin_CopyUserTokenByIndexOptions struct. */
	public static final int EOS_RTCADMIN_COPYUSERTOKENBYINDEX_API_LATEST = 2;

	/** API Version: Set this to EOS_RTCADMIN_COPYUSERTOKENBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Index of the user token to retrieve from the cache. */
	public int UserTokenIndex;
	/**
	 * Query identifier received as part of a previous query.
	 * @see EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo
	 */
	public int QueryId;

	public EOS_RTCAdmin_CopyUserTokenByIndexOptions() {
		super();
		ApiVersion = EOS_RTCADMIN_COPYUSERTOKENBYINDEX_API_LATEST;
	}

	public EOS_RTCAdmin_CopyUserTokenByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_CopyUserTokenByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_CopyUserTokenByIndexOptions implements Structure.ByValue {
	}
}