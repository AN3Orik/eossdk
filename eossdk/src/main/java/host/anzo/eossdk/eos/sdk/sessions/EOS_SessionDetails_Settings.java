package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.sessions.enums.EOS_EOnlineSessionPermissionLevel;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Top level details about an active session
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "BucketId", "NumPublicConnections", "IsAllowJoinInProgress", "PermissionLevel", "IsInvitesAllowed", "IsSanctionsEnabled", "AllowedPlatformIds", "AllowedPlatformIdsCount"})
public class EOS_SessionDetails_Settings extends Structure {
	/** The most recent version of the EOS_SessionDetails_Settings struct. */
	public static final int EOS_SESSIONDETAILS_SETTINGS_API_LATEST = 4;

	/** API Version: Set this to {@link #EOS_SESSIONDETAILS_SETTINGS_API_LATEST}. */
	public int ApiVersion;
	/** The main indexed parameter for this session, can be any string (i.e. "Region:GameMode") */
	public String BucketId;
	/** Number of total players allowed in the session */
	public int NumPublicConnections;
	/** Are players allowed to join the session while it is in the "in progress" state */
	public EOS_Bool IsAllowJoinInProgress;
	/** Permission level describing allowed access to the session when joining or searching for the session */
	public EOS_EOnlineSessionPermissionLevel PermissionLevel;
	/** Are players allowed to send invites for the session */
	public EOS_Bool IsInvitesAllowed;
	/** Are sanctioned players allowed to join - sanctioned players will be rejected if set to true */
	public EOS_Bool IsSanctionsEnabled;
	/**
	 * Array of platform IDs indicating the player platforms allowed to register with the session. Platform IDs are
	 * found in the EOS header file, e.g. EOS_OPT_Epic. For some platforms, the value will be in the EOS Platform specific
	 * header file. If null, the session will be unrestricted.
	 */
	public IntByReference AllowedPlatformIds;
	/** Number of platform IDs in the array */
	public int AllowedPlatformIdsCount;

	public EOS_SessionDetails_Settings() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_SETTINGS_API_LATEST;
	}

	public EOS_SessionDetails_Settings(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionDetails_Settings implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_Settings implements Structure.ByValue {
	}
}