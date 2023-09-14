package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CopySessionHandleByInviteId function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "InviteId"})
public class EOS_Sessions_CopySessionHandleByInviteIdOptions extends Structure {
	public static final int EOS_SESSIONS_COPYSESSIONHANDLEBYINVITEID_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_COPYSESSIONHANDLEBYINVITEID_API_LATEST. */
	public int ApiVersion;
	/** Invite ID for which to retrieve a session handle */
	public String InviteId;

	public EOS_Sessions_CopySessionHandleByInviteIdOptions() {
		super();
		ApiVersion = EOS_SESSIONS_COPYSESSIONHANDLEBYINVITEID_API_LATEST;
	}

	public EOS_Sessions_CopySessionHandleByInviteIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CopySessionHandleByInviteIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CopySessionHandleByInviteIdOptions implements Structure.ByValue {
	}
}
