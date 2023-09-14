package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_OnlinePlatformType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_CopyBestDisplayNameWithPlatform function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId", "TargetPlatformType"})
public class EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions extends Structure {
	public static final int EOS_USERINFO_COPYBESTDISPLAYNAMEWITHPLATFORM_API_LATEST = 1;

	/** API Version: Set this to EOS_USERINFO_COPYBESTDISPLAYNAMEWITHPLATFORM_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local player requesting the information */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the player whose information is being retrieved */
	public EOS_EpicAccountId TargetUserId;
	/** The platform type of the player whose information is being retrieved */
	public EOS_OnlinePlatformType TargetPlatformType;

	public EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions() {
		super();
		ApiVersion = EOS_USERINFO_COPYBESTDISPLAYNAMEWITHPLATFORM_API_LATEST;
	}

	public EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions implements Structure.ByValue {
	}
}