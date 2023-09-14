package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Parameters for the EOS_UI_ShowBlockPlayer function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_UI_ShowBlockPlayerOptions extends Structure {
	/** API Version: Set this to EOS_UI_SHOWBLOCKPLAYER_API_LATEST. */
	public int ApiVersion;
	/** The Epic Online Services Account ID of the user who is requesting the Block. */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Online Services Account ID of the user whose is being Blocked. */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UI_ShowBlockPlayerOptions() {
		super();
	}

	public EOS_UI_ShowBlockPlayerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowBlockPlayerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowBlockPlayerOptions implements Structure.ByValue {
	}
}