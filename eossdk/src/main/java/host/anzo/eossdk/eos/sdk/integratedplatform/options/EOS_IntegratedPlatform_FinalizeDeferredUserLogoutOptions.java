package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_IntegratedPlatform_FinalizeDeferredUserLogout function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "PlatformType", "LocalPlatformUserId", "ExpectedLoginStatus"})
public class EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions extends Structure {
	public static final int EOS_INTEGRATEDPLATFORM_FINALIZEDEFERREDUSERLOGOUT_API_LATEST = 1;

	/** API Version: Set this to EOS_INTEGRATEDPLATFORM_FINALIZEDEFERREDUSERLOGOUT_API_LATEST. */
	public int ApiVersion;
	/** The integrated platform this user belongs to. */
	public String PlatformType;
	/** String version of the integrated platform-dependent user id. */
	public String LocalPlatformUserId;
	/**
	 * The logged-in state the user is expected to be (EOS_LS_LoggedIn or EOS_LS_NotLoggedIn). If the provided
	 * state does not match internal EOS state, this function will return in failure. If the state is incorrect,
	 * the application should wait and attempt to call the function again next tick, after both updating its own
	 * state from the system and calling EOS_Platform_Tick, allowing the SDK to update its state from the system
	 * as well.
	 */
	public EOS_ELoginStatus ExpectedLoginStatus;

	public EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_FINALIZEDEFERREDUSERLOGOUT_API_LATEST;
	}

	public EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions implements Structure.ByValue {
	}
}