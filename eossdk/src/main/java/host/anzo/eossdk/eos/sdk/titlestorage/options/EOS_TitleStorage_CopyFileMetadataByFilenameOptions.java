package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the CopyFileMetadataByFilename function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename"})
public class EOS_TitleStorage_CopyFileMetadataByFilenameOptions extends Structure {
	/** The most recent version of the EOS_TitleStorage_CopyFileMetadataByFilename API. */
	public static final int EOS_TITLESTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_TITLESTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the local user who is requesting file metadata (optional) */
	public EOS_ProductUserId LocalUserId;
	/** The file's name to get data for */
	public String Filename;

	public EOS_TitleStorage_CopyFileMetadataByFilenameOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_COPYFILEMETADATABYFILENAME_API_LATEST;
	}

	public EOS_TitleStorage_CopyFileMetadataByFilenameOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_CopyFileMetadataByFilenameOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_CopyFileMetadataByFilenameOptions implements Structure.ByValue {
	}
}