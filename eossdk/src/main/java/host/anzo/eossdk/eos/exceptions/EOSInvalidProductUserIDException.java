package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * @author Anton Lasevich
 * @since 9/22/2023
 */
public class EOSInvalidProductUserIDException extends EOSException {
	public EOSInvalidProductUserIDException() {
		super(EOS_EResult.EOS_Invalid_ProductUserID);
	}
}