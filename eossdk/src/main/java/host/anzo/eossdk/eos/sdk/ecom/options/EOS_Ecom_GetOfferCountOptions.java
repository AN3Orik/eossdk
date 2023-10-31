package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetOfferCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Ecom_GetOfferCountOptions extends Structure {
	/** The most recent version of the EOS_Ecom_GetOfferCount API. */
	public static final int EOS_ECOM_GETOFFERCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETOFFERCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose offers are being accessed */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Ecom_GetOfferCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETOFFERCOUNT_API_LATEST;
	}

	public EOS_Ecom_GetOfferCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetOfferCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetOfferCountOptions implements Structure.ByValue {
	}
}