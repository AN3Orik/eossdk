package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_ENotificationLocation;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_SetDisplayPreference function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "NotificationLocation"})
public class EOS_UI_SetDisplayPreferenceOptions extends Structure {
	/** The most recent version of the EOS_UI_SetDisplayPreference API. */
	public static final int EOS_UI_SETDISPLAYPREFERENCE_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SETDISPLAYPREFERENCE_API_LATEST. */
	public int ApiVersion;
	/** Preference for notification pop-up locations. */
	public EOS_UI_ENotificationLocation NotificationLocation;

	public EOS_UI_SetDisplayPreferenceOptions() {
		super();
		ApiVersion = EOS_UI_SETDISPLAYPREFERENCE_API_LATEST;
	}

	public EOS_UI_SetDisplayPreferenceOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_SetDisplayPreferenceOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_SetDisplayPreferenceOptions implements Structure.ByValue {
	}
}