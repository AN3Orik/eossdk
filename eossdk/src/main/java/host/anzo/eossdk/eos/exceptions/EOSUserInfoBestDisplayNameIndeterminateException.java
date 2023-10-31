package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_UserInfo_BestDisplayNameIndeterminate}
 *
 * @author Anton Lasevich
 * @since 9/25/2023
 */
public class EOSUserInfoBestDisplayNameIndeterminateException extends EOSException {
	protected EOSUserInfoBestDisplayNameIndeterminateException() {
		super(EOS_EResult.EOS_UserInfo_BestDisplayNameIndeterminate);
	}
}
