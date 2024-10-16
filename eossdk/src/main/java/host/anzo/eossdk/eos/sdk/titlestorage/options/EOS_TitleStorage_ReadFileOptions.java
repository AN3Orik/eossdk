package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnFileTransferProgressCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnReadFileDataCallback;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_TitleStorage_ReadFile function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename", "ReadChunkLengthBytes", "ReadFileDataCallback", "FileTransferProgressCallback"})
public class EOS_TitleStorage_ReadFileOptions extends Structure {
	/** The most recent version of the EOS_TitleStorage_ReadFile API. */
	public static final int EOS_TITLESTORAGE_READFILE_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_TITLESTORAGE_READFILE_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the local user who is reading the requested file (optional) */
	public EOS_ProductUserId LocalUserId;
	/** The file name to read; this file must already exist */
	public String Filename;
	/** The maximum amount of data in bytes should be available to read in a single EOS_TitleStorage_OnReadFileDataCallback call */
	public int ReadChunkLengthBytes;
	/** Callback function to handle copying read data */
	public EOS_TitleStorage_OnReadFileDataCallback ReadFileDataCallback;
	/** Optional callback function to be informed of download progress, if the file is not already locally cached. If set, this will be called at least once before completion if the request is successfully started */
	public EOS_TitleStorage_OnFileTransferProgressCallback FileTransferProgressCallback;

	public EOS_TitleStorage_ReadFileOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_READFILE_API_LATEST;
	}

	public EOS_TitleStorage_ReadFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_ReadFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_ReadFileOptions implements Structure.ByValue {
	}
}