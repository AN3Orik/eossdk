package host.anzo.eossdk.eos.sdk.leaderboards.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Leaderboards_CopyLeaderboardRecordByUserId function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "UserId"})
public class EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions extends Structure {
	/** The most recent version of the EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions struct. */
	public static final int EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYUSERID_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYUSERID_API_LATEST}. */
	public int ApiVersion;
	/** Leaderboard data will be copied from the cache if it relates to the user matching this Product User ID */
	public EOS_ProductUserId UserId;

	public EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions() {
		super();
		ApiVersion = EOS_LEADERBOARDS_COPYLEADERBOARDRECORDBYUSERID_API_LATEST;
	}

	public EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions implements Structure.ByValue {
	}
}
