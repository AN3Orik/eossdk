package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CopyActiveSessionHandle function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "SessionName"})
public class EOS_Sessions_CopyActiveSessionHandleOptions extends Structure {
	public static final int EOS_SESSIONS_COPYACTIVESESSIONHANDLE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_COPYACTIVESESSIONHANDLE_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session for which to retrieve a session handle */
	public String SessionName;

	public EOS_Sessions_CopyActiveSessionHandleOptions() {
		super();
		ApiVersion = EOS_SESSIONS_COPYACTIVESESSIONHANDLE_API_LATEST;
	}

	public EOS_Sessions_CopyActiveSessionHandleOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CopyActiveSessionHandleOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CopyActiveSessionHandleOptions implements Structure.ByValue {
	}
}