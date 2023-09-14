package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetEntitlementsCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Ecom_GetEntitlementsCountOptions extends Structure {
	public static final int EOS_ECOM_GETENTITLEMENTSCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETENTITLEMENTSCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user for which to retrieve the entitlement count */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Ecom_GetEntitlementsCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETENTITLEMENTSCOUNT_API_LATEST;
	}

	public EOS_Ecom_GetEntitlementsCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetEntitlementsCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetEntitlementsCountOptions implements Structure.ByValue {
	}
}