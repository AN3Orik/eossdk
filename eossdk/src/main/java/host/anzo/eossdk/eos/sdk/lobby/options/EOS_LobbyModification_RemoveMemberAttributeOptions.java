package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_RemoveMemberAttribute function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Key"})
public class EOS_LobbyModification_RemoveMemberAttributeOptions extends Structure {
	/** The most recent version of the EOS_LobbyModification_RemoveMemberAttribute API. */
	public static final int EOS_LOBBYMODIFICATION_REMOVEMEMBERATTRIBUTE_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_REMOVEMEMBERATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Name of the key */
	public String Key;

	public EOS_LobbyModification_RemoveMemberAttributeOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_REMOVEMEMBERATTRIBUTE_API_LATEST;
	}

	public EOS_LobbyModification_RemoveMemberAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_RemoveMemberAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_RemoveMemberAttributeOptions implements Structure.ByValue {
	}
}