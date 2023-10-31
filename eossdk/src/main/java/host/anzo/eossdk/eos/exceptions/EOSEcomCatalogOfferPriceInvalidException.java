package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_Ecom_CatalogOfferPriceInvalid}
 *
 * @author Anton Lasevich
 * @since 9/23/2023
 */
public class EOSEcomCatalogOfferPriceInvalidException extends EOSException {
	public EOSEcomCatalogOfferPriceInvalidException() {
		super(EOS_EResult.EOS_Ecom_CatalogOfferPriceInvalid);
	}
}