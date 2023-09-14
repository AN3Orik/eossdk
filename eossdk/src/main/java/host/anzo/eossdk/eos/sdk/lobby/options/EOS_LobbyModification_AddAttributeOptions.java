package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.EOS_Lobby_AttributeData;
import host.anzo.eossdk.eos.sdk.lobby.enums.EOS_ELobbyAttributeVisibility;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_AddAttribute function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Attribute", "Visibility"})
public class EOS_LobbyModification_AddAttributeOptions extends Structure {
	public static final int EOS_LOBBYMODIFICATION_ADDATTRIBUTE_API_LATEST = 2;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_ADDATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Key/Value pair describing the attribute to add to the lobby */
	public EOS_Lobby_AttributeData.ByReference Attribute;
	/** Is this attribute public or private to the lobby and its members */
	public EOS_ELobbyAttributeVisibility Visibility;

	public EOS_LobbyModification_AddAttributeOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_ADDATTRIBUTE_API_LATEST;
	}

	public EOS_LobbyModification_AddAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_AddAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_AddAttributeOptions implements Structure.ByValue {
	}
}