package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * @author ANZO
 * @since 9/22/2023
 */
public class EOSInvalidUserException extends EOSException {
	public EOSInvalidUserException() {
		super(EOS_EResult.EOS_InvalidUser);
	}
}
