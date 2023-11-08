package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_CopyLobbyDetailsHandleByUiEventId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UiEventId"})
public class EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions extends Structure {
	/** The most recent version of the EOS_Lobby_CopyLobbyDetailsHandleByUiEventId API. */
	public static final int EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYUIEVENTID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYUIEVENTID_API_LATEST}. */
	public int ApiVersion;
	/** UI Event associated with the lobby */
	public long UiEventId;

	public EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions() {
		super();
		ApiVersion = EOS_LOBBY_COPYLOBBYDETAILSHANDLEBYUIEVENTID_API_LATEST;
	}

	public EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions implements Structure.ByReference {

	}

	public static class ByValue extends EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions implements Structure.ByValue {
	}
}