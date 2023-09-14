package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Parameters for the EOS_UI_ShowNativeProfile function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_UI_ShowNativeProfileOptions extends Structure {
	/** The most recent version of the EOS_UI_ShowNativeProfile API. */
	public static final int EOS_UI_SHOWNATIVEPROFILE_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_SHOWNATIVEPROFILE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Online Services Account ID of the user who is requesting the profile. */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Online Services Account ID of the user whose profile is being requested. */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UI_ShowNativeProfileOptions() {
		super();
		ApiVersion = EOS_UI_SHOWNATIVEPROFILE_API_LATEST;
	}

	public EOS_UI_ShowNativeProfileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowNativeProfileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowNativeProfileOptions implements Structure.ByValue {
	}
}