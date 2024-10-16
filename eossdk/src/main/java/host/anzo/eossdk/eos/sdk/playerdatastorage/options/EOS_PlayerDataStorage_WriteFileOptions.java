package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.EOS_PlayerDataStorage_OnFileTransferProgressCallback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.EOS_PlayerDataStorage_OnWriteFileDataCallback;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_PlayerDataStorage_WriteFile function
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename", "ChunkLengthBytes", "WriteFileDataCallback", "FileTransferProgressCallback"})
public class EOS_PlayerDataStorage_WriteFileOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_WriteFile API. */
	public static final int EOS_PLAYERDATASTORAGE_WRITEFILE_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_PLAYERDATASTORAGE_WRITEFILE_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user who is writing the requested file to the cloud */
	public EOS_ProductUserId LocalUserId;
	/** The name of the file to write; if this file already exists, the contents will be replaced if the write request completes successfully */
	public String Filename;
	/** Requested maximum amount of data (in bytes) that can be written to the file per tick */
	public int ChunkLengthBytes;
	/** Callback function that provides chunks of data to be written into the requested file */
	public EOS_PlayerDataStorage_OnWriteFileDataCallback WriteFileDataCallback;
	/** Optional callback function to inform the application of upload progress; will be called at least once if set */
	public EOS_PlayerDataStorage_OnFileTransferProgressCallback FileTransferProgressCallback;

	public EOS_PlayerDataStorage_WriteFileOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_WRITEFILE_API_LATEST;
	}

	public EOS_PlayerDataStorage_WriteFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_WriteFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_WriteFileOptions implements Structure.ByValue {
	}
}