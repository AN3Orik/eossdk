/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Connect_QueryProductUserIdMappingsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_QueryProductUserIdMappings. */
	public Pointer ClientData;
	/** The local Product User ID that was passed with the input options. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_QueryProductUserIdMappingsCallbackInfo() {
		super();
	}

	public EOS_Connect_QueryProductUserIdMappingsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_QueryProductUserIdMappingsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_QueryProductUserIdMappingsCallbackInfo implements Structure.ByValue {
	}
}