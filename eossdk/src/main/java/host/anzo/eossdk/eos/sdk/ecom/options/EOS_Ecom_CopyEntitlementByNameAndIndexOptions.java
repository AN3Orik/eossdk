package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyEntitlementByNameAndIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementName", "Index"})
public class EOS_Ecom_CopyEntitlementByNameAndIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyEntitlementByNameAndIndex API. */
	public static final int EOS_ECOM_COPYENTITLEMENTBYNAMEANDINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYENTITLEMENTBYNAMEANDINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose entitlement is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** Name of the entitlement to retrieve from the cache */
	public String EntitlementName;
	/** Index of the entitlement within the named set to retrieve from the cache. */
	public int Index;

	public EOS_Ecom_CopyEntitlementByNameAndIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYENTITLEMENTBYNAMEANDINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyEntitlementByNameAndIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyEntitlementByNameAndIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyEntitlementByNameAndIndexOptions implements Structure.ByValue {
	}
}