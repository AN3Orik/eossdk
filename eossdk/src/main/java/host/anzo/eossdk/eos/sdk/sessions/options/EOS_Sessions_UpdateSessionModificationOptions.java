package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_UpdateSessionModification function.
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "SessionName"})
public class EOS_Sessions_UpdateSessionModificationOptions extends Structure {
	/** The most recent version of the EOS_Sessions_UpdateSessionModification API. */
	public static final int EOS_SESSIONS_UPDATESESSIONMODIFICATION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_UPDATESESSIONMODIFICATION_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session to update */
	public String SessionName;

	public EOS_Sessions_UpdateSessionModificationOptions() {
		super();
		ApiVersion = EOS_SESSIONS_UPDATESESSIONMODIFICATION_API_LATEST;
	}

	public EOS_Sessions_UpdateSessionModificationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_UpdateSessionModificationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_UpdateSessionModificationOptions implements Structure.ByValue {
	}
}