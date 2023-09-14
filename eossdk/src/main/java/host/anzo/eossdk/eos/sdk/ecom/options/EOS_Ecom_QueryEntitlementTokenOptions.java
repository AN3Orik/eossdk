package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryEntitlementToken function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementNames", "EntitlementNameCount"})
public class EOS_Ecom_QueryEntitlementTokenOptions extends Structure {
	/** The most recent version of the EOS_Ecom_QueryEntitlementToken API. */
	public static final int EOS_ECOM_QUERYENTITLEMENTTOKEN_API_LATEST = 1;

	/** The maximum number of entitlements that may be queried in a single pass. */
	public static final int EOS_ECOM_QUERYENTITLEMENTTOKEN_MAX_ENTITLEMENT_IDS = 32;

	/** API Version: Set this to EOS_ECOM_QUERYENTITLEMENTTOKEN_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose Entitlements you want to retrieve */
	public EOS_EpicAccountId LocalUserId;
	/** An array of Entitlement Names that you want to check */
	public StringArray EntitlementNames;
	/**
	 * The number of Entitlement Names included in the array, up to {@link EOS_Ecom_QueryEntitlementTokenOptions#EOS_ECOM_QUERYENTITLEMENTTOKEN_MAX_ENTITLEMENT_IDS};<br>
	 * use zero to request all Entitlements associated with the user's Epic Online Services account.
	 */
	public int EntitlementNameCount;

	public EOS_Ecom_QueryEntitlementTokenOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYENTITLEMENTTOKEN_API_LATEST;
	}

	public EOS_Ecom_QueryEntitlementTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryEntitlementTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryEntitlementTokenOptions implements Structure.ByValue {
	}
}
