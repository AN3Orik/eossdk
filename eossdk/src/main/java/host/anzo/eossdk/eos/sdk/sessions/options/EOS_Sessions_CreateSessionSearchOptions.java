package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CreateSessionSearch function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "MaxSearchResults"})
public class EOS_Sessions_CreateSessionSearchOptions extends Structure {
	public static final int EOS_SESSIONS_CREATESESSIONSEARCH_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_CREATESESSIONSEARCH_API_LATEST}. */
	public int ApiVersion;
	/** Max number of results to return */
	public int MaxSearchResults;

	public EOS_Sessions_CreateSessionSearchOptions() {
		super();
		ApiVersion = EOS_SESSIONS_CREATESESSIONSEARCH_API_LATEST;
	}

	public EOS_Sessions_CreateSessionSearchOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CreateSessionSearchOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CreateSessionSearchOptions implements Structure.ByValue {
	}
}