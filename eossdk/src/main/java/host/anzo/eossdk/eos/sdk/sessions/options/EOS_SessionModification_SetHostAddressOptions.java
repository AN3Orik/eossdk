package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionModification_SetHostAddress function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "HostAddress"})
public class EOS_SessionModification_SetHostAddressOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETHOSTADDRESS_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_SETHOSTADDRESS_API_LATEST. */
	public int ApiVersion;
	/** A string representing the host address for the session, its meaning is up to the application */
	public String HostAddress;

	public EOS_SessionModification_SetHostAddressOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETHOSTADDRESS_API_LATEST;
	}

	public EOS_SessionModification_SetHostAddressOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetHostAddressOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetHostAddressOptions implements Structure.ByValue {
	}
}
