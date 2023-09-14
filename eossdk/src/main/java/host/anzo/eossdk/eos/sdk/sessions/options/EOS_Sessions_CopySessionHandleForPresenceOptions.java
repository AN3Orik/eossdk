package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CopySessionHandleForPresence function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Sessions_CopySessionHandleForPresenceOptions extends Structure {
	public static final int EOS_SESSIONS_COPYSESSIONHANDLEFORPRESENCE_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_COPYSESSIONHANDLEFORPRESENCE_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user associated with the session */
	public EOS_ProductUserId LocalUserId;

	public EOS_Sessions_CopySessionHandleForPresenceOptions() {
		super();
		ApiVersion = EOS_SESSIONS_COPYSESSIONHANDLEFORPRESENCE_API_LATEST;
	}

	public EOS_Sessions_CopySessionHandleForPresenceOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CopySessionHandleForPresenceOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CopySessionHandleForPresenceOptions implements Structure.ByValue {
	}
}