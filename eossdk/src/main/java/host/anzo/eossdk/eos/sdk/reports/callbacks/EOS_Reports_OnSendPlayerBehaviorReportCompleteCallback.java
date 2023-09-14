package host.anzo.eossdk.eos.sdk.reports.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.reports.callbackresults.EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public interface EOS_Reports_OnSendPlayerBehaviorReportCompleteCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Reports_SendPlayerBehaviorReport.
	 * @param data A EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo containing the output information and result.
	 */
	void apply(EOS_Reports_SendPlayerBehaviorReportCompleteCallbackInfo data);
}