package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionModification_SetInvitesAllowed function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "IsInvitesAllowed"})
public class EOS_SessionModification_SetInvitesAllowedOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETINVITESALLOWED_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_SETINVITESALLOWED_API_LATEST. */
	public int ApiVersion;
	/** If true then invites can currently be sent for the associated session */
	public EOS_Bool IsInvitesAllowed;

	public EOS_SessionModification_SetInvitesAllowedOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETINVITESALLOWED_API_LATEST;
	}

	public EOS_SessionModification_SetInvitesAllowedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetInvitesAllowedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetInvitesAllowedOptions implements Structure.ByValue {
	}
}