package host.anzo.eossdk.eos.sdk.achievements.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for a query definitions request.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** User-defined context that was passed into EOS_Achievements_QueryDefinitions. */
	public Pointer ClientData;

	public EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo() {
		super();
	}

	public EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_OnQueryDefinitionsCompleteCallbackInfo implements Structure.ByValue {
	}
}