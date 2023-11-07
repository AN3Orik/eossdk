package host.anzo.eossdk.eos.sdk.init.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Options for initializing mount paths required for some platforms.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Reserved", "OptionalInternalDirectory", "OptionalExternalDirectory"})
public class EOS_Android_InitializeOptions extends Structure {
	/** The most recent version of the EOS_Android_InitializeOptions API. */
	public static final int EOS_ANDROID_INITIALIZEOPTIONS_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_ANDROID_INITIALIZEOPTIONS_API_LATEST}. */
	public int ApiVersion;
	/** Reserved, set to null */
	public Pointer Reserved;
	/** Full internal directory path. Can be null */
	public String OptionalInternalDirectory;
	/** Full external directory path. Can be null */
	public String OptionalExternalDirectory;

	public EOS_Android_InitializeOptions() {
		super();
		ApiVersion = EOS_ANDROID_INITIALIZEOPTIONS_API_LATEST;
	}

	public EOS_Android_InitializeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Android_InitializeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Android_InitializeOptions implements Structure.ByValue {
	}
}