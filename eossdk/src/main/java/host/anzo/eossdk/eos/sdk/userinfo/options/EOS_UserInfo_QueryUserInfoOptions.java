package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_QueryUserInfo function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_UserInfo_QueryUserInfoOptions extends Structure {
	public static final int EOS_USERINFO_QUERYUSERINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_USERINFO_QUERYUSERINFO_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the player whose information is being retrieved */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UserInfo_QueryUserInfoOptions() {
		super();
		ApiVersion = EOS_USERINFO_QUERYUSERINFO_API_LATEST;
	}

	public EOS_UserInfo_QueryUserInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_QueryUserInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_QueryUserInfoOptions implements Structure.ByValue {
	}
}
