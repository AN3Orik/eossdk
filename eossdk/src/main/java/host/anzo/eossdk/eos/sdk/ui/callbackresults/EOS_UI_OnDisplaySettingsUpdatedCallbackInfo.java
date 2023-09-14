package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ClientData", "bIsVisible", "bIsExclusiveInput"})
public class EOS_UI_OnDisplaySettingsUpdatedCallbackInfo extends Structure {
	/** Context that was passed into EOS_UI_AddNotifyDisplaySettingsUpdated */
	public Pointer ClientData;
	/** True when any portion of the overlay is visible. */
	public int bIsVisible;
	/**
	 * True when the overlay has switched to exclusive input mode.
	 * While in exclusive input mode, no keyboard or mouse input will be sent to the game.
	 */
	public int bIsExclusiveInput;

	public EOS_UI_OnDisplaySettingsUpdatedCallbackInfo() {
		super();
	}

	public EOS_UI_OnDisplaySettingsUpdatedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_OnDisplaySettingsUpdatedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_OnDisplaySettingsUpdatedCallbackInfo implements Structure.ByValue {
	}
}