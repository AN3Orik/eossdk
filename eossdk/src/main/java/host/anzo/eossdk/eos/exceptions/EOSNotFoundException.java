package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * @author Anton Lasevich
 * @since 9/21/2023
 */
public class EOSNotFoundException extends EOSException {
	public EOSNotFoundException() {
		super(EOS_EResult.EOS_NotFound);
	}
}
