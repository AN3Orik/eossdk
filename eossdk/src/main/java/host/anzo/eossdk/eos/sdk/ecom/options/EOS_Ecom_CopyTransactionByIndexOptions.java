package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyTransactionByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TransactionIndex"})
public class EOS_Ecom_CopyTransactionByIndexOptions extends Structure {
	public static final int EOS_ECOM_COPYTRANSACTIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYTRANSACTIONBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user who is associated with the transaction */
	public EOS_EpicAccountId LocalUserId;
	/** The index of the transaction to get */
	public int TransactionIndex;

	public EOS_Ecom_CopyTransactionByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYTRANSACTIONBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyTransactionByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyTransactionByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyTransactionByIndexOptions implements Structure.ByValue {
	}
}