package host.anzo.eossdk.eos.sdk.rtcadmin;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcadmin.options.EOS_RTCAdmin_CopyUserTokenByIndexOptions;
import host.anzo.eossdk.eos.sdk.rtcadmin.options.EOS_RTCAdmin_CopyUserTokenByUserIdOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a collection of user tokens for joining a room.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "ProductUserId", "Token"})
public class EOS_RTCAdmin_UserToken extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_RTCAdmin_UserToken struct. */
	public static final int EOS_RTCADMIN_USERTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_RTCADMIN_USERTOKEN_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID for the user who owns this user token. */
	public EOS_ProductUserId ProductUserId;
	/** Access token to enable a user to join a room */
	public String Token;

	public EOS_RTCAdmin_UserToken() {
		super();
		ApiVersion = EOS_RTCADMIN_USERTOKEN_API_LATEST;
	}

	public EOS_RTCAdmin_UserToken(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with EOS_RTCAdmin_UserToken. This must be called on data retrieved from
	 * EOS_RTCAdmin_CopyUserTokenByIndex or EOS_RTCAdmin_CopyUserTokenByUserId.
	 *
	 * @see EOS_RTCAdmin_UserToken
	 * @see host.anzo.eossdk.eos.sdk.EOS_RTC_Admin_Interface#copyUserTokenByIndex(EOS_RTCAdmin_CopyUserTokenByIndexOptions)
	 * @see host.anzo.eossdk.eos.sdk.EOS_RTC_Admin_Interface#copyUserTokenByUserId(EOS_RTCAdmin_CopyUserTokenByUserIdOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_RTCAdmin_UserToken_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_RTCAdmin_UserToken implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_UserToken implements Structure.ByValue {
	}
}