package host.anzo.eossdk.eos.sdk.reports.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Reports_SendPlayerBehaviorReport function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Reports_SendPlayerBehaviorReport. */
	public Pointer ClientData;

	public EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo() {
		super();
	}

	public EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo implements Structure.ByValue {
	}
}