package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Ecom_RedeemEntitlements Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "RedeemedEntitlementIdsCount"})
public class EOS_Ecom_RedeemEntitlementsCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful request, otherwise one of the error codes is returned. See eos_common.h */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_RedeemEntitlements */
	public Pointer ClientData;
	/** The Epic Account ID of the user who has redeemed entitlements */
	public EOS_EpicAccountId LocalUserId;
	/* The number of redeemed Entitlements */
	public int RedeemedEntitlementIdsCount;

	public EOS_Ecom_RedeemEntitlementsCallbackInfo() {
		super();
	}

	public EOS_Ecom_RedeemEntitlementsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_RedeemEntitlementsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_RedeemEntitlementsCallbackInfo implements Structure.ByValue {
	}
}