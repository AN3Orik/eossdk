package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_CopyExternalUserInfoByAccountType function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId", "AccountType"})
public class EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions extends Structure {
	/** The most recent version of the EOS_UserInfo_CopyExternalUserInfoByIndexOptions struct. */
	public static final int EOS_USERINFO_COPYEXTERNALUSERINFOBYACCOUNTTYPE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_USERINFO_COPYEXTERNALUSERINFOBYACCOUNTTYPE_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the player whose information is being retrieved */
	public EOS_EpicAccountId TargetUserId;
	/** Account type of the external user info to retrieve from the cache */
	public EOS_EExternalAccountType AccountType;

	public EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions() {
		super();
		ApiVersion = EOS_USERINFO_COPYEXTERNALUSERINFOBYACCOUNTTYPE_API_LATEST;
	}

	public EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions implements Structure.ByValue {
	}
}