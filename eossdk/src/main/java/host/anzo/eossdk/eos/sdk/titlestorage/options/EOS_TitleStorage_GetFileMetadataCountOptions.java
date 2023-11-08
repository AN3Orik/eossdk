package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_TitleStorage_GetFileMetadataCount function
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_TitleStorage_GetFileMetadataCountOptions extends Structure {
	/** The most recent version of the EOS_TitleStorage_GetFileMetadataCount API. */
	public static final int EOS_TITLESTORAGE_GETFILEMETADATACOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_TITLESTORAGE_GETFILEMETADATACOUNT_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the local user who is requesting file metadata (optional) */
	public EOS_ProductUserId LocalUserId;

	public EOS_TitleStorage_GetFileMetadataCountOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_GETFILEMETADATACOUNT_API_LATEST;
	}

	public EOS_TitleStorage_GetFileMetadataCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_GetFileMetadataCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_GetFileMetadataCountOptions implements Structure.ByValue {
	}
}