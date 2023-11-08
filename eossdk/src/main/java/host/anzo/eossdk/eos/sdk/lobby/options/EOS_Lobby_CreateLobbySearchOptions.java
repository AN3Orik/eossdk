package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_CreateLobbySearch function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "MaxResults"})
public class EOS_Lobby_CreateLobbySearchOptions extends Structure {
	/** The most recent version of the EOS_Lobby_CreateLobbySearch API. */
	public static final int EOS_LOBBY_CREATELOBBYSEARCH_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_CREATELOBBYSEARCH_API_LATEST}. */
	public int ApiVersion;
	/** Maximum number of results allowed from the search */
	public int MaxResults;

	public EOS_Lobby_CreateLobbySearchOptions() {
		super();
		ApiVersion = EOS_LOBBY_CREATELOBBYSEARCH_API_LATEST;
	}

	public EOS_Lobby_CreateLobbySearchOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CreateLobbySearchOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_CreateLobbySearchOptions implements Structure.ByValue {
	}
}