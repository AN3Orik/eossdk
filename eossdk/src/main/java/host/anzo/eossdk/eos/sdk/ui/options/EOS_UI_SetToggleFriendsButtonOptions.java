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

	/** API Version: Set this to {@link #EOS_UI_SETTOGGLEFRIENDSBUTTON_API_LATEST}. */
	public int ApiVersion;

	/**
	 * The button combination to toggle the friends-list page.
	 * It can be any combination of the following buttons (which can include the left or right shoulder buttons (EOS_UISBF_LeftShoulder or EOS_UISBF_RightShoulder)):
	 * <pre>
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_LeftTrigger}
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_RightTrigger}
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_Special_Left}
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_Special_Right}
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_LeftThumbstick}
	 * - {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_RightThumbstick}
	 * </pre>
	 * The default value is No Button. Set the value to {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_None} to revert to the default.
	 */
	public EOS_UI_EInputStateButtonFlags ButtonCombination;

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
