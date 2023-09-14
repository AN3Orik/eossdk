package host.anzo.eossdk.eos.sdk.userinfo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;
import host.anzo.eossdk.eos.sdk.userinfo.options.EOS_UserInfo_CopyExternalUserInfoByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single external user info.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "AccountType", "AccountId", "DisplayName", "DisplayNameSanitized"})
public class EOS_UserInfo_ExternalUserInfo extends Structure implements AutoCloseable {
	public static final int EOS_USERINFO_EXTERNALUSERINFO_API_LATEST = 2;

	/** API Version: Set this to EOS_USERINFO_EXTERNALUSERINFO_API_LATEST. */
	public int ApiVersion;
	/** The type of the external account */
	public EOS_EExternalAccountType AccountType;
	/** The ID of the external account. Can be null */
	public String AccountId;
	/** The display name of the external account (un-sanitized). Can be null */
	public String DisplayName;
	/** The display name of the external account (sanitized). Can be null */
	public String DisplayNameSanitized;

	public EOS_UserInfo_ExternalUserInfo() {
		super();
		ApiVersion = EOS_USERINFO_EXTERNALUSERINFO_API_LATEST;
	}

	public EOS_UserInfo_ExternalUserInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with external user info. This must be called on data retrieved from
	 * EOS_UserInfo_CopyExternalUserInfoByIndexOptions.
	 * @see EOS_UserInfo_ExternalUserInfo
	 * @see host.anzo.eossdk.eos.sdk.EOS_UserInfo_Interface#copyExternalUserInfoByIndex(EOS_UserInfo_CopyExternalUserInfoByIndexOptions, EOS_UserInfo_ExternalUserInfo[])
	 */
	public void release() {
		EOSLibrary.instance.EOS_UserInfo_ExternalUserInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_UserInfo_ExternalUserInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_ExternalUserInfo implements Structure.ByValue {
	}
}