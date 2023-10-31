package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyEntitlementByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementIndex"})
public class EOS_Ecom_CopyEntitlementByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyEntitlementByIndex API. */
	public static final int EOS_ECOM_COPYENTITLEMENTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYENTITLEMENTBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose entitlement is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** Index of the entitlement to retrieve from the cache */
	public int EntitlementIndex;

	public EOS_Ecom_CopyEntitlementByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYENTITLEMENTBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyEntitlementByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyEntitlementByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyEntitlementByIndexOptions implements Structure.ByValue {
	}
}