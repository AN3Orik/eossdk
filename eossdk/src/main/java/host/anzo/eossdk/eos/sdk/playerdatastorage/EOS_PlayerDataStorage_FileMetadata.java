package host.anzo.eossdk.eos.sdk.playerdatastorage;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Metadata information for a specific file
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "FileSizeBytes", "MD5Hash", "Filename", "LastModifiedTime", "UnencryptedDataSizeBytes"})
public class EOS_PlayerDataStorage_FileMetadata extends Structure implements AutoCloseable {
	/** Timestamp value representing an undefined time for Player Data Storage. */
	public static final int EOS_PLAYERDATASTORAGE_TIME_UNDEFINED = -1;
	public static final int EOS_PLAYERDATASTORAGE_FILEMETADATA_API_LATEST = 3;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_FILEMETADATA_API_LATEST. */
	public int ApiVersion;
	/** The total size of the file in bytes (Includes file header in addition to file contents) */
	public int FileSizeBytes;
	/** The MD5 Hash of the entire file (including additional file header), in hex digits */
	public String MD5Hash;
	/** The file's name */
	public String Filename;
	/**
	 * The POSIX timestamp when the file was saved last time or {@link #EOS_PLAYERDATASTORAGE_TIME_UNDEFINED} if the time is undefined.
	 * It will be undefined after a file is written and uploaded at first before a query operation is completed.
	 */
	public long LastModifiedTime;
	/** The size of data (payload) in file in unencrypted (original) form. */
	public int UnencryptedDataSizeBytes;

	public EOS_PlayerDataStorage_FileMetadata() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_FILEMETADATA_API_LATEST;
	}

	public EOS_PlayerDataStorage_FileMetadata(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_PlayerDataStorage_FileMetadata_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_PlayerDataStorage_FileMetadata implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_FileMetadata implements Structure.ByValue {
	}
}