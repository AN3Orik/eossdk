/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Auth_QueryIdToken Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetAccountId"})
public class EOS_Auth_QueryIdTokenCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Auth_QueryIdToken */
	public Pointer ClientData;
	/** The Epic Account ID of the local authenticated user. */
	public EOS_EpicAccountId LocalUserId;
	/** The target Epic Account ID for which the ID token was retrieved. */
	public EOS_EpicAccountId TargetAccountId;

	public EOS_Auth_QueryIdTokenCallbackInfo() {
		super();
	}

	public EOS_Auth_QueryIdTokenCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_QueryIdTokenCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_QueryIdTokenCallbackInfo implements Structure.ByValue {
	}
}