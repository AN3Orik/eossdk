package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "LobbyId"})
public class EOS_LobbySearch_SetLobbyIdOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_SetLobbyId API. */
	public static final int EOS_LOBBYSEARCH_SETLOBBYID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_SETLOBBYID_API_LATEST}. */
	public int ApiVersion;

	/** The ID of the lobby to find */
	public String LobbyId;

	public EOS_LobbySearch_SetLobbyIdOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_SETLOBBYID_API_LATEST;
	}

	public EOS_LobbySearch_SetLobbyIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_SetLobbyIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_SetLobbyIdOptions implements Structure.ByValue {
	}
}