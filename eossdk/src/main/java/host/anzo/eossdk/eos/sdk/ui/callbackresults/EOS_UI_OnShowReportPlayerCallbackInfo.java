package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UI_ShowReportPlayer function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_UI_OnShowReportPlayerCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} If the overlay has been notified about the request.<br>
	 * {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 * {@link EOS_EResult#EOS_ApplicationSuspended} If the application is suspended.<br>
	 * {@link EOS_EResult#EOS_NetworkDisconnected} If the network is disconnected.
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UI_ShowReportPlayer */
	public Pointer ClientData;
	/** The Epic Online Services Account ID of the user who requested the Report. */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Online Services Account ID of the user who was to be Reported. */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UI_OnShowReportPlayerCallbackInfo() {
		super();
	}

	public EOS_UI_OnShowReportPlayerCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_OnShowReportPlayerCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_OnShowReportPlayerCallbackInfo implements Structure.ByValue {
	}
}