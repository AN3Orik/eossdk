package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionDetails#getSessionAttributeCount(EOS_SessionDetails_GetSessionAttributeCountOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_SessionDetails_GetSessionAttributeCountOptions extends Structure {
	public static final int EOS_SESSIONDETAILS_GETSESSIONATTRIBUTECOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONDETAILS_GETSESSIONATTRIBUTECOUNT_API_LATEST. */
	public int ApiVersion;

	public EOS_SessionDetails_GetSessionAttributeCountOptions() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_GETSESSIONATTRIBUTECOUNT_API_LATEST;
	}

	public EOS_SessionDetails_GetSessionAttributeCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionDetails_GetSessionAttributeCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_GetSessionAttributeCountOptions implements Structure.ByValue {
	}
}