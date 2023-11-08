package host.anzo.eossdk.eos.sdk.userinfo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains the user information. These structures are created by EOS_UserInfo_CopyUserInfo and must be passed to EOS_UserInfo_Release.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "UserId", "Country", "DisplayName", "PreferredLanguage", "Nickname", "DisplayNameSanitized"})
public class EOS_UserInfo extends Structure implements AutoCloseable {
	/** The maximum length of display names, in displayable characters */
	public static int EOS_USERINFO_MAX_DISPLAYNAME_CHARACTERS = 16;

	/** The maximum length of display names when encoded as UTF-8 as returned by EOS_UserInfo_CopyUserInfo. This length does not include the null terminator. */
	public static int EOS_USERINFO_MAX_DISPLAYNAME_UTF8_LENGTH = 64;

	/** The most recent version of the EOS_UserInfo_CopyUserInfo API. */
	public static int EOS_USERINFO_COPYUSERINFO_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_USERINFO_COPYUSERINFO_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the user */
	public EOS_EpicAccountId UserId;
	/** The name of the owner's country. This may be null */
	public String Country;
	/** The display name (un-sanitized). This may be null */
	public String DisplayName;
	/** The ISO 639 language code for the user's preferred language. This may be null */
	public String PreferredLanguage;
	/** A nickname/alias for the target user assigned by the local user. This may be null */
	public String Nickname;
	/** The raw display name (sanitized). This may be null */
	public String DisplayNameSanitized;

	public EOS_UserInfo() {
		super();
		ApiVersion = EOS_USERINFO_COPYUSERINFO_API_LATEST;
	}

	public EOS_UserInfo(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_UserInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_UserInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo implements Structure.ByValue {
	}
}