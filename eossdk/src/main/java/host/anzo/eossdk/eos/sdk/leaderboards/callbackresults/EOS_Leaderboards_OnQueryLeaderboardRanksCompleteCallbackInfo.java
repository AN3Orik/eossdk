package host.anzo.eossdk.eos.sdk.leaderboards.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for a query leaderboard ranks request.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Leaderboards_QueryLeaderboardRanks. */
	public Pointer ClientData;

	public EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo() {
		super();
	}

	public EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallbackInfo implements Structure.ByValue {
	}
}