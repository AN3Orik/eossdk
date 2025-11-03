package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the {@link EOSLibrary#EOS_Ecom_QueryEntitlements} Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Ecom_QueryEntitlementsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. {@link EOS_EResult#EOS_Success} indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_QueryEntitlements */
	public Pointer ClientData;
	/** The Epic Account ID of the local user whose entitlement was queried */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Ecom_QueryEntitlementsCallbackInfo() {
		super();
	}

	public EOS_Ecom_QueryEntitlementsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryEntitlementsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryEntitlementsCallbackInfo implements Structure.ByValue {
	}
}