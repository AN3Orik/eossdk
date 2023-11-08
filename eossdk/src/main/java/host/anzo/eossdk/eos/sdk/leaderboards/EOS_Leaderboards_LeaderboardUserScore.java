package host.anzo.eossdk.eos.sdk.leaderboards;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Leaderboards_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.leaderboards.options.EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions;
import host.anzo.eossdk.eos.sdk.leaderboards.options.EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single leaderboard user score
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "UserId", "Score"})
public class EOS_Leaderboards_LeaderboardUserScore extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Leaderboards_LeaderboardUserScore struct. */
	public static final int EOS_LEADERBOARDS_LEADERBOARDUSERSCORE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_LEADERBOARDUSERSCORE_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user who got this score */
	public EOS_ProductUserId UserId;
	/** Leaderboard score */
	public int Score;

	public EOS_Leaderboards_LeaderboardUserScore() {
		super();
		ApiVersion = EOS_LEADERBOARDS_LEADERBOARDUSERSCORE_API_LATEST;
	}

	public EOS_Leaderboards_LeaderboardUserScore(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with leaderboard user score. This must be called on data retrieved from
	 * EOS_Leaderboards_CopyLeaderboardUserScoreByIndex or EOS_Leaderboards_CopyLeaderboardUserScoreByUserId.
	 *
	 * @see EOS_Leaderboards_LeaderboardUserScore
	 * @see EOS_Leaderboards_Interface#copyLeaderboardUserScoreByIndex(EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions)
	 * @see EOS_Leaderboards_Interface#copyLeaderboardUserScoreByUserId(EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Leaderboards_LeaderboardUserScore_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Leaderboards_LeaderboardUserScore implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_LeaderboardUserScore implements Structure.ByValue {
	}
}