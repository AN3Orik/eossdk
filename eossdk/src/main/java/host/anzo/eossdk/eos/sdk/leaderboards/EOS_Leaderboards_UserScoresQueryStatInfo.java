package host.anzo.eossdk.eos.sdk.leaderboards;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.leaderboards.enums.EOS_ELeaderboardAggregation;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single stat to query with user scores.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "StatName", "Aggregation"})
public class EOS_Leaderboards_UserScoresQueryStatInfo extends Structure {
	/** The most recent version of the EOS_Leaderboards_UserScoresQueryStatInfo struct. */
	public static final int EOS_LEADERBOARDS_USERSCORESQUERYSTATINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_USERSCORESQUERYSTATINFO_API_LATEST. */
	public int ApiVersion;
	/** The name of the stat to query. */
	public String StatName;
	/**
	 * Aggregation used to sort the cached user scores.
	 */
	public EOS_ELeaderboardAggregation Aggregation;

	public EOS_Leaderboards_UserScoresQueryStatInfo() {
		super();
		ApiVersion = EOS_LEADERBOARDS_USERSCORESQUERYSTATINFO_API_LATEST;
	}

	public EOS_Leaderboards_UserScoresQueryStatInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_UserScoresQueryStatInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_UserScoresQueryStatInfo implements Structure.ByValue {
	}
}