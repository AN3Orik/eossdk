package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.EOS_Lobby_AttributeData;
import host.anzo.eossdk.eos.sdk.lobby.enums.EOS_ELobbyAttributeVisibility;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_AddMemberAttribute function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Attribute", "Visibility"})
public class EOS_LobbyModification_AddMemberAttributeOptions extends Structure {
	/** The most recent version of the EOS_LobbyModification_AddMemberAttribute API. */
	public static final int EOS_LOBBYMODIFICATION_ADDMEMBERATTRIBUTE_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_LOBBYMODIFICATION_ADDMEMBERATTRIBUTE_API_LATEST}. */
	public int ApiVersion;
	/** Key/Value pair describing the attribute to add to the lobby member */
	public EOS_Lobby_AttributeData.ByReference Attribute;
	/** Is this attribute public or private to the rest of the lobby members */
	public EOS_ELobbyAttributeVisibility Visibility;

	public EOS_LobbyModification_AddMemberAttributeOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_ADDMEMBERATTRIBUTE_API_LATEST;
	}

	public EOS_LobbyModification_AddMemberAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_AddMemberAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_AddMemberAttributeOptions implements Structure.ByValue {
	}
}