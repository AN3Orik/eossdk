package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_PlayerDataStorage_QueryFileList function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_PlayerDataStorage_QueryFileListOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_QueryFileList API. */
	public static final int EOS_PLAYERDATASTORAGE_QUERYFILELIST_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_PLAYERDATASTORAGE_QUERYFILELIST_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user who requested file metadata */
	public EOS_ProductUserId LocalUserId;

	public EOS_PlayerDataStorage_QueryFileListOptions() {
		super();
	}

	public EOS_PlayerDataStorage_QueryFileListOptions(Pointer peer) {
		super(peer);
		ApiVersion = EOS_PLAYERDATASTORAGE_QUERYFILELIST_API_LATEST;
	}

	public static class ByReference extends EOS_PlayerDataStorage_QueryFileListOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_QueryFileListOptions implements Structure.ByValue {
	}
}