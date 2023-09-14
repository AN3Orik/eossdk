package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CopySessionHandleByUiEventId function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "UiEventId"})
public class EOS_Sessions_CopySessionHandleByUiEventIdOptions extends Structure {
	public static final int EOS_SESSIONS_COPYSESSIONHANDLEBYUIEVENTID_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_COPYSESSIONHANDLEBYUIEVENTID_API_LATEST. */
	public int ApiVersion;
	/** UI Event associated with the session */
	public long UiEventId;

	public EOS_Sessions_CopySessionHandleByUiEventIdOptions() {
		super();
		ApiVersion = EOS_SESSIONS_COPYSESSIONHANDLEBYUIEVENTID_API_LATEST;
	}

	public EOS_Sessions_CopySessionHandleByUiEventIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CopySessionHandleByUiEventIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CopySessionHandleByUiEventIdOptions implements Structure.ByValue {
	}
}