package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LobbyOwnerUserId", "PermissionLevel", "AvailableSlots", "MaxMembers", "IsAllowInvites", "BucketId", "IsAllowHostMigration", "IsRTCRoomEnabled", "IsAllowJoinById", "IsRejoinAfterKickRequiresInvite", "IsPresenceEnabled", "AllowedPlatformIds", "AllowedPlatformIdsCount"})
public class EOS_LobbyDetails_Info extends Structure implements AutoCloseable {
	public static final int EOS_LOBBYDETAILS_INFO_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_LOBBYDETAILS_INFO_API_LATEST}. */
	public int ApiVersion;
	/** Lobby ID */
	public String LobbyId;
	/** The Product User ID of the current owner of the lobby */
	public EOS_ProductUserId LobbyOwnerUserId;
	/** Permission level of the lobby */
	public int PermissionLevel;
	/** Current available space */
	public int AvailableSlots;
	/** Max allowed members in the lobby */
	public int MaxMembers;
	/** If true, users can invite others to this lobby */
	public EOS_Bool IsAllowInvites;
	/** The main indexed parameter for this lobby, can be any string (i.e. "Region:GameMode") */
	public String BucketId;
	/** Is host migration allowed */
	public EOS_Bool IsAllowHostMigration;
	/** Was a Real-Time Communication (RTC) room enabled at lobby creation? */
	public EOS_Bool IsRTCRoomEnabled;
	/** Is EOS_Lobby_JoinLobbyById allowed */
	public EOS_Bool IsAllowJoinById;
	/** Does rejoining after being kicked require an invite */
	public EOS_Bool IsRejoinAfterKickRequiresInvite;
	/** If true, this lobby will be associated with the local user's presence information. */
	public EOS_Bool IsPresenceEnabled;
	/**
	 * Array of platform IDs indicating the player platforms allowed to register with the session. Platform IDs are
	 * found in the EOS header file, e.g. EOS_OPT_Epic. For some platforms, the value will be in the EOS Platform specific
	 * header file. If null, the lobby will be unrestricted.
	 */
	public IntByReference AllowedPlatformIds;
	/** Number of platform IDs in the array */
	public int AllowedPlatformIdsCount;

	public EOS_LobbyDetails_Info() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_INFO_API_LATEST;
	}

	public EOS_LobbyDetails_Info(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_LobbyDetails_Info_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_LobbyDetails_Info implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_Info implements Structure.ByValue {
	}
}