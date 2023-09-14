package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_SetInvitesAllowed Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "bInvitesAllowed"})
public class EOS_LobbyModification_SetInvitesAllowedOptions extends Structure {
	public static final int EOS_LOBBYMODIFICATION_SETINVITESALLOWED_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_SETINVITESALLOWED_API_LATEST. */
	public int ApiVersion;
	/** If true then invites can currently be sent for the associated lobby */
	public int bInvitesAllowed;

	public EOS_LobbyModification_SetInvitesAllowedOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_SETINVITESALLOWED_API_LATEST;
	}

	public EOS_LobbyModification_SetInvitesAllowedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_SetInvitesAllowedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_SetInvitesAllowedOptions implements Structure.ByValue {
	}
}