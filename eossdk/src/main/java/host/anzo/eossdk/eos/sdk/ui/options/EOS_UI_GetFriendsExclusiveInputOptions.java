package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_GetFriendsExclusiveInput function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_UI_GetFriendsExclusiveInputOptions extends Structure {
	/** The most recent version of the EOS_UI_GetFriendsExclusiveInput API. */
	public static final int EOS_UI_GETFRIENDSEXCLUSIVEINPUT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_UI_GETFRIENDSEXCLUSIVEINPUT_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the user whose overlay is being checked. */
	public EOS_EpicAccountId LocalUserId;

	public EOS_UI_GetFriendsExclusiveInputOptions() {
		super();
		ApiVersion = EOS_UI_GETFRIENDSEXCLUSIVEINPUT_API_LATEST;
	}

	public EOS_UI_GetFriendsExclusiveInputOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_GetFriendsExclusiveInputOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_GetFriendsExclusiveInputOptions implements Structure.ByValue {
	}
}
