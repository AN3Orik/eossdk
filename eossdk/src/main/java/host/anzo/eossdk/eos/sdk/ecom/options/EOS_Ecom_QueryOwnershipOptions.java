package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryOwnership function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "CatalogItemIds", "CatalogItemIdCount", "CatalogNamespace"})
public class EOS_Ecom_QueryOwnershipOptions extends Structure {
	public static final int EOS_ECOM_QUERYOWNERSHIP_API_LATEST = 2;

	/**
	 * The maximum number of catalog items that may be queried in a single pass
	 */
	public static final int EOS_ECOM_QUERYOWNERSHIP_MAX_CATALOG_IDS = 400;

	/** API Version: Set this to EOS_ECOM_QUERYOWNERSHIP_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose ownership to query */
	public EOS_EpicAccountId LocalUserId;
	/** The array of Catalog Item IDs to check for ownership */
	public StringArray CatalogItemIds;
	/** The number of Catalog Item IDs to in the array */
	public int CatalogItemIdCount;
	/** Optional product namespace, if not the one specified during initialization */
	public String CatalogNamespace;

	public EOS_Ecom_QueryOwnershipOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYOWNERSHIP_API_LATEST;
	}

	public EOS_Ecom_QueryOwnershipOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipOptions implements Structure.ByValue {
	}
}