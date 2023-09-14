package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_RejectInvite function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "InviteId"})
public class EOS_Sessions_RejectInviteOptions extends Structure {
	public static final int EOS_SESSIONS_REJECTINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_REJECTINVITE_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user rejecting the invitation */
	public EOS_ProductUserId LocalUserId;
	/** The invite ID to reject */
	public String InviteId;

	public EOS_Sessions_RejectInviteOptions() {
		super();
		ApiVersion = EOS_SESSIONS_REJECTINVITE_API_LATEST;
	}

	public EOS_Sessions_RejectInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_RejectInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_RejectInviteOptions implements Structure.ByValue {
	}
}