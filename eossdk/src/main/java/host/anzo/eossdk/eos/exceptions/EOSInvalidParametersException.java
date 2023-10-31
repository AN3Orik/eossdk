package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_InvalidParameters}
 *
 * @author Anton Lasevich
 * @since 9/21/2023
 */
public class EOSInvalidParametersException extends EOSException {
	public EOSInvalidParametersException() {
		super(EOS_EResult.EOS_InvalidParameters);
	}
}
