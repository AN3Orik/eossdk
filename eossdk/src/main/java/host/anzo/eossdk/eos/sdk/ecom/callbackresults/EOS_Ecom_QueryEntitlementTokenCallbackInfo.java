package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Ecom_QueryEntitlementToken Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "EntitlementToken"})
public class EOS_Ecom_QueryEntitlementTokenCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_QueryEntitlementToken */
	public Pointer ClientData;
	/** The Epic Account ID of the local user whose entitlement was queried */
	public EOS_EpicAccountId LocalUserId;
	/** Entitlements token containing details about the catalog items queried */
	public String EntitlementToken;

	public EOS_Ecom_QueryEntitlementTokenCallbackInfo() {
		super();
	}

	public EOS_Ecom_QueryEntitlementTokenCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryEntitlementTokenCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryEntitlementTokenCallbackInfo implements Structure.ByValue {
	}
}