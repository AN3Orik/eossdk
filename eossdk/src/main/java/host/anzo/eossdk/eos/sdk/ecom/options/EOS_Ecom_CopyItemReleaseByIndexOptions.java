package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyItemReleaseByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ItemId", "ReleaseIndex"})
public class EOS_Ecom_CopyItemReleaseByIndexOptions extends Structure {
	/** The most recent version of the EOS_Ecom_CopyItemReleaseByIndex API. */
	public static final int EOS_ECOM_COPYITEMRELEASEBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYITEMRELEASEBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose item release is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the item to get the releases for. */
	public String ItemId;
	/** The index of the release to get. */
	public int ReleaseIndex;

	public EOS_Ecom_CopyItemReleaseByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYITEMRELEASEBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyItemReleaseByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyItemReleaseByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyItemReleaseByIndexOptions implements Structure.ByValue {
	}
}