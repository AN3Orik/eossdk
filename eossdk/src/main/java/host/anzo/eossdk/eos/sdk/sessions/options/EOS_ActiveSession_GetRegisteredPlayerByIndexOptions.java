package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_ActiveSession_GetRegisteredPlayerByIndex function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "PlayerIndex"})
public class EOS_ActiveSession_GetRegisteredPlayerByIndexOptions extends Structure {
	/** The most recent version of the EOS_ActiveSession_GetRegisteredPlayerByIndex function. */
	public static final int EOS_ACTIVESESSION_GETREGISTEREDPLAYERBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_ACTIVESESSION_GETREGISTEREDPLAYERBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Index of the registered player to retrieve */
	public int PlayerIndex;

	public EOS_ActiveSession_GetRegisteredPlayerByIndexOptions() {
		super();
		ApiVersion = EOS_ACTIVESESSION_GETREGISTEREDPLAYERBYINDEX_API_LATEST;
	}

	public EOS_ActiveSession_GetRegisteredPlayerByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_ActiveSession_GetRegisteredPlayerByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ActiveSession_GetRegisteredPlayerByIndexOptions implements Structure.ByValue {
	}
}