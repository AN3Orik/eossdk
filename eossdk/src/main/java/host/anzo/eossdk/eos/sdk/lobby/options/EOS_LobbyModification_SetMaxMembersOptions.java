package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_SetMaxMembers function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "MaxMembers"})
public class EOS_LobbyModification_SetMaxMembersOptions extends Structure {
	public static final int EOS_LOBBYMODIFICATION_SETMAXMEMBERS_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_SETMAXMEMBERS_API_LATEST. */
	public int ApiVersion;
	/** New maximum number of lobby members */
	public int MaxMembers;

	public EOS_LobbyModification_SetMaxMembersOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_SETMAXMEMBERS_API_LATEST;
	}

	public EOS_LobbyModification_SetMaxMembersOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_SetMaxMembersOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_SetMaxMembersOptions implements Structure.ByValue {
	}
}
