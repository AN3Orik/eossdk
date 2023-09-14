package host.anzo.eossdk.eos.sdk.userinfo.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UserInfo_QueryUserInfoByExternalAccount Function.
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "ExternalAccountId", "AccountType", "TargetUserId"})
public class EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UserInfo_QueryUserInfoByExternalAccount */
	public Pointer ClientData;
	/** The Epic Account ID of the local player who requested the information */
	public EOS_EpicAccountId LocalUserId;
	/** External account id of the user whose information has been retrieved */
	public String ExternalAccountId;
	/** Account type of the external account id */
	public EOS_EExternalAccountType AccountType;
	/** Account ID of the player whose information has been retrieved */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo() {
		super();
	}

	public EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UserInfo_QueryUserInfoByExternalAccountCallbackInfo implements Structure.ByValue {
	}
}