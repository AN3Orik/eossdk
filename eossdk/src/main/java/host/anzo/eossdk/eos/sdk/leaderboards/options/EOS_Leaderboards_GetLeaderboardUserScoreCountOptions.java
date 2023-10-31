package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_GetLeaderboardUserScoreCount function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "StatName"})
public class EOS_Leaderboards_GetLeaderboardUserScoreCountOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_GetLeaderboardUserScoreCount API. */
	public static final int EOS_LEADERBOARDS_GETLEADERBOARDUSERSCORECOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_GETLEADERBOARDUSERSCORECOUNT_API_LATEST. */
	public int ApiVersion;
	/** Name of stat used to rank leaderboard. */
	public String StatName;

	public EOS_Leaderboards_GetLeaderboardUserScoreCountOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_GETLEADERBOARDUSERSCORECOUNT_API_LATEST;
	}

	public EOS_Leaderboards_GetLeaderboardUserScoreCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_GetLeaderboardUserScoreCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_GetLeaderboardUserScoreCountOptions implements Structure.ByValue {
	}
}