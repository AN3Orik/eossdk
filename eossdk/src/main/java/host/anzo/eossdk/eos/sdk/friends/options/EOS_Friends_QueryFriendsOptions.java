package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_QueryFriends function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Friends_QueryFriendsOptions extends Structure {
	/** The most recent version of the EOS_Friends_QueryFriends API. */
	public static final int EOS_FRIENDS_QUERYFRIENDS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_FRIENDS_QUERYFRIENDS_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user whose friends list you want to retrieve */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Friends_QueryFriendsOptions() {
		super();
		ApiVersion = EOS_FRIENDS_QUERYFRIENDS_API_LATEST;
	}

	public EOS_Friends_QueryFriendsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_QueryFriendsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_QueryFriendsOptions implements Structure.ByValue {
	}
}