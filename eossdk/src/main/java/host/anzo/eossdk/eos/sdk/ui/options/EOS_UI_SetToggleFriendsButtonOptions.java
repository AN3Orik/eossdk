package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EInputStateButtonFlags;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_SetToggleFriendsButton function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "ButtonCombination"})
public class EOS_UI_SetToggleFriendsButtonOptions extends Structure {
	/** The most recent version of the EOS_UI_SetToggleFriendsButton API. */
	public static final int EOS_UI_SETTOGGLEFRIENDSBUTTON_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SETTOGGLEFRIENDSBUTTON_API_LATEST. */
	public int ApiVersion;

	/**
	 * The new button which will be used to toggle the friends overlay.
	 * It can be any combination of buttons.
	 * A value of EOS_UISBF_None will cause the button to revert to the default.
	 * @see EOS_UI_EInputStateButtonFlags
	 */
	public int ButtonCombination;

	public EOS_UI_SetToggleFriendsButtonOptions() {
		super();
		ApiVersion = EOS_UI_SETTOGGLEFRIENDSBUTTON_API_LATEST;
	}

	public EOS_UI_SetToggleFriendsButtonOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_SetToggleFriendsButtonOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_SetToggleFriendsButtonOptions implements Structure.ByValue {
	}
}
