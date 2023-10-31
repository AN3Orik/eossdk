package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_Transaction_CopyEntitlementByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "EntitlementIndex"})
public class EOS_Ecom_Transaction_CopyEntitlementByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_Transaction_CopyEntitlementByIndex Function. */
	public static final int EOS_ECOM_TRANSACTION_COPYENTITLEMENTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_TRANSACTION_COPYENTITLEMENTBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The index of the entitlement to get */
	public int EntitlementIndex;

	public EOS_Ecom_Transaction_CopyEntitlementByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_TRANSACTION_COPYENTITLEMENTBYINDEX_API_LATEST;
	}

	public EOS_Ecom_Transaction_CopyEntitlementByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_Transaction_CopyEntitlementByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_Transaction_CopyEntitlementByIndexOptions implements Structure.ByValue {
	}
}