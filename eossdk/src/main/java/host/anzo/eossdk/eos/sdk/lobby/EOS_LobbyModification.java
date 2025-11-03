package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.lobby.options.*;

/**
 * To modify lobbies or the lobby member data, you must call EOS_Lobby_UpdateLobbyModification to create a Lobby Modification handle. To modify that handle, call
 * EOS_HLobbyModification methods. Once you are finished, call EOS_Lobby_UpdateLobby with your handle. You must then release your Lobby Modification
 * handle by calling EOS_LobbyModification_Release.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOS_LobbyModification extends PointerType implements AutoCloseable {
	public EOS_LobbyModification(Pointer address) {
		super(address);
	}

	public EOS_LobbyModification() {
		super();
	}

	/**
	 * Set the bucket ID associated with this lobby.
	 * Values such as region, game mode, etc can be combined here depending on game need.
	 * Setting this is strongly recommended to improve search performance.
	 *
	 * @param options Options associated with the bucket ID of the lobby
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the bucket ID is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setBucketId(EOS_LobbyModification_SetBucketIdOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_SetBucketId(this, options);
	}

	/**
	 * Set the permissions associated with this lobby.
	 * The permissions range from "public" to "invite only" and are described by EOS_ELobbyPermissionLevel
	 *
	 * @param options Options associated with the permission level of the lobby
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setPermissionLevel(EOS_LobbyModification_SetPermissionLevelOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_SetPermissionLevel(this, options);
	}

	/**
	 * Set the maximum number of members allowed in this lobby.
	 * When updating the lobby, it is not possible to reduce this number below the current number of existing members
	 *
	 * @param options Options associated with max number of members in this lobby
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setMaxMembers(EOS_LobbyModification_SetMaxMembersOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_SetMaxMembers(this, options);
	}

	/**
	 * Allows enabling or disabling invites for this lobby.
	 * The lobby will also need to have `bPresenceEnabled` true.
	 *
	 * @param options Options associated with invites allowed flag for this lobby.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setInvitesAllowed(EOS_LobbyModification_SetInvitesAllowedOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_SetInvitesAllowed(this, options);
	}

	/**
	 * Associate an attribute with this lobby
	 * An attribute is something may be public or private with the lobby.
	 * If public, it can be queried for in a search, otherwise the data remains known only to lobby members
	 *
	 * @param options Options to set the attribute and its visibility state
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *           {@link EOS_EResult#EOS_InvalidParameters} if the attribute is missing information or otherwise invalid<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult addAttribute(EOS_LobbyModification_AddAttributeOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_AddAttribute(this, options);
	}

	/**
	 * Remove an attribute associated with the lobby
	 *
	 * @param options Specify the key of the attribute to remove
	 *
	 * @return {@link EOS_EResult#EOS_Success} if removing this parameter was successful<br>
	 *           {@link EOS_EResult#EOS_InvalidParameters} if the key is null or empty<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult removeAttribute(EOS_LobbyModification_RemoveAttributeOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_RemoveAttribute(this, options);
	}

	/**
	 * Associate an attribute with a member of the lobby
	 * Lobby member data is always private to the lobby
	 *
	 * @param options Options to set the attribute and its visibility state
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *           {@link EOS_EResult#EOS_InvalidParameters} if the attribute is missing information or otherwise invalid<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult addMemberAttribute(EOS_LobbyModification_AddMemberAttributeOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_AddMemberAttribute(this, options);
	}

	/**
	 * Remove an attribute associated with of member of the lobby
	 *
	 * @param options Specify the key of the member attribute to remove
	 *
	 * @return {@link EOS_EResult#EOS_Success} if removing this parameter was successful<br>
	 *           {@link EOS_EResult#EOS_InvalidParameters} if the key is null or empty<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult removeMemberAttribute(EOS_LobbyModification_RemoveMemberAttributeOptions options) {
		return EOSLibrary.instance.EOS_LobbyModification_RemoveMemberAttribute(this, options);
	}

	/**
	 * Release the memory associated with a lobby modification. This must be called on data retrieved from {@link EOSLibrary#EOS_Lobby_UpdateLobbyModification}.
	 * @see EOSLibrary#EOS_Lobby_UpdateLobbyModification
	 */
	public void release() {
		EOSLibrary.instance.EOS_LobbyModification_Release(this);
	}

	@Override
	public void close() {
		release();
	}
}