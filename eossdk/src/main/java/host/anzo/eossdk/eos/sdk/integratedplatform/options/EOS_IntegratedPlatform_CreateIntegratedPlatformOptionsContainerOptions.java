package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer function.
 *
 * @author Anton Lasevich
 * @since 9/11/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions extends Structure {
	/** The most recent version of the EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer API. */
	public static final int EOS_INTEGRATEDPLATFORM_CREATEINTEGRATEDPLATFORMOPTIONSCONTAINER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_INTEGRATEDPLATFORM_CREATEINTEGRATEDPLATFORMOPTIONSCONTAINER_API_LATEST}. */
	public int ApiVersion;

	public EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_CREATEINTEGRATEDPLATFORMOPTIONSCONTAINER_API_LATEST;
	}

	public EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions implements Structure.ByValue {
	}
}