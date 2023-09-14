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
public class EOS_Connect_QueryExternalAccountMappingsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_QueryExternalAccountMappings. */
	public Pointer ClientData;
	/** The Product User ID of the existing, logged-in user who made the request. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_QueryExternalAccountMappingsCallbackInfo() {
		super();
	}

	public EOS_Connect_QueryExternalAccountMappingsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_QueryExternalAccountMappingsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_QueryExternalAccountMappingsCallbackInfo implements Structure.ByValue {
	}
}