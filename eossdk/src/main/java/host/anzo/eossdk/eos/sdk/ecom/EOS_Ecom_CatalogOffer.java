package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single offer within the catalog. Instances of this structure are
 * created by EOS_Ecom_CopyOfferByIndex. They must be passed to EOS_Ecom_CatalogOffer_Release.
 * Prices are stored in the lowest denomination for the associated currency.  If CurrencyCode is
 * "USD" then a price of 299 represents "$2.99".
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "ServerIndex", "CatalogNamespace", "Id", "TitleText", "DescriptionText", "LongDescriptionText", "TechnicalDetailsText_DEPRECATED", "CurrencyCode", "PriceResult", "OriginalPrice_DEPRECATED", "CurrentPrice_DEPRECATED", "DiscountPercentage", "ExpirationTimestamp", "PurchasedCount_DEPRECATED", "PurchaseLimit", "bAvailableForPurchase", "OriginalPrice64", "CurrentPrice64", "DecimalPoint", "ReleaseDateTimestamp", "EffectiveDateTimestamp"})
public class EOS_Ecom_CatalogOffer extends Structure implements AutoCloseable {
	public static final int EOS_ECOM_CATALOGOFFER_API_LATEST = 5;

	/** Timestamp value representing an undefined ExpirationTimestamp for EOS_Ecom_CatalogOffer */
	public static final int EOS_ECOM_CATALOGOFFER_EXPIRATIONTIMESTAMP_UNDEFINED = -1;
	/** Timestamp value representing an undefined ReleaseDateTimestamp for EOS_Ecom_CatalogOffer */
	public static final int EOS_ECOM_CATALOGOFFER_RELEASEDATETIMESTAMP_UNDEFINED = -1;
	/** Timestamp value representing an undefined EffectiveDateTimestamp for EOS_Ecom_CatalogOffer */
	public static final int EOS_ECOM_CATALOGOFFER_EFFECTIVEDATETIMESTAMP_UNDEFINED = -1;

	/** API Version: Set this to EOS_ECOM_CATALOGOFFER_API_LATEST. */
	public int ApiVersion;
	/**
	 * The index of this offer as it exists on the server.
	 * This is useful for understanding pagination data.
	 */
	public int ServerIndex;
	/** Product namespace in which this offer exists */
	public String CatalogNamespace;
	/** The ID of this offer */
	public String Id;
	/** Localized UTF-8 title of this offer */
	public String TitleText;
	/** Localized UTF-8 description of this offer */
	public String DescriptionText;
	/** Localized UTF-8 long description of this offer */
	public String LongDescriptionText;
	/**
	 * Deprecated.
	 * EOS_Ecom_CatalogItem::TechnicalDetailsText is still valid.
	 */
	public String TechnicalDetailsText_DEPRECATED;
	/** The Currency Code for this offer */
	public String CurrencyCode;
	/**
	 * If this value is EOS_Success then OriginalPrice, CurrentPrice, and DiscountPercentage contain valid data.
	 * Otherwise this value represents the error that occurred on the price query.
	 */
	public EOS_EResult PriceResult;
	/** The original price of this offer as a 32-bit number is deprecated. */
	public int OriginalPrice_DEPRECATED;
	/** The current price including discounts of this offer as a 32-bit number is deprecated.. */
	public int CurrentPrice_DEPRECATED;
	/** A value from 0 to 100 define the percentage of the OrignalPrice that the CurrentPrice represents */
	public byte DiscountPercentage;
	/** Contains the POSIX timestamp that the offer expires or -1 if it does not expire */
	public long ExpirationTimestamp;
	/**
	 * The number of times that the requesting account has purchased this offer.
	 * This value is deprecated and the backend no longer returns this value.
	 */
	public int PurchasedCount_DEPRECATED;
	/**
	 * The maximum number of times that the offer can be purchased.
	 * A negative value implies there is no limit.
	 */
	public int PurchaseLimit;
	/** True if the user can purchase this offer. */
	public int bAvailableForPurchase;
	/** The original price of this offer as a 64-bit number. */
	public long OriginalPrice64;
	/** The current price including discounts of this offer as a 64-bit number. */
	public long CurrentPrice64;
	/** The decimal point for the provided price.  For example, DecimalPoint '2' and CurrentPrice64 '12345' would be '123.45'. */
	public int DecimalPoint;
	/** Timestamp indicating when the time when the offer was released. Can be ignored if set to -1. */
	public long ReleaseDateTimestamp;
	/** Timestamp indicating the effective date of the offer. Can be ignored if set to -1. */
	public long EffectiveDateTimestamp;

	public EOS_Ecom_CatalogOffer() {
		super();
		ApiVersion = EOS_ECOM_CATALOGOFFER_API_LATEST;
	}

	public EOS_Ecom_CatalogOffer(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Ecom_CatalogOffer_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_CatalogOffer implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CatalogOffer implements Structure.ByValue {
	}
}