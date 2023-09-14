package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyOfferItemByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OfferId", "ItemIndex"})
public class EOS_Ecom_CopyOfferItemByIndexOptions extends Structure {
	public static final int EOS_ECOM_COPYOFFERITEMBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYOFFERITEMBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose item is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the offer to get the items for. */
	public String OfferId;
	/** The index of the item to get. */
	public int ItemIndex;

	public EOS_Ecom_CopyOfferItemByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYOFFERITEMBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyOfferItemByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyOfferItemByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyOfferItemByIndexOptions implements Structure.ByValue {
	}
}