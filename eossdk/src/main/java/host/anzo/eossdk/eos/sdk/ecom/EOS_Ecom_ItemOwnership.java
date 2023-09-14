package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.ecom.enums.EOS_EOwnershipStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "Id", "OwnershipStatus"})
public class EOS_Ecom_ItemOwnership extends Structure {
	/** The most recent version of the EOS_Ecom_ItemOwnership struct. */
	public static final int EOS_ECOM_ITEMOWNERSHIP_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_ITEMOWNERSHIP_API_LATEST. */
	public int ApiVersion;
	/** ID of the catalog item */
	public String Id;
	/**
	 * Is this catalog item owned by the local user
	 */
	public EOS_EOwnershipStatus OwnershipStatus;

	public EOS_Ecom_ItemOwnership() {
		super();
		ApiVersion = EOS_ECOM_ITEMOWNERSHIP_API_LATEST;
	}

	public EOS_Ecom_ItemOwnership(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_ItemOwnership implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_ItemOwnership implements Structure.ByValue {
	}
}