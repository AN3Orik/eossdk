package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.EOS_LobbySearch;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_CopySearchResultByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "LobbyIndex"})
public class EOS_LobbySearch_CopySearchResultByIndexOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_CopySearchResultByIndex API. */
	public static final int EOS_LOBBYSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST}. */
	public int ApiVersion;

	/**
	 * The index of the lobby to retrieve within the completed search query
	 * @see EOS_LobbySearch#getSearchResultCount(EOS_LobbySearch_GetSearchResultCountOptions)
	 */
	public int LobbyIndex;

	public EOS_LobbySearch_CopySearchResultByIndexOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_COPYSEARCHRESULTBYINDEX_API_LATEST;
	}

	public EOS_LobbySearch_CopySearchResultByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_CopySearchResultByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_CopySearchResultByIndexOptions implements Structure.ByValue {
	}
}