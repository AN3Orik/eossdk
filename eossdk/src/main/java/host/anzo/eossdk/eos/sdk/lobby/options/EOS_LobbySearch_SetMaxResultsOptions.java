package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_SetMaxResults function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "MaxResults"})
public class EOS_LobbySearch_SetMaxResultsOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_SetMaxResults API. */
	public static final int EOS_LOBBYSEARCH_SETMAXRESULTS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_SETMAXRESULTS_API_LATEST}. */
	public int ApiVersion;
	/** Maximum number of search results to return from the query */
	public int MaxResults;

	public EOS_LobbySearch_SetMaxResultsOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_SETMAXRESULTS_API_LATEST;
	}

	public EOS_LobbySearch_SetMaxResultsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_SetMaxResultsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_SetMaxResultsOptions implements Structure.ByValue {
	}
}