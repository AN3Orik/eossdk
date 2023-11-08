package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.enums.EOS_EOnlineSessionPermissionLevel;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionModification_SetPermissionLevel function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "PermissionLevel"})
public class EOS_SessionModification_SetPermissionLevelOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETPERMISSIONLEVEL_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONMODIFICATION_SETPERMISSIONLEVEL_API_LATEST}. */
	public int ApiVersion;
	/** Permission level to set on the session */
	public EOS_EOnlineSessionPermissionLevel PermissionLevel;

	public EOS_SessionModification_SetPermissionLevelOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETPERMISSIONLEVEL_API_LATEST;
	}

	public EOS_SessionModification_SetPermissionLevelOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetPermissionLevelOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetPermissionLevelOptions implements Structure.ByValue {
	}
}