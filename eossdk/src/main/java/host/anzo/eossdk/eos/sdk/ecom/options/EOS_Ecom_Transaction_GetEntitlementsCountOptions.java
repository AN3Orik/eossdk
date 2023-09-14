package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_Transaction_GetEntitlementsCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Ecom_Transaction_GetEntitlementsCountOptions extends Structure {
	public static final int EOS_ECOM_TRANSACTION_GETENTITLEMENTSCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_TRANSACTION_GETENTITLEMENTSCOUNT_API_LATEST. */
	public int ApiVersion;

	public EOS_Ecom_Transaction_GetEntitlementsCountOptions() {
		super();
		ApiVersion = EOS_ECOM_TRANSACTION_GETENTITLEMENTSCOUNT_API_LATEST;
	}

	public EOS_Ecom_Transaction_GetEntitlementsCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_Transaction_GetEntitlementsCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_Transaction_GetEntitlementsCountOptions implements Structure.ByValue {
	}
}