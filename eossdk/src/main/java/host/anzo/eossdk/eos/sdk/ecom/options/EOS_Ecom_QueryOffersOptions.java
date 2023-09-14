package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryOffers function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OverrideCatalogNamespace"})
public class EOS_Ecom_QueryOffersOptions extends Structure {
	public static final int EOS_ECOM_QUERYOFFERS_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_QUERYOFFERS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose offer to query */
	public EOS_EpicAccountId LocalUserId;
	/** If not provided then the SandboxId is used as the catalog namespace */
	public String OverrideCatalogNamespace;

	public EOS_Ecom_QueryOffersOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYOFFERS_API_LATEST;
	}

	public EOS_Ecom_QueryOffersOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOffersOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOffersOptions implements Structure.ByValue {
	}
}