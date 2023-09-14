package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_PauseSocialOverlay function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "bIsPaused"})
public class EOS_UI_PauseSocialOverlayOptions extends Structure {
	/** The most recent version of the EOS_UI_PauseSocialOverlay API. */
	public static final int EOS_UI_PAUSESOCIALOVERLAY_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_PAUSESOCIALOVERLAY_API_LATEST. */
	public int ApiVersion;
	/** The desired bIsPaused state of the overlay. */
	public int bIsPaused;

	public EOS_UI_PauseSocialOverlayOptions() {
		super();
		ApiVersion = EOS_UI_PAUSESOCIALOVERLAY_API_LATEST;
	}

	public EOS_UI_PauseSocialOverlayOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_PauseSocialOverlayOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_PauseSocialOverlayOptions implements Structure.ByValue {
	}
}