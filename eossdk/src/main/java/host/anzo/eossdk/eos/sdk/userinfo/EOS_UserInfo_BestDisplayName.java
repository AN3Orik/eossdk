package host.anzo.eossdk.eos.sdk.userinfo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_UserInfo_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_OnlinePlatformType;
import host.anzo.eossdk.eos.sdk.userinfo.options.EOS_UserInfo_CopyBestDisplayNameOptions;
import host.anzo.eossdk.eos.sdk.userinfo.options.EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains the user information. These structures are created by EOS_UserInfo_CopyBestDisplayName or
 * EOS_UserInfo_CopyBestDisplayNameWithPlatform and must be passed to EOS_UserInfo_BestDisplayName_Release.
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "UserId", "DisplayName", "DisplayNameSanitized", "Nickname", "PlatformType"})
public class EOS_UserInfo_BestDisplayName extends Structure implements AutoCloseable {
	public static final int EOS_USERINFO_BESTDISPLAYNAME_API_LATEST = 1;

	/** API Version: Set this to EOS_USERINFO_BESTDISPLAYNAME_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user */
	public EOS_EpicAccountId UserId;
	/** The display name (un-sanitized). This may be null */
	public String DisplayName;
	/** The raw display name (sanitized). This may be null */
	public String DisplayNameSanitized;
	/** A nickname/alias for the target user assigned by the local user. This may be null */
	public String Nickname;
	/** The platform type for the user which corresponds to the display name */
	public EOS_OnlinePlatformType PlatformType;

	public EOS_UserInfo_BestDisplayName() {
		super();
		ApiVersion = EOS_USERINFO_BESTDISPLAYNAME_API_LATEST;
	}

	public EOS_UserInfo_BestDisplayName(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with EOS_UserInfo_BestDisplayName. This must be called on data retrieved from
	 * EOS_UserInfo_CopyBestDisplayNameWithPlatform.
	 * @see EOS_UserInfo_Interface#copyBestDisplayName(EOS_UserInfo_CopyBestDisplayNameOptions)
	 * @see EOS_UserInfo_Interface#copyBestDisplayNameWithPlatform(EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_UserInfo_BestDisplayName_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_UserInfo_BestDisplayName implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_BestDisplayName implements Structure.ByValue {
	}
}