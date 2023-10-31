package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyOfferImageInfoByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OfferId", "ImageInfoIndex"})
public class EOS_Ecom_CopyOfferImageInfoByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyOfferImageInfoByIndex API. */
	public static final int EOS_ECOM_COPYOFFERIMAGEINFOBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYOFFERIMAGEINFOBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose offer image is being copied. */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the offer to get the images for. */
	public String OfferId;
	/** The index of the image to get. */
	public int ImageInfoIndex;

	public EOS_Ecom_CopyOfferImageInfoByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYOFFERIMAGEINFOBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyOfferImageInfoByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyOfferImageInfoByIndexOptions implements Structure.ByReference {
	}
	public static class ByValue extends EOS_Ecom_CopyOfferImageInfoByIndexOptions implements Structure.ByValue {
	}
}