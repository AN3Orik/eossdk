package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetTransactionCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Ecom_GetTransactionCountOptions extends Structure {
	public static final int EOS_ECOM_GETTRANSACTIONCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETTRANSACTIONCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose transaction count to get */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Ecom_GetTransactionCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETTRANSACTIONCOUNT_API_LATEST;
	}

	public EOS_Ecom_GetTransactionCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetTransactionCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetTransactionCountOptions implements Structure.ByValue {
	}
}