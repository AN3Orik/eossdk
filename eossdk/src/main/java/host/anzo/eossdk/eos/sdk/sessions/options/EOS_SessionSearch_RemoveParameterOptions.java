package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_RemoveParameter function.
 * Removal requires both the key and its comparator in order to remove as the same key can be used in more than one operation
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "Key", "ComparisonOp"})
public class EOS_SessionSearch_RemoveParameterOptions extends Structure {
	/** The most recent version of the EOS_SessionSearch_RemoveParameter API. */
	public static final int EOS_SESSIONSEARCH_REMOVEPARAMETER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONSEARCH_REMOVEPARAMETER_API_LATEST}. */
	public int ApiVersion;
	/** Search parameter key to remove from the search */
	public String Key;
	/** Search comparison operation associated with the key to remove */
	public EOS_EComparisonOp ComparisonOp;

	public EOS_SessionSearch_RemoveParameterOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_REMOVEPARAMETER_API_LATEST;
	}

	public EOS_SessionSearch_RemoveParameterOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_RemoveParameterOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_RemoveParameterOptions implements Structure.ByValue {
	}
}