package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_CopyTransactionByIdOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Ecom_Checkout Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TransactionId"})
public class EOS_Ecom_CheckoutCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful request, otherwise one of the error codes is returned. See eos_common.h */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_Checkout */
	public Pointer ClientData;
	/** The Epic Account ID of the user who initiated the purchase */
	public EOS_EpicAccountId LocalUserId;
	/** The transaction ID which can be used to obtain an EOS_Ecom_Transaction using {@link EOS_Ecom_Interface#copyTransactionById(EOS_Ecom_CopyTransactionByIdOptions)}. */
	public String TransactionId;

	public EOS_Ecom_CheckoutCallbackInfo() {
		super();
	}

	public EOS_Ecom_CheckoutCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CheckoutCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CheckoutCallbackInfo implements Structure.ByValue {
	}
}