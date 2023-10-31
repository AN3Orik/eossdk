package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyEntitlementById function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementId"})
public class EOS_Ecom_CopyEntitlementByIdOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyEntitlementById API. */
	public static final int EOS_ECOM_COPYENTITLEMENTBYID_API_LATEST = 2;

	/** API Version: Set this to EOS_ECOM_COPYENTITLEMENTBYID_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose entitlement is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** ID of the entitlement to retrieve from the cache */
	public String EntitlementId;

	public EOS_Ecom_CopyEntitlementByIdOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYENTITLEMENTBYID_API_LATEST;
	}
	public EOS_Ecom_CopyEntitlementByIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyEntitlementByIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyEntitlementByIdOptions implements Structure.ByValue {
	}
}