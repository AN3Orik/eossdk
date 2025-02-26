package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.ecom.EOS_Ecom_CheckoutEntry;
import host.anzo.eossdk.eos.sdk.ecom.enums.EOS_ECheckoutOrientation;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_Checkout function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "OverrideCatalogNamespace", "EntryCount", "Entries"})
public class EOS_Ecom_CheckoutOptions extends Structure {
	/** The most recent version of the EOS_Ecom_Checkout API. */
	public static final int EOS_ECOM_CHECKOUT_API_LATEST = 2;

	/** The maximum number of entries in a single checkout. */
	public static final int EOS_ECOM_CHECKOUT_MAX_ENTRIES = 10;

	/** The maximum length of a transaction ID. */
	public static final int EOS_ECOM_TRANSACTIONID_MAXIMUM_LENGTH = 64;

	/** API Version: Set this to EOS_ECOM_CHECKOUT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user who is making the purchase */
	public EOS_EpicAccountId LocalUserId;
	/** The catalog namespace will be the current Sandbox ID (in EOS_Platform_Options) unless overridden by this field */
	public String OverrideCatalogNamespace;
	/** The number of EOS_Ecom_CheckoutEntry elements contained in Entries */
	public int EntryCount;
	/** An array of EOS_Ecom_CheckoutEntry elements, each containing the details of a single offer */
	public EOS_Ecom_CheckoutEntry[] Entries;
	/**
	 * Preferred device orientation, specifies Default, Portrait or Landscape.
	 * This is used only on mobile platforms currently.
	 * SDK can use it to optimize how the Checkout page should be displayed.
	 * Please check the mobile SDK documentation for additional required setup.
	 */
	public EOS_ECheckoutOrientation PreferredOrientation;

	public EOS_Ecom_CheckoutOptions() {
		super();
		ApiVersion = EOS_ECOM_CHECKOUT_API_LATEST;
	}

	public EOS_Ecom_CheckoutOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CheckoutOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CheckoutOptions implements Structure.ByValue {
	}
}