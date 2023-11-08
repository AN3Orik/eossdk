package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName"})
public class EOS_Sessions_EndSessionOptions extends Structure {
	public static final int EOS_SESSIONS_ENDSESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_ENDSESSION_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session to set as no long in progress */
	public String SessionName;

	public EOS_Sessions_EndSessionOptions() {
		super();
		ApiVersion = EOS_SESSIONS_ENDSESSION_API_LATEST;
	}

	public EOS_Sessions_EndSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_EndSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_EndSessionOptions implements Structure.ByValue {
	}
}