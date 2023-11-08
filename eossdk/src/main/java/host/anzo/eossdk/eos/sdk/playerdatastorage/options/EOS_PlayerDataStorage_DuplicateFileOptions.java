package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SourceFilename", "DestinationFilename"})
public class EOS_PlayerDataStorage_DuplicateFileOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_DuplicateFile API. */
	public static final int EOS_PLAYERDATASTORAGE_DUPLICATEFILE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PLAYERDATASTORAGE_DUPLICATEFILE_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user who authorized the duplication of the requested file; must be the original file's owner */
	public EOS_ProductUserId LocalUserId;
	/** The name of the existing file to duplicate */
	public String SourceFilename;
	/** The name of the new file */
	public String DestinationFilename;

	public EOS_PlayerDataStorage_DuplicateFileOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_DUPLICATEFILE_API_LATEST;
	}

	public EOS_PlayerDataStorage_DuplicateFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_DuplicateFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_DuplicateFileOptions implements Structure.ByValue {
	}
}