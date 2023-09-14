package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_GetItemReleaseCount function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ItemId"})
public class EOS_Ecom_GetItemReleaseCountOptions extends Structure {
	public static final int EOS_ECOM_GETITEMRELEASECOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_GETITEMRELEASECOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose item release is being accessed */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the item to get the releases for. */
	public Pointer ItemId;

	public EOS_Ecom_GetItemReleaseCountOptions() {
		super();
		ApiVersion = EOS_ECOM_GETITEMRELEASECOUNT_API_LATEST;
	}

	public EOS_Ecom_GetItemReleaseCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_GetItemReleaseCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_GetItemReleaseCountOptions implements Structure.ByValue {
	}
}