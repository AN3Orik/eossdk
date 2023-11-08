package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_AddNotifyDisplaySettingsUpdated function.
 *
 * @author Anton Lasevich
 * @since 9/8/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_UI_AddNotifyDisplaySettingsUpdatedOptions extends Structure {
	/** The most recent version of the EOS_UI_AddNotifyDisplaySettingsUpdated API. */
	public static final int EOS_UI_ADDNOTIFYDISPLAYSETTINGSUPDATED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_UI_ADDNOTIFYDISPLAYSETTINGSUPDATED_API_LATEST}. */
	public int ApiVersion;

	public EOS_UI_AddNotifyDisplaySettingsUpdatedOptions() {
		super();
		ApiVersion = EOS_UI_ADDNOTIFYDISPLAYSETTINGSUPDATED_API_LATEST;
	}

	public EOS_UI_AddNotifyDisplaySettingsUpdatedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_AddNotifyDisplaySettingsUpdatedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_AddNotifyDisplaySettingsUpdatedOptions implements Structure.ByValue {
	}
}