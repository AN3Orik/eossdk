package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.exceptions.EOSEcomEntitlementStaleException;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.callbackresults.EOS_Ecom_CheckoutCallbackInfo;
import host.anzo.eossdk.eos.sdk.ecom.options.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * This handle is copied when EOS_Ecom_CopyTransactionById or EOS_Ecom_CopyTransactionByIndex is called.
 * A EOS_Ecom_CheckoutCallbackInfo provides the ID for the copy.
 * After being copied, EOS_Ecom_Transaction_Release must be called.
 *
 * @see EOS_Ecom_CheckoutCallbackInfo
 * @see EOS_Ecom_Interface#copyTransactionById(EOS_Ecom_CopyTransactionByIdOptions)
 * @see EOS_Ecom_Interface#copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions)
 * @see #release()
 *
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
	 * @see EOS_Ecom_Interface#copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions)
	 */
	public EOS_EResult getTransactionId(ByteBuffer outBuffer, IntBuffer inOutBufferLength) {
		return EOSLibrary.instance.EOS_Ecom_Transaction_GetTransactionId(this, outBuffer, inOutBufferLength);
	}

	/**
	 * Fetch the number of entitlements that are part of this transaction.
	 *
	 * @param options structure containing the Epic Account ID being accessed
	 *
	 * @see EOS_Ecom_Transaction#copyEntitlementByIndex(EOS_Ecom_Transaction_CopyEntitlementByIndexOptions)
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
	 * @return the entitlement for the given index, if it exists and is valid, use EOS_Ecom_Entitlement_Release when finished
	 *
	 * @see EOS_Ecom_Entitlement#release()
	 *
	 * @throws EOSEcomEntitlementStaleException if the entitlement information is stale and passed out in OutEntitlement
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the entitlement is not found
	 */
	public EOS_Ecom_Entitlement copyEntitlementByIndex(EOS_Ecom_Transaction_CopyEntitlementByIndexOptions options) throws EOSException {
		final EOS_Ecom_Entitlement.ByReference outEntitlement = new EOS_Ecom_Entitlement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_Transaction_CopyEntitlementByIndex(this, options, outEntitlement);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outEntitlement;
	}

	/**
	 * Release the memory associated with an EOS_Ecom_HTransaction.  Is expected to be called after
	 * being received from a EOS_Ecom_CheckoutCallbackInfo.
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see EOS_Ecom_Interface#getTransactionCount(EOS_Ecom_GetTransactionCountOptions)
	 * @see EOS_Ecom_Interface#copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Ecom_Transaction_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_Transaction implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_Transaction implements Structure.ByValue {
	}
}