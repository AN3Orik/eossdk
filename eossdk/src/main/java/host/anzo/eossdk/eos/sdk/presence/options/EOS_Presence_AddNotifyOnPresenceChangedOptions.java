package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Presence_AddNotifyOnPresenceChanged function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Presence_AddNotifyOnPresenceChangedOptions extends Structure {
	public static final int EOS_PRESENCE_ADDNOTIFYONPRESENCECHANGED_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_ADDNOTIFYONPRESENCECHANGED_API_LATEST. */
	public int ApiVersion;

	public EOS_Presence_AddNotifyOnPresenceChangedOptions() {
		super();
		ApiVersion = EOS_PRESENCE_ADDNOTIFYONPRESENCECHANGED_API_LATEST;
	}

	public EOS_Presence_AddNotifyOnPresenceChangedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_AddNotifyOnPresenceChangedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_AddNotifyOnPresenceChangedOptions implements Structure.ByValue {
	}
}