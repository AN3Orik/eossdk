package host.anzo.eossdk.eos.sdk.stats.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_Stats_IngestStatCompleteCallbackInfo extends Structure {
	/**
	 * Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error.<br>
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_InvalidUser} if target user ID is missing or incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Stats_IngestStat. */
	public Pointer ClientData;
	/** The Product User ID for the user requesting the ingest */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID for the user whose stat is being ingested */
	public EOS_ProductUserId TargetUserId;

	public EOS_Stats_IngestStatCompleteCallbackInfo() {
		super();
	}

	public EOS_Stats_IngestStatCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Stats_IngestStatCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_IngestStatCompleteCallbackInfo implements Structure.ByValue {
	}
}