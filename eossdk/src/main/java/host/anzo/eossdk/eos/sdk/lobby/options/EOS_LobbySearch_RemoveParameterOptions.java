package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_RemoveParameter function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "Key", "ComparisonOp"})
public class EOS_LobbySearch_RemoveParameterOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_RemoveParameter API. */
	public static final int EOS_LOBBYSEARCH_REMOVEPARAMETER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_REMOVEPARAMETER_API_LATEST}. */
	public int ApiVersion;
	/** Search parameter key to remove from the search */
	public String Key;
	/** Search comparison operation associated with the key to remove */
	public EOS_EComparisonOp ComparisonOp;

	public EOS_LobbySearch_RemoveParameterOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_REMOVEPARAMETER_API_LATEST;
	}

	public EOS_LobbySearch_RemoveParameterOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_RemoveParameterOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_RemoveParameterOptions implements Structure.ByValue {
	}
}