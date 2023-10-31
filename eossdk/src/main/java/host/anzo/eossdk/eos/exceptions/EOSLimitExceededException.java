package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_LimitExceeded}
 *
 * @author Anton Lasevich
 * @since 9/25/2023
 */
public class EOSLimitExceededException extends EOSException {
	protected EOSLimitExceededException() {
		super(EOS_EResult.EOS_LimitExceeded);
	}
}