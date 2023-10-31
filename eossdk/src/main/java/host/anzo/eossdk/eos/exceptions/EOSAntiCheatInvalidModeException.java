package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_AntiCheat_InvalidMode}
 *
 * @author Anton Lasevich
 * @since 9/22/2023
 */
public class EOSAntiCheatInvalidModeException extends EOSException {
	public EOSAntiCheatInvalidModeException() {
		super(EOS_EResult.EOS_AntiCheat_InvalidMode);
	}
}