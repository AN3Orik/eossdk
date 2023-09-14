package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_GetFriendAtIndex function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_Friends_GetFriendAtIndexOptions extends Structure {
	public static final int EOS_FRIENDS_GETFRIENDATINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_GETFRIENDATINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user whose friend list is being queried */
	public EOS_EpicAccountId LocalUserId;
	/** Index into the friend list. This value must be between 0 and EOS_Friends_GetFriendsCount-1 inclusively. */
	public int Index;

	public EOS_Friends_GetFriendAtIndexOptions() {
		super();
		ApiVersion = EOS_FRIENDS_GETFRIENDATINDEX_API_LATEST;
	}

	public EOS_Friends_GetFriendAtIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_GetFriendAtIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_GetFriendAtIndexOptions implements Structure.ByValue {
	}
}
