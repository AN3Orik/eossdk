package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_IsUserInSession function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "TargetUserId"})
public class EOS_Sessions_IsUserInSessionOptions extends Structure {
	public static final int EOS_SESSIONS_ISUSERINSESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_ISUSERINSESSION_API_LATEST}. */
	public int ApiVersion;
	/** Active session name to search within */
	public String SessionName;
	/** Product User ID to search for in the session */
	public EOS_ProductUserId TargetUserId;

	public EOS_Sessions_IsUserInSessionOptions() {
		super();
		ApiVersion = EOS_SESSIONS_ISUSERINSESSION_API_LATEST;
	}

	public EOS_Sessions_IsUserInSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_IsUserInSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_IsUserInSessionOptions implements Structure.ByValue {
	}
}
