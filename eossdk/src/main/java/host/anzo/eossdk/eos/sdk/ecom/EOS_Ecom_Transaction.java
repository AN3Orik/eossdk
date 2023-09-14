package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.callbackresults.EOS_Ecom_CheckoutCallbackInfo;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_CopyTransactionByIndexOptions;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_GetTransactionCountOptions;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_Transaction_CopyEntitlementByIndexOptions;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_Transaction_GetEntitlementsCountOptions;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_Ecom_Transaction extends PointerType implements AutoCloseable {
	public EOS_Ecom_Transaction(Pointer address) {
		super(address);
	}
	public EOS_Ecom_Transaction() {
		super();
	}

	/**
	 * The Ecom Transaction Interface exposes getters for accessing information about a completed transaction.
	 * All Ecom Transaction Interface calls take a handle of type EOS_Ecom_HTransaction as the first parameter.
	 * An EOS_Ecom_HTransaction handle is originally returned as part of the EOS_Ecom_CheckoutCallbackInfo struct.
	 * An EOS_Ecom_HTransaction handle can also be retrieved from an EOSEcom handle using EOS_Ecom_CopyTransactionByIndex.
	 * It is expected that after a transaction that EOS_Ecom_Transaction_Release is called.
	 * When EOS_Platform_Release is called any remaining transactions will also be released.
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see EOS_Ecom_Interface#getTransactionCount(EOS_Ecom_GetTransactionCountOptions)
	 * @see EOS_Ecom_Interface#copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions, EOS_Ecom_Transaction)
	 */
	public EOS_EResult getTransactionId(ByteBuffer OutBuffer, IntBuffer InOutBufferLength) {
		return EOSLibrary.instance.EOS_Ecom_Transaction_GetTransactionId(this, OutBuffer, InOutBufferLength);
	}

	/**
	 * Fetch the number of entitlements that are part of this transaction.
	 *
	 * @param options structure containing the Epic Account ID being accessed
	 *
	 * @see EOS_Ecom_Transaction#copyEntitlementByIndex(EOS_Ecom_Transaction_CopyEntitlementByIndexOptions, EOS_Ecom_Entitlement[])
	 *
	 * @return the number of entitlements found.
	 */
	public int getEntitlementsCount(EOS_Ecom_Transaction_GetEntitlementsCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_Transaction_GetEntitlementsCount(this, options);
	}

	/**
	 * Fetches an entitlement from a given index.
	 *
	 * @param options structure containing the index being accessed
	 * @param outEntitlement the entitlement for the given index, if it exists and is valid, use EOS_Ecom_Entitlement_Release when finished
	 *
	 * @see EOS_Ecom_Entitlement#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutEntitlement
	 *         {@link EOS_EResult#EOS_Ecom_EntitlementStale} if the entitlement information is stale and passed out in OutEntitlement
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter
	 *         {@link EOS_EResult#EOS_NotFound} if the entitlement is not found
	 */
	public EOS_EResult copyEntitlementByIndex(EOS_Ecom_Transaction_CopyEntitlementByIndexOptions options,
	                                                               EOS_Ecom_Entitlement[] outEntitlement) {
		return EOSLibrary.instance.EOS_Ecom_Transaction_CopyEntitlementByIndex(this, options, outEntitlement);
	}

	/**
	 * Release the memory associated with an EOS_Ecom_HTransaction.  Is expected to be called after
	 * being received from a EOS_Ecom_CheckoutCallbackInfo.
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see EOS_Ecom_Interface#getTransactionCount(EOS_Ecom_GetTransactionCountOptions)
	 * @see EOS_Ecom_Interface#copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions, EOS_Ecom_Transaction)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Ecom_Transaction_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}