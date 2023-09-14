package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_SetMaxResults function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "MaxSearchResults"})
public class EOS_SessionSearch_SetMaxResultsOptions extends Structure {
	/** Maximum number of search results allowed with a given query */
	public static final int EOS_SESSIONS_MAX_SEARCH_RESULTS = 200;

	public static final int EOS_SESSIONSEARCH_SETMAXSEARCHRESULTS_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONSEARCH_SETMAXSEARCHRESULTS_API_LATEST. */
	public int ApiVersion;
	/** Maximum number of search results returned with this query, may not exceed {@link #EOS_SESSIONS_MAX_SEARCH_RESULTS} */
	public int MaxSearchResults;

	public EOS_SessionSearch_SetMaxResultsOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_SETMAXSEARCHRESULTS_API_LATEST;
	}

	public EOS_SessionSearch_SetMaxResultsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_SetMaxResultsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_SetMaxResultsOptions implements Structure.ByValue {
	}
}