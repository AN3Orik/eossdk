package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Contains information about a request to purchase a single offer.  This structure is set as part
 * of the EOS_Ecom_CheckoutOptions structure.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_Ecom_CheckoutEntry extends Structure {
	/** The most recent version of the EOS_Ecom_CheckoutEntry struct. */
	public static final int EOS_ECOM_CHECKOUTENTRY_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ECOM_CHECKOUTENTRY_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the offer to purchase */
	public String OfferId;

	public EOS_Ecom_CheckoutEntry() {
		super();
		ApiVersion = EOS_ECOM_CHECKOUTENTRY_API_LATEST;
	}

	public EOS_Ecom_CheckoutEntry(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CheckoutEntry implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CheckoutEntry implements Structure.ByValue {
	}
}