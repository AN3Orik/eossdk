package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_AddNotifyFriendsUpdate function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Friends_AddNotifyFriendsUpdateOptions extends Structure {
	public static final int EOS_FRIENDS_ADDNOTIFYFRIENDSUPDATE_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_ADDNOTIFYFRIENDSUPDATE_API_LATEST. */
	public int ApiVersion;

	public EOS_Friends_AddNotifyFriendsUpdateOptions() {
		super();
		ApiVersion = EOS_FRIENDS_ADDNOTIFYFRIENDSUPDATE_API_LATEST;
	}

	public EOS_Friends_AddNotifyFriendsUpdateOptions(int ApiVersion) {
		super();
		this.ApiVersion = ApiVersion;
	}

	public EOS_Friends_AddNotifyFriendsUpdateOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_AddNotifyFriendsUpdateOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_AddNotifyFriendsUpdateOptions implements Structure.ByValue {
	}
}