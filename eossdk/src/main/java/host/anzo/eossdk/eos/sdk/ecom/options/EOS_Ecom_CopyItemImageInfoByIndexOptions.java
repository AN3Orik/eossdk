package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_CopyItemImageInfoByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ItemId", "ImageInfoIndex"})
public class EOS_Ecom_CopyItemImageInfoByIndexOptions extends Structure {
	public static final int EOS_ECOM_COPYITEMIMAGEINFOBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_COPYITEMIMAGEINFOBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose item image is being copied */
	public EOS_EpicAccountId LocalUserId;
	/** The ID of the item to get the images for. */
	public String ItemId;
	/** The index of the image to get. */
	public int ImageInfoIndex;

	public EOS_Ecom_CopyItemImageInfoByIndexOptions() {
		super();
		ApiVersion = EOS_ECOM_COPYITEMIMAGEINFOBYINDEX_API_LATEST;
	}

	public EOS_Ecom_CopyItemImageInfoByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_CopyItemImageInfoByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CopyItemImageInfoByIndexOptions implements Structure.ByValue {
	}
}