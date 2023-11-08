package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_GetSearchResultCount function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_LobbySearch_GetSearchResultCountOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_GetSearchResultCount API. */
	public static final int EOS_LOBBYSEARCH_GETSEARCHRESULTCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_GETSEARCHRESULTCOUNT_API_LATEST}. */
	public int ApiVersion;

	public EOS_LobbySearch_GetSearchResultCountOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_GETSEARCHRESULTCOUNT_API_LATEST;
	}

	public EOS_LobbySearch_GetSearchResultCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_GetSearchResultCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_GetSearchResultCountOptions implements Structure.ByValue {
	}
}