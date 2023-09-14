package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionModification_SetBucketId function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "BucketId"})
public class EOS_SessionModification_SetBucketIdOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETBUCKETID_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_SETBUCKETID_API_LATEST. */
	public int ApiVersion;
	/** The new bucket id associated with the session */
	public String BucketId;

	public EOS_SessionModification_SetBucketIdOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETBUCKETID_API_LATEST;
	}

	public EOS_SessionModification_SetBucketIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetBucketIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetBucketIdOptions implements Structure.ByValue {
	}
}