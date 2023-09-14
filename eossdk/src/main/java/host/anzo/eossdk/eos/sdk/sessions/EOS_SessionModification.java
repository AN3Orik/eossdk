package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Sessions_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.sessions.options.*;

/**
 * To modify sessions, you must call EOS_Sessions_CreateSessionModification to create a Session Modification handle. To modify that handle, call
 * EOS_HSessionModification methods. Once you are finished, call EOS_Sessions_UpdateSession with your handle. You must then release your Session Modification
 * handle by calling EOS_SessionModification_Release.
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public class EOS_SessionModification extends PointerType implements AutoCloseable {
	public EOS_SessionModification(Pointer address) {
		super(address);
	}

	public EOS_SessionModification() {
		super();
	}

	/**
	 * Set the bucket ID associated with this session.
	 * Values such as region, game mode, etc can be combined here depending on game need.
	 * Setting this is strongly recommended to improve search performance.
	 *
	 * @param options Options associated with the bucket ID of the session
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the bucket ID is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setBucketId(EOS_SessionModification_SetBucketIdOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetBucketId(this, options);
	}

	/**
	 * Set the host address associated with this session
	 * Setting this is optional, if the value is not set the SDK will fill the value in from the service.
	 * It is useful to set if other addressing mechanisms are desired or if LAN addresses are preferred during development<br>
	 * <b>No validation of this value occurs to allow for flexibility in addressing methods</b>
	 *
	 * @param options Options associated with the host address of the session
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the host ID is an empty string<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setHostAddress(EOS_SessionModification_SetHostAddressOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetHostAddress(this, options);
	}

	/**
	 * Set the session permissions associated with this session.
	 * The permissions range from "public" to "invite only" and are described by EOS_EOnlineSessionPermissionLevel
	 *
	 * @param options Options associated with the permission level of the session
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setPermissionLevel(EOS_SessionModification_SetPermissionLevelOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetPermissionLevel(this, options);
	}

	/**
	 * Set whether or not join in progress is allowed
	 * Once a session is started, it will no longer be visible to search queries unless this flag is set or the session returns to the pending or ended state
	 *
	 * @param options Options associated with setting the join in progress state the session
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setJoinInProgressAllowed(EOS_SessionModification_SetJoinInProgressAllowedOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetJoinInProgressAllowed(this, options);
	}

	/**
	 * Set the maximum number of players allowed in this session.
	 * When updating the session, it is not possible to reduce this number below the current number of existing players
	 *
	 * @param options Options associated with max number of players in this session
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setMaxPlayers(EOS_SessionModification_SetMaxPlayersOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetMaxPlayers(this, options);
	}

	/**
	 * Allows enabling or disabling invites for this session.
	 * The session will also need to have `bPresenceEnabled` true.
	 *
	 * @param options Options associated with invites allowed flag for this session.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setInvitesAllowed(EOS_SessionModification_SetInvitesAllowedOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetInvitesAllowed(this, options);
	}

	/**
	 * Set the Allowed Platform IDs for the session.
	 *
	 * @param options Options associated with allowed Platform IDs for this session.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the attribution is missing information or otherwise invalid
	 */
	public EOS_EResult setAllowedPlatformIds(EOS_SessionModification_SetAllowedPlatformIdsOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_SetAllowedPlatformIds(this, options);
	}

	/**
	 * Associate an attribute with this session
	 * An attribute is something that may or may not be advertised with the session.
	 * If advertised, it can be queried for in a search, otherwise the data remains local to the client
	 *
	 * @param options Options to set the attribute and its advertised state
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this parameter was successful<br>
	 *		   {@link EOS_EResult#EOS_InvalidParameters} if the attribution is missing information or otherwise invalid<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult addAttribute(EOS_SessionModification_AddAttributeOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_AddAttribute(this, options);
	}

	/**
	 * Remove an attribute from this session
	 *
	 * @param options Specify the key of the attribute to remove
	 *
	 * @return {@link EOS_EResult#EOS_Success} if removing this parameter was successful<br>
	 *		   {@link EOS_EResult#EOS_InvalidParameters} if the key is null or empty<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult removeAttribute(EOS_SessionModification_RemoveAttributeOptions options) {
		return EOSLibrary.instance.EOS_SessionModification_RemoveAttribute(this, options);
	}

	/**
	 * Release the memory associated with session modification.
	 * This must be called on data retrieved from EOS_Sessions_CreateSessionModification or EOS_Sessions_UpdateSessionModification
	 *
	 * @see EOS_Sessions_Interface#createSessionModification(EOS_Sessions_CreateSessionModificationOptions, EOS_SessionModification)
	 * @see EOS_Sessions_Interface#updateSessionModification(EOS_Sessions_UpdateSessionModificationOptions, EOS_SessionModification)
	 */
	public void release() {
		EOSLibrary.instance.EOS_SessionModification_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}