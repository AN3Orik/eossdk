package host.anzo.eossdk.eos.sdk.titlestorage;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Metadata information for a specific file
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "FileSizeBytes", "MD5Hash", "Filename", "UnencryptedDataSizeBytes"})
public class EOS_TitleStorage_FileMetadata extends Structure implements AutoCloseable {
	public static final int EOS_TITLESTORAGE_FILEMETADATA_API_LATEST = 2;

	/** API Version: Set this to EOS_TITLESTORAGE_FILEMETADATA_API_LATEST. */
	public int ApiVersion;
	/** The total size of the file in bytes (Includes file header in addition to file contents). */
	public int FileSizeBytes;
	/** The MD5 Hash of the entire file (including additional file header), in hex digits */
	public String MD5Hash;
	/** The file's name */
	public String Filename;
	/** The size of data (payload) in file in unencrypted (original) form. */
	public int UnencryptedDataSizeBytes;

	public EOS_TitleStorage_FileMetadata() {
		super();
		ApiVersion = EOS_TITLESTORAGE_FILEMETADATA_API_LATEST;
	}

	public EOS_TitleStorage_FileMetadata(Pointer peer) {
		super(peer);
	}

	/**
	 * Free the memory used by the file metadata
	 */
	public void release() {
		EOSLibrary.instance.EOS_TitleStorage_FileMetadata_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_TitleStorage_FileMetadata implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_FileMetadata implements Structure.ByValue {
	}
}

