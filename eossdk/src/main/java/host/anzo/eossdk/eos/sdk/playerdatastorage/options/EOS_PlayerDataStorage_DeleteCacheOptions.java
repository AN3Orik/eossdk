package host.anzo.eossdk.eos.sdk.playerdatastorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * Input data for the EOS_TitleStorage_DeleteCache function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_PlayerDataStorage_DeleteCacheOptions extends Structure {
	public static final int EOS_PLAYERDATASTORAGE_DELETECACHE_API_LATEST = 1;

	/** API Version: Set this to EOS_PLAYERDATASTORAGE_DELETECACHE_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the local user who is deleting his cache */
	public EOS_ProductUserId LocalUserId;

	public EOS_PlayerDataStorage_DeleteCacheOptions() {
		super();
		ApiVersion = EOS_PLAYERDATASTORAGE_DELETECACHE_API_LATEST;
	}

	public EOS_PlayerDataStorage_DeleteCacheOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_DeleteCacheOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_DeleteCacheOptions implements Structure.ByValue {
	}
}