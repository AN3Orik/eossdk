package host.anzo.eossdk.eos.sdk.userinfo.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UserInfo_QueryUserInfoByDisplayName Function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId", "DisplayName"})
public class EOS_UserInfo_QueryUserInfoByDisplayNameCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UserInfo_QueryUserInfoByDisplayName */
	public Pointer ClientData;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the player whose information is being retrieved */
	public EOS_EpicAccountId TargetUserId;
	/** Display name (un-sanitized) of the player being queried. This memory is only valid during the scope of the callback. */
	public String DisplayName;

	public EOS_UserInfo_QueryUserInfoByDisplayNameCallbackInfo() {
		super();
	}

	public EOS_UserInfo_QueryUserInfoByDisplayNameCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_QueryUserInfoByDisplayNameCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_QueryUserInfoByDisplayNameCallbackInfo implements Structure.ByValue {
	}
}