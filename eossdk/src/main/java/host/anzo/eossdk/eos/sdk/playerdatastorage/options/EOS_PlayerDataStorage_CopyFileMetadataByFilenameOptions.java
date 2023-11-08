package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the CopyFileMetadataByFilename function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename"})
public class EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_CopyFileMetadataByFilename API. */
	public static final int EOS_PLAYERDATASTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PLAYERDATASTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user who is requesting file metadata */
	public EOS_ProductUserId LocalUserId;
	/** The file's name to get data for */
	public String Filename;

	public EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST;
	}

	public EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions implements Structure.ByValue {
	}
}
