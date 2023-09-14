/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Connect_OnLoginStatusChangedCallback function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "PreviousStatus", "CurrentStatus"})
public class EOS_Connect_LoginStatusChangedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Connect_AddNotifyLoginStatusChanged. */
	public long ClientData;
	/** The Product User ID of the local player whose status has changed. */
	public EOS_ProductUserId LocalUserId;
	/** The status prior to the change. */
	public EOS_ELoginStatus PreviousStatus;
	/** The status at the time of the notification. */
	public EOS_ELoginStatus CurrentStatus;

	public EOS_Connect_LoginStatusChangedCallbackInfo() {
		super();
	}

	public EOS_Connect_LoginStatusChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_LoginStatusChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LoginStatusChangedCallbackInfo implements Structure.ByValue {
	}
}