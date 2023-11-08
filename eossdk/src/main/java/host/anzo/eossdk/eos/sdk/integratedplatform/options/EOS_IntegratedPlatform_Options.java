package host.anzo.eossdk.eos.sdk.integratedplatform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.integratedplatform.enums.EOS_EIntegratedPlatformManagementFlags;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_IntegratedPlatformOptionsContainer_Add function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "Type", "Flags", "InitOptions"})
public class EOS_IntegratedPlatform_Options extends Structure {
	/** The most recent version of the EOS_IntegratedPlatform_Options API. */
	public static final int EOS_INTEGRATEDPLATFORM_OPTIONS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_INTEGRATEDPLATFORM_OPTIONS_API_LATEST}. */
	public int ApiVersion;
	/** The type to be initialized. */
	public String Type;
	/**
	 * Identifies how to initialize the IntegratedPlatform.
	 */
	public EOS_EIntegratedPlatformManagementFlags Flags;
	/**
	 * Options specific to this integrated platform type.
	 * This parameter is either required or set to NULL based on the platform type.
	 *
	 * @see EOS_IntegratedPlatform_Steam_Options
	 */
	public Pointer InitOptions;

	public EOS_IntegratedPlatform_Options() {
		super();
		ApiVersion = EOS_INTEGRATEDPLATFORM_OPTIONS_API_LATEST;
	}

	public EOS_IntegratedPlatform_Options(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_Options implements Structure.ByValue {
	}
}