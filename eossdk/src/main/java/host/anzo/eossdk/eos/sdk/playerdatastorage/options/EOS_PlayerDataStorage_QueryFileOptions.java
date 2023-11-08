package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_PlayerDataStorage_QueryFile function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename"})
public class EOS_PlayerDataStorage_QueryFileOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_QueryFile API. */
	public static final int EOS_PLAYERDATASTORAGE_QUERYFILE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PLAYERDATASTORAGE_QUERYFILE_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user requesting file metadata */
	public EOS_ProductUserId LocalUserId;
	/** The name of the file being queried */
	public String Filename;

	public EOS_PlayerDataStorage_QueryFileOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_QUERYFILE_API_LATEST;
	}

	public EOS_PlayerDataStorage_QueryFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_QueryFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_QueryFileOptions implements Structure.ByValue {
	}
}