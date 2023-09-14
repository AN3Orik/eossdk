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
 * Output parameters for the EOS_Auth_Logout Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Auth_LogoutCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Auth_Login */
	public long ClientData;
	/** The Epic Account ID of the local user requesting the information */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Auth_LogoutCallbackInfo() {
		super();
	}

	public EOS_Auth_LogoutCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LogoutCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LogoutCallbackInfo implements Structure.ByValue {
	}
}