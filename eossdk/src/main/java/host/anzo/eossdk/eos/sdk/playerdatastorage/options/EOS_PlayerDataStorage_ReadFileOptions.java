package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.EOS_PlayerDataStorage_OnFileTransferProgressCallback;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.EOS_PlayerDataStorage_OnReadFileDataCallback;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename", "ReadChunkLengthBytes", "ReadFileDataCallback", "FileTransferProgressCallback"})
public class EOS_PlayerDataStorage_ReadFileOptions extends Structure {
	public static final int EOS_PLAYERDATASTORAGE_READFILE_API_LATEST = 1;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_READFILE_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is reading the requested file */
	public EOS_ProductUserId LocalUserId;
	/** The file name to read; this file must already exist */
	public String Filename;
	/** The maximum amount of data in bytes should be available to read in a single EOS_PlayerDataStorage_OnReadFileDataCallback call */
	public int ReadChunkLengthBytes;
	/** Callback function that handles data as it comes in, and can stop the transfer early */
	public EOS_PlayerDataStorage_OnReadFileDataCallback ReadFileDataCallback;
	/** Optional callback function to be informed of download progress, if the file is not already locally cached; if provided, this will be called at least once before completion if the request is successfully started */
	public EOS_PlayerDataStorage_OnFileTransferProgressCallback FileTransferProgressCallback;

	public EOS_PlayerDataStorage_ReadFileOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_READFILE_API_LATEST;
	}

	public EOS_PlayerDataStorage_ReadFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_ReadFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_ReadFileOptions implements Structure.ByValue {
	}
}