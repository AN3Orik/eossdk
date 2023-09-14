package host.anzo.eossdk.eos.sdk.leaderboards;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Leaderboards_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single leaderboard user score
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "UserId", "Score"})
public class EOS_Leaderboards_LeaderboardUserScore extends Structure implements AutoCloseable {
	public static final int EOS_LEADERBOARDS_LEADERBOARDUSERSCORE_API_LATEST = 1;

	/** API Version: Set this to EOS_LEADERBOARDS_LEADERBOARDUSERSCORE_API_LATEST. */
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

	public void release() {
		EOS_Leaderboards_Interface.releaseLeaderboardUserScore(this);
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