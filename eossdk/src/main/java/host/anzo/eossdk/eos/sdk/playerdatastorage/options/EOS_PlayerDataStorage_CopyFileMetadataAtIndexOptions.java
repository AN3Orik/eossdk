package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the CopyFileMetadataAtIndex function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions extends Structure {
	public static final int EOS_PLAYERDATASTORAGE_COPYFILEMETADATAATINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_COPYFILEMETADATAATINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is requesting file metadata */
	public EOS_ProductUserId LocalUserId;
	/** The index to get data for */
	public int Index;

	public EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_COPYFILEMETADATAATINDEX_API_LATEST;
	}

	public EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions implements Structure.ByValue {
	}
}