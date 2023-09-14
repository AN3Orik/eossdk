package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp;
import host.anzo.eossdk.eos.sdk.sessions.EOS_Sessions_AttributeData;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_SetParameter function.
 * A search key may be set more than once to make multiple comparisons
 * The two comparisons are AND'd together
 * (ie, Key GREATER_THAN 5, Key NOT_EQUALS 10)
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "Parameter", "ComparisonOp"})
public class EOS_SessionSearch_SetParameterOptions extends Structure {
	public static final int EOS_SESSIONSEARCH_SETPARAMETER_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONSEARCH_SETPARAMETER_API_LATEST. */
	public int ApiVersion;
	/** Search parameter describing a key and a value to compare */
	public EOS_Sessions_AttributeData.ByReference Parameter;
	/** The type of comparison to make against the search parameter */
	public EOS_EComparisonOp ComparisonOp;

	public EOS_SessionSearch_SetParameterOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_SETPARAMETER_API_LATEST;
	}

	public EOS_SessionSearch_SetParameterOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_SetParameterOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_SetParameterOptions implements Structure.ByValue {
	}
}