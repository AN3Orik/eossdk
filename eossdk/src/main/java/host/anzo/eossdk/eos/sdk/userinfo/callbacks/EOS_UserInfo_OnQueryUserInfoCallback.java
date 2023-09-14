package host.anzo.eossdk.eos.sdk.userinfo.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.userinfo.callbackresults.EOS_UserInfo_QueryUserInfoCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public interface EOS_UserInfo_OnQueryUserInfoCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_UserInfo_QueryUserInfo
	 * @param data A EOS_UserInfo_QueryUserInfoCallbackInfo containing the output information and result
	 */
	void apply(EOS_UserInfo_QueryUserInfoCallbackInfo data);
}