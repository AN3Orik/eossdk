package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * Input data for the CopyFileMetadataAtIndex function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public class EOS_TitleStorage_CopyFileMetadataAtIndexOptions extends Structure {
	public static final int EOS_TITLESTORAGE_COPYFILEMETADATAATINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_TITLESTORAGE_COPYFILEMETADATAATINDEX_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the local user who is requesting file metadata (optional) */
	public EOS_ProductUserId LocalUserId;
	/** The index to get data for */
	public int Index;

	public EOS_TitleStorage_CopyFileMetadataAtIndexOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_COPYFILEMETADATAATINDEX_API_LATEST;
	}

	public EOS_TitleStorage_CopyFileMetadataAtIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_CopyFileMetadataAtIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_CopyFileMetadataAtIndexOptions implements Structure.ByValue {
	}
}