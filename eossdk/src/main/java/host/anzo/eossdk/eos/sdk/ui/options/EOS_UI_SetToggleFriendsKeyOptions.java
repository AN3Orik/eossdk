package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EKeyCombination;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_SetToggleFriendsKey function.
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "KeyCombination"})
public class EOS_UI_SetToggleFriendsKeyOptions extends Structure {
	/** The most recent version of the EOS_UI_SetToggleFriendsKey API. */
	public static final int EOS_UI_SETTOGGLEFRIENDSKEY_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SETTOGGLEFRIENDSKEY_API_LATEST. */
	public int ApiVersion;
	/**
	 * The new key combination which will be used to toggle the friends overlay.
	 * The combination can be any set of modifiers and one key.
	 * A value of EOS_UIK_None will cause the key to revert to the default.
	 * @see EOS_UI_EKeyCombination
	 */
	public int KeyCombination;

	public EOS_UI_SetToggleFriendsKeyOptions() {
		super();
		ApiVersion = EOS_UI_SETTOGGLEFRIENDSKEY_API_LATEST;
	}

	public EOS_UI_SetToggleFriendsKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_SetToggleFriendsKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_SetToggleFriendsKeyOptions implements Structure.ByValue {
	}
}
