package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryEntitlements function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementNames", "EntitlementNameCount", "IsIncludeRedeemed"})
public class EOS_Ecom_QueryEntitlementsOptions extends Structure {
	public static final int EOS_ECOM_QUERYENTITLEMENTS_API_LATEST = 2;

	/**
	 * The maximum number of entitlements that may be queried in a single QueryEntitlements API call.
	 */
	public static final int EOS_ECOM_QUERYENTITLEMENTS_MAX_ENTITLEMENT_IDS = 256;

	/** API Version: Set this to EOS_ECOM_QUERYENTITLEMENTS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose Entitlements you want to retrieve */
	public EOS_EpicAccountId LocalUserId;
	/** An array of Entitlement Names that you want to check */
	public StringArray EntitlementNames;
	/** The number of Entitlement Names included in the array, up to EOS_ECOM_QUERYENTITLEMENTS_MAX_ENTITLEMENT_IDS; use zero to request all Entitlements associated with the user's Epic Online Services account. */
	public int EntitlementNameCount;
	/** If true, Entitlements that have been redeemed will be included in the results. */
	public EOS_Bool IsIncludeRedeemed;

	public EOS_Ecom_QueryEntitlementsOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYENTITLEMENTS_API_LATEST;
	}

	public EOS_Ecom_QueryEntitlementsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryEntitlementsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryEntitlementsOptions implements Structure.ByValue {
	}
}