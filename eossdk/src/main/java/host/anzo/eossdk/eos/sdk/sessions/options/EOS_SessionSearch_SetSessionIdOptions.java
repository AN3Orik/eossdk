package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_SetSessionId function.
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "SessionId"})
public class EOS_SessionSearch_SetSessionIdOptions extends Structure {
	public static final int EOS_SESSIONSEARCH_SETSESSIONID_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONSEARCH_SETSESSIONID_API_LATEST. */
	public int ApiVersion;
	/** Search sessions for a specific session ID, returning at most one session */
	public String SessionId;

	public EOS_SessionSearch_SetSessionIdOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_SETSESSIONID_API_LATEST;
	}

	public EOS_SessionSearch_SetSessionIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_SetSessionIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_SetSessionIdOptions implements Structure.ByValue {
	}
}
