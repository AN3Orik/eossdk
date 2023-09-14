package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename"})
public class EOS_PlayerDataStorage_DeleteFileOptions extends Structure {
	public static final int EOS_PLAYERDATASTORAGE_DELETEFILE_API_LATEST = 1;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_DELETEFILE_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who authorizes deletion of the file; must be the file's owner */
	public EOS_ProductUserId LocalUserId;
	/** The name of the file to delete */
	public String Filename;

	public EOS_PlayerDataStorage_DeleteFileOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_DELETEFILE_API_LATEST;
	}

	public EOS_PlayerDataStorage_DeleteFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_DeleteFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_DeleteFileOptions implements Structure.ByValue {
	}
}