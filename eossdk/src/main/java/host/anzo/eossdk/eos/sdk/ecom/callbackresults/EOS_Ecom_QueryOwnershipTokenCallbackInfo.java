package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Ecom_QueryOwnershipToken Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "OwnershipToken"})
public class EOS_Ecom_QueryOwnershipTokenCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_QueryOwnershipToken */
	public Pointer ClientData;
	/** The Epic Account ID of the local user whose ownership token was queried */
	public EOS_EpicAccountId LocalUserId;
	/** Ownership token containing details about the catalog items queried */
	public String OwnershipToken;

	public EOS_Ecom_QueryOwnershipTokenCallbackInfo() {
		super();
	}

	public EOS_Ecom_QueryOwnershipTokenCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipTokenCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipTokenCallbackInfo implements Structure.ByValue {
	}
}