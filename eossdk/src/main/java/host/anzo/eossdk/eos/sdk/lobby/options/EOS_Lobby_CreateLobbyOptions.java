package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.EOS_Lobby_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.lobby.callbacks.EOS_Lobby_OnRTCRoomConnectionChangedCallback;
import host.anzo.eossdk.eos.sdk.lobby.enums.EOS_ELobbyPermissionLevel;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_PresenceModification_SetJoinInfoOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_CreateSessionModificationOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_JoinSessionOptions;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_CreateLobby function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "MaxLobbyMembers", "PermissionLevel", "bPresenceEnabled", "bAllowInvites", "BucketId", "bDisableHostMigration", "bEnableRTCRoom", "LocalRTCOptions", "LobbyId", "bEnableJoinById", "bRejoinAfterKickRequiresInvite", "AllowedPlatformIds", "AllowedPlatformIdsCount", "bCrossplayOptOut"})
public class EOS_Lobby_CreateLobbyOptions extends Structure {
	public static final int EOS_LOBBY_CREATELOBBY_API_LATEST = 9;

	/** API Version: Set this to EOS_LOBBY_CREATELOBBY_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user creating the lobby; this user will automatically join the lobby as its owner */
	public EOS_ProductUserId LocalUserId;
	/** The maximum number of users who can be in the lobby at a time */
	public int MaxLobbyMembers;
	/**
	 * The initial permission level of the lobby
	 */
	public EOS_ELobbyPermissionLevel PermissionLevel;
	/**
	 * If true, this lobby will be associated with the local user's presence information. A user's presence can only be associated with one lobby at a time.
	 * This affects the ability of the Social Overlay to show game related actions to take in the user's social graph.<br>
	 * <b>The Social Overlay can handle only one of the following three options at a time:</b>
	 * <ul>
	 * <li>using the bPresenceEnabled flags within the Sessions interface
	 * <li>using the bPresenceEnabled flags within the Lobby interface
	 * <li>using EOS_PresenceModification_SetJoinInfo
	 * </ul>
	 * @see EOS_PresenceModification_SetJoinInfoOptions
	 * @see EOS_Lobby_JoinLobbyOptions
	 * @see EOS_Lobby_JoinLobbyByIdOptions
	 * @see EOS_Sessions_CreateSessionModificationOptions
	 * @see EOS_Sessions_JoinSessionOptions
	 */
	public int bPresenceEnabled;
	/** Are members of the lobby allowed to invite others */
	public int bAllowInvites;
	/** Bucket ID associated with the lobby */
	public String BucketId;
	/**
	 * Is host migration allowed (will the lobby stay open if the original host leaves?)
	 * NOTE: EOS_Lobby_PromoteMember is still allowed regardless of this setting
	 */
	public int bDisableHostMigration;
	/**
	 * Creates a real-time communication (RTC) room for all members of this lobby. All members of the lobby will automatically join the RTC
	 * room when they connect to the lobby and they will automatically leave the RTC room when they leave or are removed from the lobby.
	 * While the joining and leaving of the RTC room is automatic, applications will still need to use the EOS RTC interfaces to handle all
	 * other functionality for the room.
	 *
	 * @see EOS_Lobby_Interface#getRTCRoomName(EOS_Lobby_GetRTCRoomNameOptions, ByteBuffer, IntBuffer)
	 * @see EOS_Lobby_Interface#addNotifyRTCRoomConnectionChanged(EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions, Pointer, EOS_Lobby_OnRTCRoomConnectionChangedCallback)
	 */
	public int bEnableRTCRoom;
	/**
	 * (Optional) Allows the local application to set local audio options for the RTC Room if it is enabled. Set this to NULL if the RTC
	 * RTC room is disabled or you would like to use the defaults.
	 */
	public EOS_Lobby_LocalRTCOptions.ByReference LocalRTCOptions;
	/**
	 * (Optional) Set to a globally unique value to override the backend assignment
	 * If not specified the backend service will assign one to the lobby.  Do not mix and match override and non override settings.
	 * This value can be of size [EOS_LOBBY_MIN_LOBBYIDOVERRIDE_LENGTH, EOS_LOBBY_MAX_LOBBYIDOVERRIDE_LENGTH]
	 */
	public String LobbyId;
	/**
	 * Is EOS_Lobby_JoinLobbyById allowed.
	 * This is provided to support cases where an integrated platform's invite system is used.
	 * In these cases the game should provide the lobby ID securely to the invited player.  Such as by attaching the
	 * lobby ID to the integrated platform's session data or sending the lobby ID within the invite data.
	 */
	public int bEnableJoinById;
	/**
	 * Does rejoining after being kicked require an invite?
	 * When this is set, a kicked player cannot return to the session even if the session was set with
	 * EOS_LPL_PUBLICADVERTISED.  When this is set, a player with invite privileges must use EOS_Lobby_SendInvite to
	 * allow the kicked player to return to the session.
	 */
	public int bRejoinAfterKickRequiresInvite;
	/**
	 * Array of platform IDs indicating the player platforms allowed to register with the session. Platform IDs are
	 * found in the EOS header file, e.g. EOS_OPT_Epic. For some platforms, the value will be in the EOS Platform specific
	 * header file. If null, the lobby will be unrestricted.
	 */
	public IntByReference AllowedPlatformIds;
	/** Number of platform IDs in the array */
	public int AllowedPlatformIdsCount;
	/**
	 * This value indicates whether or not the lobby owner allows crossplay interactions. If false, the lobby owner
	 * will be treated as allowing crossplay. If it is set to true, AllowedPlatformIds must have a single entry that matches
	 * the platform of the lobby owner.
	 */
	public int bCrossplayOptOut;

	public EOS_Lobby_CreateLobbyOptions() {
		super();
		ApiVersion = EOS_LOBBY_CREATELOBBY_API_LATEST;
	}

	public EOS_Lobby_CreateLobbyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_CreateLobbyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_CreateLobbyOptions implements Structure.ByValue {
	}
}