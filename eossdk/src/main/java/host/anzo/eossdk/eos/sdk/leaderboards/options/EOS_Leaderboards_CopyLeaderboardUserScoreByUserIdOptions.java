package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardUserScoreByUserId function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "UserId", "StatName"})
public class EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions struct. */
	public static final int EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYUSERID_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYUSERID_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID to look for when copying leaderboard score data from the cache */
	public EOS_ProductUserId UserId;
	/** The name of the stat that is used to rank this leaderboard */
	public String StatName;

	public EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDUSERSCOREBYUSERID_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions implements Structure.ByValue {
	}
}