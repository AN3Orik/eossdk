package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.enums.EOS_ELobbyPermissionLevel;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_SetPermissionLevel function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "PermissionLevel"})
public class EOS_LobbyModification_SetPermissionLevelOptions extends Structure {
	/** The most recent version of the EOS_LobbyModification_SetPermissionLevel API. */
	public static final int EOS_LOBBYMODIFICATION_SETPERMISSIONLEVEL_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_SETPERMISSIONLEVEL_API_LATEST. */
	public int ApiVersion;
	/** Permission level of the lobby */
	public EOS_ELobbyPermissionLevel PermissionLevel;

	public EOS_LobbyModification_SetPermissionLevelOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_SETPERMISSIONLEVEL_API_LATEST;
	}

	public EOS_LobbyModification_SetPermissionLevelOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_SetPermissionLevelOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_SetPermissionLevelOptions implements Structure.ByValue {
	}
}