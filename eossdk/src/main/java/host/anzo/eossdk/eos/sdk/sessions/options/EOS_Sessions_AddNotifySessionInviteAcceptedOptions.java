package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_AddNotifySessionInviteAccepted function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Sessions_AddNotifySessionInviteAcceptedOptions extends Structure {
	public static final int EOS_SESSIONS_ADDNOTIFYSESSIONINVITEACCEPTED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_ADDNOTIFYSESSIONINVITEACCEPTED_API_LATEST}. */
	public int ApiVersion;

	public EOS_Sessions_AddNotifySessionInviteAcceptedOptions() {
		super();
		ApiVersion = EOS_SESSIONS_ADDNOTIFYSESSIONINVITEACCEPTED_API_LATEST;
	}

	public EOS_Sessions_AddNotifySessionInviteAcceptedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_AddNotifySessionInviteAcceptedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_AddNotifySessionInviteAcceptedOptions implements Structure.ByValue {
	}
}