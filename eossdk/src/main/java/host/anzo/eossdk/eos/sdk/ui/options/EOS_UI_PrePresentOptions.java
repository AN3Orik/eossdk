package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Parameters for the EOS_UI_PrePresent function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "PlatformSpecificData"})
public class EOS_UI_PrePresentOptions extends Structure {
	/** The most recent version of the EOS_UI_PrePresent API. */
	public static final int EOS_UI_PREPRESENT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_UI_PREPRESENT_API_LATEST}. */
	public int ApiVersion;
	/** Platform specific data. */
	public Pointer PlatformSpecificData;

	public EOS_UI_PrePresentOptions() {
		super();
		ApiVersion = EOS_UI_PREPRESENT_API_LATEST;
	}

	public EOS_UI_PrePresentOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_PrePresentOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_PrePresentOptions implements Structure.ByValue {
	}
}