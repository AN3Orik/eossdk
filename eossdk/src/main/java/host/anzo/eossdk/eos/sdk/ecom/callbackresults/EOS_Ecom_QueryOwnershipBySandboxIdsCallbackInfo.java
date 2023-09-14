package host.anzo.eossdk.eos.sdk.ecom.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.ecom.EOS_Ecom_SandboxIdItemOwnership;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Ecom_QueryOwnershipBySandboxIds Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "SandboxIdItemOwnerships", "SandboxIdItemOwnershipsCount"})
public class EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Ecom_QueryOwnership */
	public Pointer ClientData;
	/** The Epic Account ID of the local user whose ownership was queried */
	public EOS_EpicAccountId LocalUserId;
	/** List of SandboxIds and their corresponding owned catalog item Ids. If there are no ownership items, the OwnedCatalogItemIdsCount is 0 and OwnedCatalogItemIds is null. */
	public EOS_Ecom_SandboxIdItemOwnership.ByReference SandboxIdItemOwnerships;
	/** Number of ownership results are included in this callback */
	public int SandboxIdItemOwnershipsCount;

	public EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo() {
		super();
	}

	public EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo implements Structure.ByValue {
	}
}