package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyLastRedeemedEntitlementByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RedeemedEntitlementIndex"})
public class EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyLastRedeemedEntitlementByIndex API. */
	public static final int EOS_ECOM_COPYLASTREDEEMEDENTITLEMENTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYLASTREDEEMEDENTITLEMENTBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose last redeemed entitlement id is being copied */
	public EOS_EpicAccountId LocalUserId;

	/** Index of the last redeemed entitlement id to retrieve from the cache */
	public int RedeemedEntitlementIndex;

	public EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYLASTREDEEMEDENTITLEMENTBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions implements Structure.ByValue {
	}
}
