package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_SendInvite function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "LocalUserId", "TargetUserId"})
public class EOS_Sessions_SendInviteOptions extends Structure {
	public static final int EOS_SESSIONS_SENDINVITE_API_LATEST = 1;

	/** Max length of an invite ID */
	public static final int EOS_SESSIONS_INVITEID_MAX_LENGTH = 64;

	/** API Version: Set this to EOS_SESSIONS_SENDINVITE_API_LATEST. */
	public int ApiVersion;
	/** Name of the session associated with the invite */
	public String SessionName;
	/** The Product User ID of the local user sending the invitation */
	public EOS_ProductUserId LocalUserId;
	/** The Product User of the remote user receiving the invitation */
	public EOS_ProductUserId TargetUserId;

	public EOS_Sessions_SendInviteOptions() {
		super();
		ApiVersion = EOS_SESSIONS_SENDINVITE_API_LATEST;
	}

	public EOS_Sessions_SendInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_SendInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_SendInviteOptions implements Structure.ByValue {
	}
}