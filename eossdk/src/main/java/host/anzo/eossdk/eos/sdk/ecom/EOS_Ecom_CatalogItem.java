package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.ecom.enums.EOS_EEcomItemType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single item within the catalog. Instances of this structure are created
 * by {@link EOS_Ecom_Interface#copyOfferItemByIndex(EOS_Ecom_CopyOfferItemByIndexOptions, EOS_Ecom_CatalogItem[])}.<br>
 * They must be passed to {@link EOS_Ecom_CatalogItem#release()}
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "CatalogNamespace", "Id", "EntitlementName", "TitleText", "DescriptionText", "LongDescriptionText", "TechnicalDetailsText", "DeveloperText", "ItemType", "EntitlementEndTimestamp"})
public class EOS_Ecom_CatalogItem extends Structure implements AutoCloseable {
	public static final int EOS_ECOM_CATALOGITEM_API_LATEST = 1;

	/** Timestamp value representing an undefined EntitlementEndTimestamp for EOS_Ecom_CatalogItem */
	public static final int EOS_ECOM_CATALOGITEM_ENTITLEMENTENDTIMESTAMP_UNDEFINED = -1;

	/** API Version: Set this to EOS_ECOM_CATALOGITEM_API_LATEST. */
	public int ApiVersion;
	/** Product namespace in which this item exists */
	public String CatalogNamespace;
	/** The ID of this item */
	public String Id;
	/** The entitlement name associated with this item */
	public String EntitlementName;
	/** Localized UTF-8 title of this item */
	public String TitleText;
	/** Localized UTF-8 description of this item */
	public String DescriptionText;
	/** Localized UTF-8 long description of this item */
	public String LongDescriptionText;
	/** Localized UTF-8 technical details of this item */
	public String TechnicalDetailsText;
	/** Localized UTF-8 developer of this item */
	public String DeveloperText;
	/**
	 * The type of item as defined in the catalog
	 */
	public EOS_EEcomItemType ItemType;
	/** If not -1 then this is the POSIX timestamp that the entitlement will end */
	public long EntitlementEndTimestamp;

	public EOS_Ecom_CatalogItem() {
		super();
		ApiVersion = EOS_ECOM_CATALOGITEM_API_LATEST;
	}

	public EOS_Ecom_CatalogItem(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Ecom_CatalogItem_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_CatalogItem implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CatalogItem implements Structure.ByValue {
	}
}