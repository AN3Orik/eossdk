package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyItemById function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ItemId"})
public class EOS_Ecom_CopyItemByIdOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyItemById API. */
	public static final int EOS_ECOM_COPYITEMBYID_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYITEMBYID_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose item is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the item to get. */
	public String ItemId;

	public EOS_Ecom_CopyItemByIdOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYITEMBYID_API_LATEST;
	}

	public EOS_Ecom_CopyItemByIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyItemByIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyItemByIdOptions implements Structure.ByValue {
	}
}