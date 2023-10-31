package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyTransactionById function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TransactionId"})
public class EOS_Ecom_CopyTransactionByIdOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyTransactionById Function. */
	public static final int EOS_ECOM_COPYTRANSACTIONBYID_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYTRANSACTIONBYID_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user who is associated with the transaction */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the transaction to get */
	public String TransactionId;

	public EOS_Ecom_CopyTransactionByIdOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYTRANSACTIONBYID_API_LATEST;
	}
	public EOS_Ecom_CopyTransactionByIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyTransactionByIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyTransactionByIdOptions implements Structure.ByValue {
	}
}