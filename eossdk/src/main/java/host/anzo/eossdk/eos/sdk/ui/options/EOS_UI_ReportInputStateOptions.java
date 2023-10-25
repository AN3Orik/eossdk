package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EInputStateButtonFlags;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_ReportInputState function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "ButtonDownFlags", "IsAcceptIsFaceButtonRight", "IsMouseButtonDown", "MousePosX", "MousePosY", "GamepadIndex", "LeftStickX", "LeftStickY", "RightStickX", "RightStickY", "LeftTrigger", "RightTrigger"})
public class EOS_UI_ReportInputStateOptions extends Structure {
	/** The most recent version of the EOS_UI_ReportInputState API. */
	public static final int EOS_UI_REPORTINPUTSTATE_API_LATEST = 2;

	/** API Version: Set this to EOS_UI_REPORTINPUTSTATE_API_LATEST. */
	public int ApiVersion;
	/**
	 * Flags to identify the current buttons which are pressed.
	 * @see EOS_UI_EInputStateButtonFlags
	 */
	public int ButtonDownFlags;
	/**
	 * Whether the current platform and configuration uses the right face button as the default accept button.
	 * When this flag is true, the right face button is the accept action, and the down face button is the cancel action.
	 * When this flag is false, the right face button is the cancel action, and the down face button is the accept action.
	 */
	public EOS_Bool IsAcceptIsFaceButtonRight;
	/** The current state of the mouse button. */
	public EOS_Bool IsMouseButtonDown;
	/** The current x-position of the mouse. */
	public int MousePosX;
	/** The current y-position of the mouse. */
	public int MousePosY;
	/** The gamepad or player index */
	public int GamepadIndex;
	/** Left analog stick horizontal movement in [-1, 1]. Negative for left, positive for right */
	public float LeftStickX;
	/** Left analog stick vertical movement in [-1, 1]. Negative for up, positive for down */
	public float LeftStickY;
	/** Right analog stick horizontal movement in [-1, 1]. Negative for left, positive for right */
	public float RightStickX;
	/** Right analog stick vertical movement in [-1, 1]. Negative for up, positive for down */
	public float RightStickY;
	/** Left trigger analog value in [0, 1] */
	public float LeftTrigger;
	/** Right trigger analog value in [0, 1] */
	public float RightTrigger;

	public EOS_UI_ReportInputStateOptions() {
		super();
		ApiVersion = EOS_UI_REPORTINPUTSTATE_API_LATEST;
	}

	public EOS_UI_ReportInputStateOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ReportInputStateOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ReportInputStateOptions implements Structure.ByValue {
	}
}