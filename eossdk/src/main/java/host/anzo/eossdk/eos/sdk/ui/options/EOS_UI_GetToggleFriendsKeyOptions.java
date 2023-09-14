package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_GetToggleFriendsKey function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_UI_GetToggleFriendsKeyOptions extends Structure {
	/** API Version: Set this to EOS_UI_GETTOGGLEFRIENDSKEY_API_LATEST. */
	public int ApiVersion;

	public EOS_UI_GetToggleFriendsKeyOptions() {
		super();
	}

	public EOS_UI_GetToggleFriendsKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_GetToggleFriendsKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_GetToggleFriendsKeyOptions implements Structure.ByValue {
	}
}