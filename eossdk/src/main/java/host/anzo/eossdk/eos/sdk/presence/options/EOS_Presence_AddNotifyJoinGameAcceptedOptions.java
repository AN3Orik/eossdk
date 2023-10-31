package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Presence_AddNotifyJoinGameAcceptedOptions extends Structure {
	/** The most recent version of the EOS_Presence_AddNotifyJoinGameAccepted API. */
	public static final int EOS_PRESENCE_ADDNOTIFYJOINGAMEACCEPTED_API_LATEST = 2;

	/** API Version: Set this to EOS_PRESENCE_ADDNOTIFYJOINGAMEACCEPTED_API_LATEST. */
	public int ApiVersion;

	public EOS_Presence_AddNotifyJoinGameAcceptedOptions() {
		super();
		ApiVersion = EOS_PRESENCE_ADDNOTIFYJOINGAMEACCEPTED_API_LATEST;
	}

	public EOS_Presence_AddNotifyJoinGameAcceptedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_AddNotifyJoinGameAcceptedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_AddNotifyJoinGameAcceptedOptions implements Structure.ByValue {
	}
}