package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_RemoveAttribute function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Key"})
public class EOS_LobbyModification_RemoveAttributeOptions extends Structure {
	/** The most recent version of the EOS_LobbyModification_RemoveAttribute API. */
	public static final int EOS_LOBBYMODIFICATION_REMOVEATTRIBUTE_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_REMOVEATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Name of the key */
	public String Key;

	public EOS_LobbyModification_RemoveAttributeOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_REMOVEATTRIBUTE_API_LATEST;
	}

	public EOS_LobbyModification_RemoveAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_RemoveAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_RemoveAttributeOptions implements Structure.ByValue {
	}
}