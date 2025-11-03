package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_CreateLobbyOptions;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_JoinLobbyOptions;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_PresenceModification_SetJoinInfoOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_CreateSessionModification function.
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "BucketId", "MaxPlayers", "LocalUserId", "IsPresenceEnabled", "SessionId", "IsSanctionsEnabled", "AllowedPlatformIds", "AllowedPlatformIdsCount"})
public class EOS_Sessions_CreateSessionModificationOptions extends Structure {
	/** The most recent version of the EOS_Sessions_CreateSessionModification API. */
	public static int EOS_SESSIONS_CREATESESSIONMODIFICATION_API_LATEST = 5;

	/** API Version: Set this to {@link #EOS_SESSIONS_CREATESESSIONMODIFICATION_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session to create */
	public String SessionName;
	/** Bucket ID associated with the session */
	public String BucketId;
	/** Maximum number of players allowed in the session */
	public int MaxPlayers;
	/** The Product User ID of the local user associated with the session */
	public EOS_ProductUserId LocalUserId;
	/**
	 * Determines whether or not this session should be the one associated with the local user's presence information.
	 * If true, this session will be associated with presence. Only one session at a time can have this flag true.
	 * This affects the ability of the Social Overlay to show game related actions to take in the user's social graph.<br>
	 * <b>The Social Overlay can handle only one of the following three options at a time:</b>
	 * <ul>
	 * <li>using the bPresenceEnabled flags within the Sessions interface
	 * <li>using the bPresenceEnabled flags within the Lobby interface
	 * <li>using EOS_PresenceModification_SetJoinInfo
	 * </ul>
	 * @see EOS_PresenceModification_SetJoinInfoOptions
	 * @see EOS_Lobby_CreateLobbyOptions
	 * @see EOS_Lobby_JoinLobbyOptions
	 * @see EOS_Sessions_JoinSessionOptions
	 */
	public EOS_Bool IsPresenceEnabled;
	/**
	 * Optional session id - set to a globally unique value to override the backend assignment
	 * If not specified the backend service will assign one to the session.  Do not mix and match.
	 * This value can be of size [{@link EOS_Defines#EOS_SESSIONMODIFICATION_MIN_SESSIONIDOVERRIDE_LENGTH}, {@link EOS_Defines#EOS_SESSIONMODIFICATION_MAX_SESSIONIDOVERRIDE_LENGTH}]
	 */
	public String SessionId;
	/**
	 * If true, sanctioned players can neither join nor register with this session and, in the case of join,
	 * will return EOS_EResult code EOS_Sessions_PlayerSanctioned
	 */
	public EOS_Bool IsSanctionsEnabled;
	/**
	 * Array of platform IDs indicating the player platforms allowed to register with the session. Platform IDs are
	 * found in the EOS header file (eos_common.h), for example EOS_OPT_Epic. For some platforms the value will be
	 * in the EOS Platform specific header file. If null, the session will be unrestricted.
	 */
	public IntByReference AllowedPlatformIds;
	/** Number of platform IDs in the array */
	public int AllowedPlatformIdsCount;

	public EOS_Sessions_CreateSessionModificationOptions() {
		super();
		ApiVersion = EOS_SESSIONS_CREATESESSIONMODIFICATION_API_LATEST;
	}

	public EOS_Sessions_CreateSessionModificationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_CreateSessionModificationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_CreateSessionModificationOptions implements Structure.ByValue {
	}
}