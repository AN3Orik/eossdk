package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Parameters for the EOS_UI_ShowReportPlayer function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_UI_ShowReportPlayerOptions extends Structure {
	/** The most recent version of the EOS_UI_ShowReportPlayer API. */
	public static final int EOS_UI_SHOWREPORTPLAYER_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SHOWREPORTPLAYER_API_LATEST. */
	public int ApiVersion;
	/** The Epic Online Services Account ID of the user who is requesting the Report. */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Online Services Account ID of the user whose is being Reported. */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UI_ShowReportPlayerOptions() {
		super();
		ApiVersion = EOS_UI_SHOWREPORTPLAYER_API_LATEST;
	}

	public EOS_UI_ShowReportPlayerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowReportPlayerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowReportPlayerOptions implements Structure.ByValue {
	}
}