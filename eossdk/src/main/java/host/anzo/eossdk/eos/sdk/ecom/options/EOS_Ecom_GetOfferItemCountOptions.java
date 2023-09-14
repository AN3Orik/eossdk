package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetOfferItemCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OfferId"})
public class EOS_Ecom_GetOfferItemCountOptions extends Structure {
	public static final int EOS_ECOM_GETOFFERITEMCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETOFFERITEMCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user who made the initial request for the Catalog Offer through EOS_Ecom_QueryOffers */
	public EOS_EpicAccountId LocalUserId;
	/** An ID that corresponds to a cached Catalog Offer (retrieved by EOS_Ecom_CopyOfferByIndex) */
	public String OfferId;

	public EOS_Ecom_GetOfferItemCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETOFFERITEMCOUNT_API_LATEST;
	}

	public EOS_Ecom_GetOfferItemCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetOfferItemCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetOfferItemCountOptions implements Structure.ByValue {
	}
}