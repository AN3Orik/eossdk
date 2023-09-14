package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.enums.EOS_ELobbyAttributeVisibility;

import static com.sun.jna.Structure.FieldOrder;

/**
 *  An attribute and its visibility setting stored with a lobby.
 *  Used to store both lobby and lobby member data
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "Data", "Visibility"})
public class EOS_Lobby_Attribute extends Structure implements AutoCloseable {
	public static final int EOS_LOBBY_ATTRIBUTE_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_ATTRIBUTE_API_LATEST. */
	public int ApiVersion;

	/** Key/Value pair describing the attribute */
	public EOS_Lobby_AttributeData.ByReference Data;
	/** Is this attribute public or private to the lobby and its members */
	public EOS_ELobbyAttributeVisibility Visibility;

	public EOS_Lobby_Attribute() {
		super();
		ApiVersion = EOS_LOBBY_ATTRIBUTE_API_LATEST;
	}

	public EOS_Lobby_Attribute(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOS_LobbyDetails.releaseLobbyAttribute(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Lobby_Attribute implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_Attribute implements Structure.ByValue {
	}
}