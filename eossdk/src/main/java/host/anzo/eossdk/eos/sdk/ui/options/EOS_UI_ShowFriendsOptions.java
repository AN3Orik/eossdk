package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_ShowFriends function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_UI_ShowFriendsOptions extends Structure {
	/** The most recent version of the EOS_UI_ShowFriends API. */
	public static final int EOS_UI_SHOWFRIENDS_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SHOWFRIENDS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user whose friend list is being shown. */
	public EOS_EpicAccountId LocalUserId;

	public EOS_UI_ShowFriendsOptions() {
		super();
		ApiVersion = EOS_UI_SHOWFRIENDS_API_LATEST;
	}

	public EOS_UI_ShowFriendsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowFriendsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowFriendsOptions implements Structure.ByValue {
	}
}
