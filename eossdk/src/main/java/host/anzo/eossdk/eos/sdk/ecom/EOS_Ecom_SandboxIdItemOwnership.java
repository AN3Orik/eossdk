package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains all owned catalog items for a sandbox ID. This structure is
 * returned as part of the EOS_Ecom_QueryOwnershipBySandboxIdsCallbackInfo structure.
 * Note: The SandboxID and CatalogItemId strings will not remain valid after EOS_Ecom_OnQueryOwnershipBySandboxIdsCallback, so a copy should be as needed.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"SandboxId", "OwnedCatalogItemIds", "OwnedCatalogItemIdsCount"})
public class EOS_Ecom_SandboxIdItemOwnership extends Structure {
	/** SandboxId */
	public String SandboxId;
	/** List of all owned catalog items for this SandboxId */
	public StringArray OwnedCatalogItemIds;
	/** Number of owned catalog items for this SandboxId */
	public int OwnedCatalogItemIdsCount;

	public EOS_Ecom_SandboxIdItemOwnership() {
		super();
	}

	public EOS_Ecom_SandboxIdItemOwnership(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_SandboxIdItemOwnership implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_SandboxIdItemOwnership implements Structure.ByValue {
	}
}