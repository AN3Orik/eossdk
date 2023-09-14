package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_QueryUserInfoByExternalAccount function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ExternalAccountId", "AccountType"})
public class EOS_UserInfo_QueryUserInfoByExternalAccountOptions extends Structure {
	public static final int EOS_USERINFO_QUERYUSERINFOBYEXTERNALACCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_USERINFO_QUERYUSERINFOBYEXTERNALACCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** External account ID of the user whose information is being retrieved */
	public String ExternalAccountId;
	/** Account type of the external user info to query */
	public EOS_EExternalAccountType AccountType;

	public EOS_UserInfo_QueryUserInfoByExternalAccountOptions() {
		super();
		ApiVersion = EOS_USERINFO_QUERYUSERINFOBYEXTERNALACCOUNT_API_LATEST;
	}

	public EOS_UserInfo_QueryUserInfoByExternalAccountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_QueryUserInfoByExternalAccountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_QueryUserInfoByExternalAccountOptions implements Structure.ByValue {
	}
}