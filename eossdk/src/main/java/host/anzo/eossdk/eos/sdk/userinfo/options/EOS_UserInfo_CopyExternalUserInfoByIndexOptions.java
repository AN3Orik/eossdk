package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_CopyExternalUserInfoByIndex function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId", "Index"})
public class EOS_UserInfo_CopyExternalUserInfoByIndexOptions extends Structure {
	/** The most recent version of the EOS_UserInfo_CopyExternalUserInfoByIndexOptions struct. */
	public static final int EOS_USERINFO_COPYEXTERNALUSERINFOBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_USERINFO_COPYEXTERNALUSERINFOBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the player whose information is being retrieved */
	public EOS_EpicAccountId TargetUserId;
	/** Index of the external user info to retrieve from the cache */
	public int Index;

	public EOS_UserInfo_CopyExternalUserInfoByIndexOptions() {
		super();
		ApiVersion = EOS_USERINFO_COPYEXTERNALUSERINFOBYINDEX_API_LATEST;
	}

	public EOS_UserInfo_CopyExternalUserInfoByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_CopyExternalUserInfoByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_CopyExternalUserInfoByIndexOptions implements Structure.ByValue {
	}
}
