package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionModification#setMaxPlayers(EOS_SessionModification_SetMaxPlayersOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "MaxPlayers"})
public class EOS_SessionModification_SetMaxPlayersOptions extends Structure {
	/** The most recent version of the EOS_SessionModification_SetMaxPlayers API. */
	public static int EOS_SESSIONMODIFICATION_SETMAXPLAYERS_API_LATEST = 1;

	/** Maximum number of players allowed in a single session */
	public static int EOS_SESSIONS_MAXREGISTEREDPLAYERS = 1000;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_SETMAXPLAYERS_API_LATEST. */
	public int ApiVersion;
	/** Max number of players to allow in the session */
	public int MaxPlayers;

	public EOS_SessionModification_SetMaxPlayersOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETMAXPLAYERS_API_LATEST;
	}

	public EOS_SessionModification_SetMaxPlayersOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetMaxPlayersOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetMaxPlayersOptions implements Structure.ByValue {
	}
}