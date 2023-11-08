package host.anzo.eossdk.eos.sdk.userinfo.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UserInfo_GetLocalPlatformType function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_UserInfo_GetLocalPlatformTypeOptions extends Structure {
	/** The most recent version of the EOS_UserInfo_GetLocalPlatformType API. */
	public static final int EOS_USERINFO_GETLOCALPLATFORMTYPE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_USERINFO_GETLOCALPLATFORMTYPE_API_LATEST}. */
	public int ApiVersion;

	public EOS_UserInfo_GetLocalPlatformTypeOptions() {
		super();
		ApiVersion = EOS_USERINFO_GETLOCALPLATFORMTYPE_API_LATEST;
	}

	public EOS_UserInfo_GetLocalPlatformTypeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_GetLocalPlatformTypeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_GetLocalPlatformTypeOptions implements Structure.ByValue {
	}
}