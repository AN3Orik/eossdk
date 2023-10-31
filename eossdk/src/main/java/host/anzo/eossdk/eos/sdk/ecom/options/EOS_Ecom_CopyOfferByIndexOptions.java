package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyOfferByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OfferIndex"})
public class EOS_Ecom_CopyOfferByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyOfferByIndex API. */
	public static final int EOS_ECOM_COPYOFFERBYINDEX_API_LATEST = 3;

	/** API Version: Set this to EOS_ECOM_COPYOFFERBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose offer is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** The index of the offer to get. */
	public int OfferIndex;

	public EOS_Ecom_CopyOfferByIndexOptions() {
		super();
	}

	public EOS_Ecom_CopyOfferByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyOfferByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyOfferByIndexOptions implements Structure.ByValue {
	}
}