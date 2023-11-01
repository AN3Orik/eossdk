package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_GetBlockedUserAtIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_Friends_GetBlockedUserAtIndexOptions extends Structure {
	/** The most recent version of the EOS_Friends_GetBlockedUserAtIndex API. */
	public static final int EOS_FRIENDS_GETBLOCKEDUSERATINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_GETBLOCKEDUSERATINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user whose blocked users list is being queried. */
	public EOS_EpicAccountId LocalUserId;
	/** Index into the blocked users list. This value must be between 0 and EOS_Friends_GetBlockedUsersCount-1 inclusively. */
	public int Index;

	public EOS_Friends_GetBlockedUserAtIndexOptions() {
		super();
		ApiVersion = EOS_FRIENDS_GETBLOCKEDUSERATINDEX_API_LATEST;
	}

	public EOS_Friends_GetBlockedUserAtIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_GetBlockedUserAtIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_GetBlockedUserAtIndexOptions implements Structure.ByValue {
	}
}