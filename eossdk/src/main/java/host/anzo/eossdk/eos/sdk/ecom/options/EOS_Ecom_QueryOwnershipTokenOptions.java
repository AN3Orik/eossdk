package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryOwnershipToken function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "CatalogItemIds", "CatalogItemIdCount", "CatalogNamespace"})
public class EOS_Ecom_QueryOwnershipTokenOptions extends Structure {
	/** The most recent version of the EOS_Ecom_QueryOwnershipToken API. */
	public static final int EOS_ECOM_QUERYOWNERSHIPTOKEN_API_LATEST = 2;

	/** The maximum number of catalog items that may be queried in a single pass */
	public static final int EOS_ECOM_QUERYOWNERSHIPTOKEN_MAX_CATALOGITEM_IDS = 32;

	/** API Version: Set this to EOS_ECOM_QUERYOWNERSHIPTOKEN_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose ownership token you want to query */
	public EOS_EpicAccountId LocalUserId;
	/** The array of Catalog Item IDs to check for ownership, matching in number to the CatalogItemIdCount */
	public StringArray CatalogItemIds;
	/** The number of catalog item IDs to query */
	public int CatalogItemIdCount;
	/** Optional product namespace, if not the one specified during initialization */
	public String CatalogNamespace;

	public EOS_Ecom_QueryOwnershipTokenOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYOWNERSHIPTOKEN_API_LATEST;
	}

	public EOS_Ecom_QueryOwnershipTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipTokenOptions implements Structure.ByValue {
	}
}
