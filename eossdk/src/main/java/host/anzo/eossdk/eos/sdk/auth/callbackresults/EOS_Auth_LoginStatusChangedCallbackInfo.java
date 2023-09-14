/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Auth_OnLoginStatusChangedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "PrevStatus", "CurrentStatus"})
public class EOS_Auth_LoginStatusChangedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Auth_AddNotifyLoginStatusChanged */
	public long ClientData;
	/** The Epic Account ID of the local user whose status has changed */
	public EOS_EpicAccountId LocalUserId;
	/** The status prior to the change */
	public EOS_ELoginStatus PrevStatus;
	/** The status at the time of the notification */
	public EOS_ELoginStatus CurrentStatus;

	public EOS_Auth_LoginStatusChangedCallbackInfo() {
		super();
	}

	public EOS_Auth_LoginStatusChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LoginStatusChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LoginStatusChangedCallbackInfo implements Structure.ByValue {
	}
}