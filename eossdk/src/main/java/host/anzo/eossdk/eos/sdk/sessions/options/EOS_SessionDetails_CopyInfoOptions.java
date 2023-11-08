package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionDetails_CopyInfo function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_SessionDetails_CopyInfoOptions extends Structure {
	public static final int EOS_SESSIONDETAILS_COPYINFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONDETAILS_COPYINFO_API_LATEST}. */
	public int ApiVersion;

	public EOS_SessionDetails_CopyInfoOptions() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_COPYINFO_API_LATEST;
	}

	public EOS_SessionDetails_CopyInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionDetails_CopyInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_CopyInfoOptions implements Structure.ByValue {
	}
}