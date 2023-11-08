package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_UnregisterPlayers function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "PlayersToUnregister", "PlayersToUnregisterCount"})
public class EOS_Sessions_UnregisterPlayersOptions extends Structure {
	/** The most recent version of the EOS_Sessions_UnregisterPlayers API. */
	public static final int EOS_SESSIONS_UNREGISTERPLAYERS_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_SESSIONS_UNREGISTERPLAYERS_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session for which to unregister players */
	public String SessionName;
	/** Array of players to unregister from the session */
	public EOS_ProductUserId PlayersToUnregister; // TODO: Array
	/** Number of players in the array */
	public int PlayersToUnregisterCount;

	public EOS_Sessions_UnregisterPlayersOptions() {
		super();
		ApiVersion = EOS_SESSIONS_UNREGISTERPLAYERS_API_LATEST;
	}

	public EOS_Sessions_UnregisterPlayersOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_UnregisterPlayersOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_UnregisterPlayersOptions implements Structure.ByValue {
	}
}