package host.anzo.eossdk.eos.sdk.stats.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for querying a player's stats request.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_Stats_OnQueryStatsCompleteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_InvalidUser} if target user ID is missing or incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Stats_QueryStats */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID whose stats which were retrieved */
	public EOS_ProductUserId TargetUserId;

	public EOS_Stats_OnQueryStatsCompleteCallbackInfo() {
		super();
	}

	public EOS_Stats_OnQueryStatsCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_OnQueryStatsCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_OnQueryStatsCompleteCallbackInfo implements Structure.ByValue {
	}
}