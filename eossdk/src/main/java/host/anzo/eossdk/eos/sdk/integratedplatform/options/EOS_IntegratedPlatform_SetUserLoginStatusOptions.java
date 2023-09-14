package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_IntegratedPlatform_SetUserLoginStatus function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "PlatformType", "LocalPlatformUserId", "CurrentLoginStatus"})
public class EOS_IntegratedPlatform_SetUserLoginStatusOptions extends Structure {
	public static final int EOS_INTEGRATEDPLATFORM_SETUSERLOGINSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_INTEGRATEDPLATFORM_SETUSERLOGINSTATUS_API_LATEST. */
	public int ApiVersion;
	/** The integrated platform this user belongs to. */
	public String PlatformType;
	/** String version of the integrated platform-dependent user id. */
	public String LocalPlatformUserId;

	/**
	 * The login status of the provided user
	 * @see EOS_ELoginStatus
	 */
	public EOS_ELoginStatus CurrentLoginStatus;

	public EOS_IntegratedPlatform_SetUserLoginStatusOptions() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_SETUSERLOGINSTATUS_API_LATEST;
	}

	public EOS_IntegratedPlatform_SetUserLoginStatusOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_SetUserLoginStatusOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_SetUserLoginStatusOptions implements Structure.ByValue {
	}
}