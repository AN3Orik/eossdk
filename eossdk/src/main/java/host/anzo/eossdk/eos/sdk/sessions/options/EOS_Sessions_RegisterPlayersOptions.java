package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_RegisterPlayers function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "PlayersToRegister", "PlayersToRegisterCount"})
public class EOS_Sessions_RegisterPlayersOptions extends Structure {
	public static final int EOS_SESSIONS_REGISTERPLAYERS_API_LATEST = 3;

	/** API Version: Set this to EOS_SESSIONS_REGISTERPLAYERS_API_LATEST. */
	public int ApiVersion;
	/** Name of the session for which to register players */
	public String SessionName;
	/** Array of players to register with the session */
	public EOS_ProductUserId PlayersToRegister; // TODO: Array
	/** Number of players in the array */
	public int PlayersToRegisterCount;

	public EOS_Sessions_RegisterPlayersOptions() {
		super();
		ApiVersion = EOS_SESSIONS_REGISTERPLAYERS_API_LATEST;
	}

	public EOS_Sessions_RegisterPlayersOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_RegisterPlayersOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_RegisterPlayersOptions implements Structure.ByValue {
	}
}
