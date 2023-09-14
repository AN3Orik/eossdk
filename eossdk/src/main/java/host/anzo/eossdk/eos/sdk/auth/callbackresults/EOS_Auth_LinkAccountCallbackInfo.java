/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_PinGrantInfo;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Auth_LinkAccount Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "PinGrantInfo", "SelectedAccountId"})
public class EOS_Auth_LinkAccountCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Auth_LinkAccount */
	public Pointer ClientData;
	/** The Epic Account ID of the local user whose account has been linked during login */
	public EOS_EpicAccountId LocalUserId;
	/**
	 * Optional data returned when ResultCode is EOS_Auth_PinGrantCode.
	 * <p>
	 * Once the user has logged in with their Epic Online Services account, the account will be linked with the external account supplied when EOS_Auth_Login was called.
	 * EOS_Auth_OnLinkAccountCallback will be fired again with ResultCode in EOS_Auth_LinkAccountCallbackInfo set to EOS_Success.
	 */
	public EOS_Auth_PinGrantInfo.ByReference PinGrantInfo;
	/**
	 * The Epic Account ID that has been previously selected to be used for the current application.
	 * Applications should use this ID to authenticate with online backend services that store game-scoped data for users.
	 * <p>
	 * Note: This ID may be different from LocalUserId if the user has previously merged Epic accounts into the account
	 * represented by LocalUserId, and one of the accounts that got merged had game data associated with it for the application.
	 */
	public EOS_EpicAccountId SelectedAccountId;

	public EOS_Auth_LinkAccountCallbackInfo() {
		super();
	}

	public EOS_Auth_LinkAccountCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LinkAccountCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LinkAccountCallbackInfo implements Structure.ByValue {
	}
}