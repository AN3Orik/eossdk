package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.*;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.*;
import host.anzo.eossdk.eos.sdk.ecom.callbackresults.EOS_Ecom_CheckoutCallbackInfo;
import host.anzo.eossdk.eos.sdk.ecom.callbacks.*;
import host.anzo.eossdk.eos.sdk.ecom.options.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * The Ecom Interface exposes all catalog, purchasing, and ownership entitlement features available with the Epic Games store
 * All Ecom Interface calls take a handle of type EOS_Ecom as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetEcomInterface function.<br>
 * <b>At this time, this feature is only available for products that are part of the Epic Games store.</b>
 *
 * @see EOS_Platform_Interface#getEcomInterface()
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_Ecom_Interface extends PointerType {
	public EOS_Ecom_Interface(Pointer address) {
		super(address);
	}

	public EOS_Ecom_Interface() {
		super();
	}

	/**
	 * Query the ownership status for a given list of catalog item IDs defined with Epic Online Services.
	 * This data will be cached for a limited time and retrieved again from the backend when necessary
	 * Depending on the number of catalog item ids passed, the SDK splits the query into smaller batch requests to the backend and aggregates the result.<br>
	 * Note: If one of the request batches fails, no data is cached and the entire query is marked as failed.
	 *
	 * @param options structure containing the account and catalog item IDs to retrieve
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryOwnership(EOS_Ecom_QueryOwnershipOptions options,
	                           Pointer clientData,
	                           EOS_Ecom_OnQueryOwnershipCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryOwnership(this, options, clientData, completionDelegate);
	}

	/**
	 * Query the ownership status of all catalog item IDs under the given list of Sandbox IDs defined with Epic Online Services.
	 * This data will be cached for a limited time and retrieved again from the backend when necessary.
	 *
	 * @param options structure containing the account and Sandbox IDs to retrieve.
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error.
	 */
	public void queryOwnershipBySandboxIds(EOS_Ecom_QueryOwnershipBySandboxIdsOptions options,
	                                       Pointer clientData,
	                                       EOS_Ecom_OnQueryOwnershipBySandboxIdsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryOwnershipBySandboxIds(this, options, clientData, completionDelegate);
	}

	/**
	 * Query the ownership status for a given list of catalog item IDs defined with Epic Online Services.
	 * The data is return via the callback in the form of a signed JWT that should be verified by an external backend server using a public key for authenticity.
	 *
	 * @param options structure containing the account and catalog item IDs to retrieve in token form
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryOwnershipToken(EOS_Ecom_QueryOwnershipTokenOptions options,
	                                Pointer clientData,
	                                EOS_Ecom_OnQueryOwnershipTokenCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryOwnershipToken(this, options, clientData, completionDelegate);
	}

	/**
	 * Query the entitlement information defined with Epic Online Services.
	 * A set of entitlement names can be provided to filter the set of entitlements associated with the account.
	 * This data will be cached for a limited time and retrieved again from the backend when necessary.
	 * Depending on the number of entitlements passed, the SDK splits the query into smaller batch requests to the backend and aggregates the result.
	 * Note: If one of the request batches fails, no data is cached and the entire query is marked as failed.
	 * Use EOS_Ecom_CopyEntitlementByIndex, EOS_Ecom_CopyEntitlementByNameAndIndex, and EOS_Ecom_CopyEntitlementById to get the entitlement details.
	 * Use EOS_Ecom_GetEntitlementsByNameCount to retrieve the number of entitlements with a specific entitlement name.
	 *
	 * @param options structure containing the account and entitlement names to retrieve
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryEntitlements(EOS_Ecom_QueryEntitlementsOptions options,
	                              Pointer clientData,
	                              EOS_Ecom_OnQueryEntitlementsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryEntitlements(this, options, clientData, completionDelegate);
	}

	/**
	 * Query the entitlement verification status defined with Epic Online Services.
	 * An optional set of entitlement names can be provided to filter the set of entitlements associated with the account.
	 * The data is return via the callback in the form of a signed JWT that should be verified by an external backend server using a public key for authenticity.
	 *
	 * @param options structure containing the account and catalog item IDs to retrieve in token form
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryEntitlementToken(EOS_Ecom_QueryEntitlementTokenOptions options,
	                                  Pointer clientData,
	                                  EOS_Ecom_OnQueryEntitlementTokenCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryEntitlementToken(this, options, clientData, completionDelegate);
	}

	/**
	 * Query for a list of catalog offers defined with Epic Online Services.
	 * This data will be cached for a limited time and retrieved again from the backend when necessary.
	 *
	 * @param options structure containing filter criteria
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryOffers(EOS_Ecom_QueryOffersOptions options, Pointer clientData, EOS_Ecom_OnQueryOffersCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_QueryOffers(this, options, clientData, completionDelegate);
	}

	/**
	 * Initiates the purchase flow for a set of offers.  The callback is triggered after the purchase flow.
	 * On success, the set of entitlements that were unlocked will be cached.
	 * On success, a Transaction ID will be returned. The Transaction ID can be used to obtain an
	 * EOS_Ecom_Transaction handle. The handle can then be used to retrieve the entitlements rewarded by the purchase.
	 *
	 * @see EOS_Ecom_Transaction#release()
	 *
	 * @param options structure containing filter criteria
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void checkout(EOS_Ecom_CheckoutOptions options, Pointer clientData, EOS_Ecom_OnCheckoutCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_Checkout(this, options, clientData, completionDelegate);
	}

	/**
	 * Requests that the provided entitlement be marked redeemed.  This will cause that entitlement
	 * to no longer be returned from QueryEntitlements unless the include redeemed request flag is set true.
	 *
	 * @param options structure containing entitlement to redeem
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void redeemEntitlements(EOS_Ecom_RedeemEntitlementsOptions options,
	                               Pointer clientData,
	                               EOS_Ecom_OnRedeemEntitlementsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Ecom_RedeemEntitlements(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of entitlements that were redeemed during the last EOS_Ecom_RedeemEntitlements call.
	 *
	 * @param options structure containing the Epic Account ID
	 *
	 * @see #copyLastRedeemedEntitlementByIndex(EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions, ByteBuffer, IntBuffer)
	 *
	 * @return the number of the redeemed entitlements.
	 */
	public int getLastRedeemedEntitlementsCount(EOS_Ecom_GetLastRedeemedEntitlementsCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetLastRedeemedEntitlementsCount(this, options);
	}

	/**
	 * Fetches a redeemed entitlement id from a given index.
	 * Only entitlements that were redeemed during the last EOS_Ecom_RedeemEntitlements call can be copied.
	 *
	 * @param options structure containing the Epic Account ID and index being accessed
	 * @param outRedeemedEntitlementId The ID of the redeemed entitlement. Must be long enough to hold a string of EOS_ECOM_ENTITLEMENTID_MAX_LENGTH.
	 * @param InOutRedeemedEntitlementIdLength The size of the OutRedeemedEntitlementId in characters.
	 *										   The input buffer should include enough space to be null-terminated.
	 *										   When the function returns, this parameter will be filled with the length of the string copied into OutRedeemedEntitlementId.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutRedeemedEntitlementId<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the entitlement id is not found
	 *
	 * @see EOS_Ecom_RedeemEntitlementsOptions#EOS_ECOM_ENTITLEMENTID_MAX_LENGTH
	 */
	public EOS_EResult copyLastRedeemedEntitlementByIndex(EOS_Ecom_CopyLastRedeemedEntitlementByIndexOptions options, ByteBuffer outRedeemedEntitlementId, IntBuffer InOutRedeemedEntitlementIdLength) {
		return EOSLibrary.instance.EOS_Ecom_CopyLastRedeemedEntitlementByIndex(this, options, outRedeemedEntitlementId, InOutRedeemedEntitlementIdLength);
	}

	/**
	 * Fetch the number of entitlements that are cached for a given local user.
	 *
	 * @param options structure containing the Epic Account ID being accessed
	 *
	 * @see #copyEntitlementByIndex(EOS_Ecom_CopyEntitlementByIndexOptions)
	 *
	 * @return the number of entitlements found.
	 */
	public int getEntitlementsCount(EOS_Ecom_GetEntitlementsCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetEntitlementsCount(this, options);
	}

	/**
	 * Fetch the number of entitlements with the given Entitlement Name that are cached for a given local user.
	 *
	 * @param options structure containing the Epic Account ID and name being accessed
	 *
	 * @see #copyEntitlementByNameAndIndex(EOS_Ecom_CopyEntitlementByNameAndIndexOptions)
	 *
	 * @return the number of entitlements found.
	 */
	public int getEntitlementsByNameCount(EOS_Ecom_GetEntitlementsByNameCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetEntitlementsByNameCount(this, options);
	}

	/**
	 * Fetches an entitlement from a given index.
	 *
	 * @param options structure containing the Epic Account ID and index being accessed
	 * @return the entitlement for the given index, if it exists and is valid, use {@link EOS_Ecom_Entitlement#release()} when finished
	 *
	 * @see EOS_Ecom_Entitlement#release()
	 *
	 * @throws EOSEcomEntitlementStaleException if the entitlement information is stale and passed out in OutEntitlement
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the entitlement is not found
	 */
	public EOS_Ecom_Entitlement copyEntitlementByIndex(EOS_Ecom_CopyEntitlementByIndexOptions options) throws EOSException {
		final EOS_Ecom_Entitlement.ByReference entitlementReference = new EOS_Ecom_Entitlement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyEntitlementByIndex(this, options, entitlementReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return entitlementReference;
	}

	/**
	 * Fetches a single entitlement with a given Entitlement Name.  The Index is used to access individual
	 * entitlements among those with the same Entitlement Name.  The Index can be a value from 0 to
	 * one less than the result from EOS_Ecom_GetEntitlementsByNameCount.
	 *
	 * @param options structure containing the Epic Account ID, entitlement name, and index being accessed
	 * @return the entitlement for the given name index pair, if it exists and is valid, use {@link EOS_Ecom_Entitlement#release()} when finished
	 *
	 * @see EOS_Ecom_Entitlement#release()
	 *
	 * @throws EOSEcomEntitlementStaleException if the entitlement information is stale and passed out in OutEntitlement
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the entitlement is not found
	 */
	public EOS_Ecom_Entitlement copyEntitlementByNameAndIndex(EOS_Ecom_CopyEntitlementByNameAndIndexOptions options) throws EOSException {
		final EOS_Ecom_Entitlement.ByReference outEntitlement = new EOS_Ecom_Entitlement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyEntitlementByNameAndIndex(this, options, outEntitlement);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outEntitlement;
	}

	/**
	 * Fetches the entitlement with the given ID.
	 *
	 * @param options structure containing the Epic Account ID and entitlement ID being accessed
	 * @return the entitlement for the given ID, if it exists and is valid, use {@link EOS_Ecom_Entitlement#release()} when finished
	 *
	 * @see #copyEntitlementByNameAndIndex(EOS_Ecom_CopyEntitlementByNameAndIndexOptions)
	 * @see EOS_Ecom_Entitlement#release()
	 *
	 * @throws EOSEcomEntitlementStaleException if the entitlement information is stale and passed out in OutEntitlement
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the entitlement is not found
	 */
	public EOS_Ecom_Entitlement copyEntitlementById(EOS_Ecom_CopyEntitlementByIdOptions options) throws EOSException {
		final EOS_Ecom_Entitlement.ByReference outEntitlement = new EOS_Ecom_Entitlement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyEntitlementById(this, options, outEntitlement);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outEntitlement;
	}

	/**
	 * Fetch the number of offers that are cached for a given local user.
	 *
	 * @param options structure containing the Epic Account ID being accessed
	 *
	 * @see #copyOfferByIndex(EOS_Ecom_CopyOfferByIndexOptions)
	 *
	 * @return the number of offers found.
	 */
	public int getOfferCount(EOS_Ecom_GetOfferCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetOfferCount(this, options);
	}

	/**
	 * Fetches an offer from a given index.  The pricing and text are localized to the provided account.
	 *
	 * @param options structure containing the Epic Account ID and index being accessed
	 * @return the offer for the given index, if it exists and is valid, use EOS_Ecom_CatalogOffer_Release when finished
	 *
	 * @see EOS_Ecom_CatalogOffer#release()
	 * @see #getOfferItemCount(EOS_Ecom_GetOfferItemCountOptions)
	 *
	 * @throws EOSEcomCatalogOfferStaleException if the offer information is stale and passed out in OutOffer
	 * @throws EOSEcomCatalogOfferPriceInvalidException if the offer information has an invalid price and passed out in OutOffer
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the offer is not found
	 */
	public EOS_Ecom_CatalogOffer copyOfferByIndex(EOS_Ecom_CopyOfferByIndexOptions options) throws EOSException {
		final EOS_Ecom_CatalogOffer.ByReference outOffer = new EOS_Ecom_CatalogOffer.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyOfferByIndex(this, options, outOffer);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outOffer;
	}

	/**
	 * Fetches an offer with a given ID.  The pricing and text are localized to the provided account.
	 *
	 * @param options structure containing the Epic Account ID and offer ID being accessed
	 * @return the offer for the given index, if it exists and is valid, use {@link EOS_Ecom_CatalogOffer#release()} when finished
	 *
	 * @see EOS_Ecom_CatalogOffer#release()
	 * @see #getOfferItemCount(EOS_Ecom_GetOfferItemCountOptions)
	 *
	 * @throws EOSEcomCatalogOfferStaleException if the offer information is stale and passed out in OutOffer
	 * @throws EOSEcomCatalogOfferPriceInvalidException if the offer information has an invalid price and passed out in OutOffer
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the offer is not found
	 */
	public EOS_Ecom_CatalogOffer copyOfferById(EOS_Ecom_CopyOfferByIdOptions options) throws EOSException {
		final EOS_Ecom_CatalogOffer.ByReference outOffer = new EOS_Ecom_CatalogOffer.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyOfferById(this, options, outOffer);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outOffer;
	}

	/**
	 * Fetch the number of items that are associated with a given cached offer for a local user.
	 *
	 * @return the number of items found.
	 */
	public int getOfferItemCount(EOS_Ecom_GetOfferItemCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetOfferItemCount(this, options);
	}

	/**
	 * Fetches an item from a given index.
	 *
	 * @param options structure containing the Epic Account ID and index being accessed
	 * @return the item for the given index, if it exists and is valid, use EOS_Ecom_CatalogItem_Release when finished
	 *
	 * @see EOS_Ecom_CatalogItem#release()
	 * @see #getItemImageInfoCount(EOS_Ecom_GetItemImageInfoCountOptions)
	 * @see #getItemReleaseCount(EOS_Ecom_GetItemReleaseCountOptions)
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSEcomCatalogItemStaleException  if the item information is stale
	 * @throws EOSNotFoundException if the item is not found
	 */
	public EOS_Ecom_CatalogItem copyOfferItemByIndex(EOS_Ecom_CopyOfferItemByIndexOptions options) throws EOSException {
		final EOS_Ecom_CatalogItem.ByReference outItem = new EOS_Ecom_CatalogItem.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyOfferItemByIndex(this, options, outItem);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outItem;
	}

	/**
	 * Fetches an item with a given ID.
	 *
	 * @param options structure containing the item ID being accessed
	 * @return the item for the given index, if it exists and is valid, use EOS_Ecom_CatalogItem_Release when finished
	 *
	 * @see EOS_Ecom_CatalogItem#release()
	 * @see #getItemImageInfoCount(EOS_Ecom_GetItemImageInfoCountOptions)
	 * @see #getItemReleaseCount(EOS_Ecom_GetItemReleaseCountOptions)
	 *
	 * @throws EOSEcomCatalogItemStaleException if the item information is stale and passed out in OutItem
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the offer is not found
	 */
	public EOS_Ecom_CatalogItem copyItemById(EOS_Ecom_CopyItemByIdOptions options) throws EOSException {
		final EOS_Ecom_CatalogItem.ByReference outItem = new EOS_Ecom_CatalogItem.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyItemById(this, options, outItem);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outItem;
	}

	/**
	 * Fetch the number of images that are associated with a given cached offer for a local user.
	 *
	 * @return the number of images found.
	 */
	public int getOfferImageInfoCount(EOS_Ecom_GetOfferImageInfoCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetOfferImageInfoCount(this, options);
	}

	/**
	 * Fetches an image from a given index.
	 *
	 * @param options structure containing the offer ID and index being accessed
	 * @return the image for the given index, if it exists and is valid, use EOS_Ecom_KeyImageInfo_Release when finished
	 *
	 * @see EOS_Ecom_KeyImageInfo#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSEcomCatalogOfferStaleException if the associated offer information is stale
	 * @throws EOSNotFoundException if the image is not found
	 */
	public EOS_Ecom_KeyImageInfo copyOfferImageInfoByIndex(EOS_Ecom_CopyOfferImageInfoByIndexOptions options) throws EOSException {
		final EOS_Ecom_KeyImageInfo.ByReference outImageInfo = new EOS_Ecom_KeyImageInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyOfferImageInfoByIndex(this, options, outImageInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outImageInfo;
	}

	/**
	 * Fetch the number of images that are associated with a given cached item for a local user.
	 *
	 * @return the number of images found.
	 */
	public int getItemImageInfoCount(EOS_Ecom_GetItemImageInfoCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetItemImageInfoCount(this, options);
	}

	/**
	 * Fetches an image from a given index.
	 *
	 * @param options structure containing the item ID and index being accessed
	 * @return the image for the given index, if it exists and is valid, use {@link EOS_Ecom_KeyImageInfo#release()} when finished
	 *
	 * @see EOS_Ecom_KeyImageInfo#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSEcomCatalogItemStaleException if the associated item information is stale
	 * @throws EOSNotFoundException if the image is not found
	 */
	public EOS_Ecom_KeyImageInfo copyItemImageInfoByIndex(EOS_Ecom_CopyItemImageInfoByIndexOptions options) throws EOSException {
		final EOS_Ecom_KeyImageInfo.ByReference outImageInfo = new EOS_Ecom_KeyImageInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyItemImageInfoByIndex(this, options, outImageInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outImageInfo;
	}

	/**
	 * Fetch the number of releases that are associated with a given cached item for a local user.
	 *
	 * @return the number of releases found.
	 */
	public int getItemReleaseCount(EOS_Ecom_GetItemReleaseCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetItemReleaseCount(this, options);
	}

	/**
	 * Fetches a release from a given index.
	 *
	 * @param options structure containing the item ID and index being accessed
	 * @return the release for the given index, if it exists and is valid, use {@link EOS_Ecom_CatalogRelease#release()} when finished
	 *
	 * @see EOS_Ecom_CatalogRelease#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSEcomCatalogItemStaleException if the associated item information is stale
	 * @throws EOSNotFoundException if the release is not found
	 */
	public EOS_Ecom_CatalogRelease copyItemReleaseByIndex(EOS_Ecom_CopyItemReleaseByIndexOptions options) throws EOSException {
		final EOS_Ecom_CatalogRelease.ByReference outRelease = new EOS_Ecom_CatalogRelease.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyItemReleaseByIndex(this, options, outRelease);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outRelease;
	}

	/**
	 * Fetch the number of transactions that are cached for a given local user.
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see #copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions)
	 *
	 * @return the number of transactions found.
	 */
	public int getTransactionCount(EOS_Ecom_GetTransactionCountOptions options) {
		return EOSLibrary.instance.EOS_Ecom_GetTransactionCount(this, options);
	}

	/**
	 * Fetches the transaction handle at the given index.
	 *
	 * @param options structure containing the Epic Account ID and index being accessed
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see EOS_Ecom_Transaction#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the transaction is not found
	 */
	public EOS_Ecom_Transaction copyTransactionByIndex(EOS_Ecom_CopyTransactionByIndexOptions options) throws EOSException {
		final EOS_Ecom_Transaction.ByReference outTransaction = new EOS_Ecom_Transaction.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyTransactionByIndex(this, options, outTransaction);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outTransaction;
	}

	/**
	 * Fetches the transaction handle at the given index.
	 *
	 * @param options structure containing the Epic Account ID and transaction ID being accessed
	 *
	 * @see EOS_Ecom_CheckoutCallbackInfo
	 * @see EOS_Ecom_Transaction#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the transaction is not found
	 */
	public EOS_Ecom_Transaction copyTransactionById(EOS_Ecom_CopyTransactionByIdOptions options) throws EOSException {
		final EOS_Ecom_Transaction.ByReference outTransaction = new EOS_Ecom_Transaction.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Ecom_CopyTransactionById(this, options, outTransaction);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outTransaction;
	}
}