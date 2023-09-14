package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_IntegratedPlatform_ClearUserPreLogoutCallback function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions extends Structure {
	public static final int EOS_INTEGRATEDPLATFORM_CLEARUSERPRELOGOUTCALLBACK_API_LATEST = 1;

	/** API Version: Set this to EOS_INTEGRATEDPLATFORM_CLEARUSERPRELOGOUTCALLBACK_API_LATEST. */
	public int ApiVersion;

	public EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_CLEARUSERPRELOGOUTCALLBACK_API_LATEST;
	}

	public EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions implements Structure.ByValue {
	}
}