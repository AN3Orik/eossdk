package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_SetInvitesAllowed Function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "IsInvitesAllowed"})
public class EOS_LobbyModification_SetInvitesAllowedOptions extends Structure {
	/** The most recent version of the EOS_LobbyModification_SetInvitesAllowed API. */
	public static final int EOS_LOBBYMODIFICATION_SETINVITESALLOWED_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_SETINVITESALLOWED_API_LATEST. */
	public int ApiVersion;
	/** If true then invites can currently be sent for the associated lobby */
	public EOS_Bool IsInvitesAllowed;

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