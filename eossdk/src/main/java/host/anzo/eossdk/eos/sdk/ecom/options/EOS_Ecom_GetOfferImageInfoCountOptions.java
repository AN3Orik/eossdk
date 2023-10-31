package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetOfferImageInfoCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OfferId"})
public class EOS_Ecom_GetOfferImageInfoCountOptions extends Structure {
	/** The most recent version of the EOS_Ecom_GetOfferImageInfoCount API. */
	public static final int EOS_ECOM_GETOFFERIMAGEINFOCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETOFFERIMAGEINFOCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose offer image is being accessed. */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the offer to get the images for. */
	public String OfferId;

	public EOS_Ecom_GetOfferImageInfoCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETOFFERIMAGEINFOCOUNT_API_LATEST;
	}

	public EOS_Ecom_GetOfferImageInfoCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetOfferImageInfoCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetOfferImageInfoCountOptions implements Structure.ByValue {
	}
}