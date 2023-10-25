package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionModification#setJoinInProgressAllowed(EOS_SessionModification_SetJoinInProgressAllowedOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "IsAllowJoinInProgress"})
public class EOS_SessionModification_SetJoinInProgressAllowedOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETJOININPROGRESSALLOWED_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_SETJOININPROGRESSALLOWED_API_LATEST. */
	public int ApiVersion;
	/** Does the session allow join in progress */
	public EOS_Bool IsAllowJoinInProgress;

	public EOS_SessionModification_SetJoinInProgressAllowedOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETJOININPROGRESSALLOWED_API_LATEST;
	}

	public EOS_SessionModification_SetJoinInProgressAllowedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetJoinInProgressAllowedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetJoinInProgressAllowedOptions implements Structure.ByValue {
	}
}