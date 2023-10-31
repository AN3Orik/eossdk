package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_PlayerDataStorage_GetFileMetadataCount function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_PlayerDataStorage_GetFileMetadataCountOptions extends Structure {
	/** The most recent version of the EOS_PlayerDataStorage_GetFileMetadataCount API. */
	public static final int EOS_PLAYERDATASTORAGE_GETFILEMETADATACOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_GETFILEMETADATACOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is requesting file metadata */
	public EOS_ProductUserId LocalUserId;

	public EOS_PlayerDataStorage_GetFileMetadataCountOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_GETFILEMETADATACOUNT_API_LATEST;
	}

	public EOS_PlayerDataStorage_GetFileMetadataCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_GetFileMetadataCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_GetFileMetadataCountOptions implements Structure.ByValue {
	}
}