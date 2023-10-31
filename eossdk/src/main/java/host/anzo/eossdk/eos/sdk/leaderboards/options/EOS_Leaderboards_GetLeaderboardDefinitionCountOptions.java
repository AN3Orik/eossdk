package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_GetLeaderboardDefinitionCount function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Leaderboards_GetLeaderboardDefinitionCountOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_GetLeaderboardDefinitionCount API. */
	public static final int EOS_LEADERBOARDS_GETLEADERBOARDDEFINITIONCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_GETLEADERBOARDDEFINITIONCOUNT_API_LATEST. */
	public int ApiVersion;

	public EOS_Leaderboards_GetLeaderboardDefinitionCountOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_GETLEADERBOARDDEFINITIONCOUNT_API_LATEST;
	}

	public EOS_Leaderboards_GetLeaderboardDefinitionCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_GetLeaderboardDefinitionCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_GetLeaderboardDefinitionCountOptions implements Structure.ByValue {
	}
}