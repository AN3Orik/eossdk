package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_TitleStorage_DeleteCache function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_TitleStorage_DeleteCacheOptions extends Structure {
	public static final int EOS_TITLESTORAGE_DELETECACHE_API_LATEST = 1;

	/** API Version: Set this to EOS_TITLESTORAGE_DELETECACHE_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the local user who is deleting his cache (optional) */
	public EOS_ProductUserId LocalUserId;

	public EOS_TitleStorage_DeleteCacheOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_DELETECACHE_API_LATEST;
	}

	public EOS_TitleStorage_DeleteCacheOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_DeleteCacheOptions implements Structure.ByReference {
	}
	public static class ByValue extends EOS_TitleStorage_DeleteCacheOptions implements Structure.ByValue {
	}
}