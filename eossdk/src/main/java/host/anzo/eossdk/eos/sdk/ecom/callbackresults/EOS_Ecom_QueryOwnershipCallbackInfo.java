package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.EOS_Ecom_ItemOwnership;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "ItemOwnership", "ItemOwnershipCount"})
public class EOS_Ecom_QueryOwnershipCallbackInfo extends Structure {
	/** C type : EOS_EResult */
	public EOS_EResult ResultCode;
	/** C type : void* */
	public Pointer ClientData;
	/** C type : EOS_EpicAccountId */
	public EOS_EpicAccountId LocalUserId;
	/** C type : const EOS_Ecom_ItemOwnership* */
	public EOS_Ecom_ItemOwnership.ByReference ItemOwnership;
	public int ItemOwnershipCount;

	public EOS_Ecom_QueryOwnershipCallbackInfo() {
		super();
	}

	public EOS_Ecom_QueryOwnershipCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipCallbackInfo implements Structure.ByValue {
	}
}