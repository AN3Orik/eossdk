package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

/**
 * Input parameters for the {@link EOSLibrary#EOS_Lobby_AddNotifyLeaveLobbyRequested} function.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ApiVersion"})
public class EOS_Lobby_AddNotifyLeaveLobbyRequestedOptions extends Structure {
	/** The most recent version of the EOS_Lobby_AddNotifyLeaveLobbyRequested API. */
	public static final int EOS_LOBBY_ADDNOTIFYLEAVELOBBYREQUESTED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_ADDNOTIFYLEAVELOBBYREQUESTED_API_LATEST}. */
	public int ApiVersion;

	public EOS_Lobby_AddNotifyLeaveLobbyRequestedOptions() {
		super();
		ApiVersion = EOS_LOBBY_ADDNOTIFYLEAVELOBBYREQUESTED_API_LATEST;
	}

	public EOS_Lobby_AddNotifyLeaveLobbyRequestedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_AddNotifyLeaveLobbyRequestedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_AddNotifyLeaveLobbyRequestedOptions implements Structure.ByValue {
	}
}