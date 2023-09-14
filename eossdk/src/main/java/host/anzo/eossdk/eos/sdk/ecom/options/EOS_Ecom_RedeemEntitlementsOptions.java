package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_RedeemEntitlements function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EntitlementIdCount", "EntitlementIds"})
public class EOS_Ecom_RedeemEntitlementsOptions extends Structure {
	public static final int EOS_ECOM_REDEEMENTITLEMENTS_API_LATEST = 2;

	/**
	 * The maximum number of entitlement IDs that may be redeemed in a single pass
	 */
	public static final int EOS_ECOM_REDEEMENTITLEMENTS_MAX_IDS = 32;

	/**
	 * The maximum length of an entitlement ID
	 */
	public static final int EOS_ECOM_ENTITLEMENTID_MAX_LENGTH = 32;

	/** API Version: Set this to EOS_ECOM_REDEEMENTITLEMENTS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user who is redeeming Entitlements */
	public EOS_EpicAccountId LocalUserId;
	/** The number of Entitlements to redeem */
	public int EntitlementIdCount;
	/** The array of Entitlements to redeem */
	public StringArray EntitlementIds;

	public EOS_Ecom_RedeemEntitlementsOptions() {
		super();
		ApiVersion = EOS_ECOM_REDEEMENTITLEMENTS_API_LATEST;
	}

	public EOS_Ecom_RedeemEntitlementsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_RedeemEntitlementsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_RedeemEntitlementsOptions implements Structure.ByValue {
	}
}