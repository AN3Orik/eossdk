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
 * Output parameters for the EOS_Connect_QueryProductUserIdMappings function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Connect_TransferDeviceIdAccountCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_TransferDeviceIdAccount. */
	public Pointer ClientData;
	/**
	 * The ProductUserIdToPreserve that was passed to the original EOS_Connect_TransferDeviceIdAccount call.
	 * <p>
	 * On successful operation, this EOS_ProductUserId will have a valid authentication session
	 * and the other EOS_ProductUserId value has been discarded and lost forever.
	 * <p>
	 * The application should remove any registered notification callbacks for the discarded EOS_ProductUserId as obsolete.
	 */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_TransferDeviceIdAccountCallbackInfo() {
		super();
	}

	public EOS_Connect_TransferDeviceIdAccountCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_TransferDeviceIdAccountCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_TransferDeviceIdAccountCallbackInfo implements Structure.ByValue {
	}
}