/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_AccountFeatureRestrictedInfo;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_PinGrantInfo;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Auth_Login Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "PinGrantInfo", "ContinuanceToken", "AccountFeatureRestrictedInfo", "SelectedAccountId"})
public class EOS_Auth_LoginCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Auth_Login */
	public long ClientData;
	/** The Epic Account ID of the local user who has logged in */
	public EOS_EpicAccountId LocalUserId;
	/** Optional data returned in the middle of a EOS_LCT_DeviceCode request */
	public EOS_Auth_PinGrantInfo.ByReference PinGrantInfo;
	/** If the user was not found with external auth credentials passed into EOS_Auth_Login, this continuance token can be passed to EOS_Auth_LinkAccount to continue the flow. */
	public EOS_ContinuanceToken ContinuanceToken;
	/** If the user trying to login is restricted from doing so, the ResultCode of this structure will be EOS_Auth_AccountFeatureRestricted, and AccountFeatureRestrictedInfo will be populated with the data needed to get past the restriction */
	public EOS_Auth_AccountFeatureRestrictedInfo.ByReference AccountFeatureRestrictedInfo;
	/**
	 * The Epic Account ID that has been previously selected to be used for the current application.
	 * Applications should use this ID to authenticate with online backend services that store game-scoped data for users.
	 * <p>
	 * Note: This ID may be different from LocalUserId if the user has previously merged Epic accounts into the account
	 * represented by LocalUserId, and one of the accounts that got merged had game data associated with it for the application.
	 */
	public EOS_EpicAccountId SelectedAccountId;

	public EOS_Auth_LoginCallbackInfo() {
		super();
	}

	public EOS_Auth_LoginCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LoginCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LoginCallbackInfo implements Structure.ByValue {
	}
}