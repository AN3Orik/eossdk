package host.anzo.eossdk.eos.sdk.userinfo.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.userinfo.callbackresults.EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_UserInfo_QueryUserInfoByExternalAccount
	 * @param data A EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo containing the output information and result
	 */
	void apply(EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo data);
}