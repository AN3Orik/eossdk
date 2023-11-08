package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp;
import host.anzo.eossdk.eos.sdk.lobby.EOS_Lobby_AttributeData;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_SetParameter function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "Parameter", "ComparisonOp"})
public class EOS_LobbySearch_SetParameterOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_SetParameter API. */
	public static final int EOS_LOBBYSEARCH_SETPARAMETER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_SETPARAMETER_API_LATEST}. */
	public int ApiVersion;
	/** Search parameter describing a key and a value to compare */
	public EOS_Lobby_AttributeData.ByReference Parameter;
	/** The type of comparison to make against the search parameter */
	public EOS_EComparisonOp ComparisonOp;

	public EOS_LobbySearch_SetParameterOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_SETPARAMETER_API_LATEST;
	}

	public EOS_LobbySearch_SetParameterOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_SetParameterOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_SetParameterOptions implements Structure.ByValue {
	}
}