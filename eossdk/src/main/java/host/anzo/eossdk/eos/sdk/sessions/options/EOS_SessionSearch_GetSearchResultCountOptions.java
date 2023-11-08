package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_GetSearchResultCount function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_SessionSearch_GetSearchResultCountOptions extends Structure {
	/** The most recent version of the EOS_SessionSearch_GetSearchResultCount API. */
	public static final int EOS_SESSIONSEARCH_GETSEARCHRESULTCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONSEARCH_GETSEARCHRESULTCOUNT_API_LATEST}. */
	public int ApiVersion;

	public EOS_SessionSearch_GetSearchResultCountOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_GETSEARCHRESULTCOUNT_API_LATEST;
	}

	public EOS_SessionSearch_GetSearchResultCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_GetSearchResultCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_GetSearchResultCountOptions implements Structure.ByValue {
	}
}