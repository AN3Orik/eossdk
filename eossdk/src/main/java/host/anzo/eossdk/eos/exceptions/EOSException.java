package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Lasevich
 * @since 9/21/2023
 */
public @Getter class EOSException extends Exception {
	private final EOS_EResult result;

	protected EOSException(@NotNull EOS_EResult errorCode) {
		this.result = errorCode;
	}

	public static EOSException fromResult(@NotNull EOS_EResult result) {
		switch (result) {
			case EOS_AntiCheat_InvalidMode:
				return new EOSAntiCheatInvalidModeException();
			case EOS_Ecom_CatalogItemStale:
				return new EOSEcomCatalogItemStaleException();
			case EOS_Ecom_CatalogOfferPriceInvalid:
				return new EOSEcomCatalogOfferPriceInvalidException();
			case EOS_Ecom_CatalogOfferStale:
				return new EOSEcomCatalogOfferStaleException();
			case EOS_Ecom_EntitlementStale:
				return new EOSEcomEntitlementStaleException();
			case EOS_InvalidAuth:
				return new EOSInvalidAuthException();
			case EOS_InvalidParameters:
				return new EOSInvalidParametersException();
			case EOS_Invalid_ProductUserID:
				return new EOSInvalidProductUserIDException();
			case EOS_InvalidUser:
				return new EOSInvalidUserException();
			case EOS_NotFound:
				return new EOSNotFoundException();
			case EOS_UserInfo_BestDisplayNameIndeterminate:
				return new EOSUserInfoBestDisplayNameIndeterminateException();
			case EOS_IncompatibleVersion:
				return new EOSIncompatibleVersionException();
			case EOS_ProgressionSnapshot_SnapshotIdUnavailable:
				return new EOSProgressionSnapshotSnapshotIdUnavailableException();
			default:
				return new EOSException(result);
		}
	}

	@Override
	public String getMessage() {
		return "EOS SDK Message: " + result;
	}
}