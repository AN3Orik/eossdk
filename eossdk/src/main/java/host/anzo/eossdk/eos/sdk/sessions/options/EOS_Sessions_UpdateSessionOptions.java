package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionModificationHandle"})
public class EOS_Sessions_UpdateSessionOptions extends Structure {
	public static final int EOS_SESSIONS_UPDATESESSION_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_UPDATESESSION_API_LATEST. */
	public int ApiVersion;
	/** Builder handle */
	public EOS_SessionModification SessionModificationHandle;

	public EOS_Sessions_UpdateSessionOptions() {
		super();
		ApiVersion = EOS_SESSIONS_UPDATESESSION_API_LATEST;
	}

	public EOS_Sessions_UpdateSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_UpdateSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_UpdateSessionOptions implements Structure.ByValue {
	}
}