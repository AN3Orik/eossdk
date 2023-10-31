package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.integratedplatform.EOS_IntegratedPlatformOptionsContainer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the {@link EOS_IntegratedPlatformOptionsContainer#add(EOS_IntegratedPlatformOptionsContainer_AddOptions)} function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "Options"})
public class EOS_IntegratedPlatformOptionsContainer_AddOptions extends Structure {
	/** The most recent version of the EOS_IntegratedPlatformOptionsContainer_Add API. */
	public static final int EOS_INTEGRATEDPLATFORMOPTIONSCONTAINER_ADD_API_LATEST = 1;

	/** API Version: Set this to EOS_INTEGRATEDPLATFORMOPTIONSCONTAINER_ADD_API_LATEST. */
	public int ApiVersion;
	/** The integrated platform options to add. */
	public EOS_IntegratedPlatform_Options.ByReference Options;

	public EOS_IntegratedPlatformOptionsContainer_AddOptions() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORMOPTIONSCONTAINER_ADD_API_LATEST;
	}

	public EOS_IntegratedPlatformOptionsContainer_AddOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatformOptionsContainer_AddOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatformOptionsContainer_AddOptions implements Structure.ByValue {
	}
}