package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_QueryUserInfoByDisplayName function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "DisplayName"})
public class EOS_UserInfo_QueryUserInfoByDisplayNameOptions extends Structure {
	/** The most recent version of the EOS_UserInfo_QueryUserInfoByDisplayName API. */
	public static final int EOS_USERINFO_QUERYUSERINFOBYDISPLAYNAME_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_USERINFO_QUERYUSERINFOBYDISPLAYNAME_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** Raw display name (un-sanitized) of the player being queried */
	public String DisplayName;

	public EOS_UserInfo_QueryUserInfoByDisplayNameOptions() {
		super();
		ApiVersion = EOS_USERINFO_QUERYUSERINFOBYDISPLAYNAME_API_LATEST;
	}

	public EOS_UserInfo_QueryUserInfoByDisplayNameOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_QueryUserInfoByDisplayNameOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_QueryUserInfoByDisplayNameOptions implements Structure.ByValue {
	}
}