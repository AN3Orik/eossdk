package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionSearch;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_CopySearchResultByIndex function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "SessionIndex"})
public class EOS_SessionSearch_CopySearchResultByIndexOptions extends Structure {
	/** The most recent version of the EOS_SessionSearch_CopySearchResultByIndex API. */
	public static final int EOS_SESSIONSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/**
	 * The index of the session to retrieve within the completed search query
	 * @see EOS_SessionSearch#getSearchResultCount(EOS_SessionSearch_GetSearchResultCountOptions)
	 */
	public int SessionIndex;

	public EOS_SessionSearch_CopySearchResultByIndexOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST;
	}

	public EOS_SessionSearch_CopySearchResultByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_CopySearchResultByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_CopySearchResultByIndexOptions implements Structure.ByValue {
	}
}