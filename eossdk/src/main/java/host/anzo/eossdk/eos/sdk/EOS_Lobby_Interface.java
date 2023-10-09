package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.integratedplatform.enums.EOS_EIntegratedPlatformManagementFlags;
import host.anzo.eossdk.eos.sdk.lobby.EOS_LobbyDetails;
import host.anzo.eossdk.eos.sdk.lobby.EOS_LobbyModification;
import host.anzo.eossdk.eos.sdk.lobby.callbacks.*;
import host.anzo.eossdk.eos.sdk.lobby.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * The Lobby Interface is used to manage lobbies that provide a persistent connection between users and
 * notifications of data sharing/updates.  Lobbies may also be found by advertising and searching with the backend service.
 * All Lobby Interface calls take a handle of type EOS_HLobby as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetLobbyInterface function.
 *
 * @see EOS_Platform_Interface#getLobbyInterface()
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOS_Lobby_Interface extends PointerType {
	/** Max length of an invite ID */
	public static final int EOS_LOBBY_INVITEID_MAX_LENGTH = 64;

	public EOS_Lobby_Interface(Pointer address) {
		super(address);
	}
	public EOS_Lobby_Interface() {
		super();
	}

	/**
	 * Creates a lobby and adds the user to the lobby membership.  There is no data associated with the lobby at the start and can be added vis EOS_Lobby_UpdateLobbyModification
	 * <p>
	 * If the lobby is successfully created with an RTC Room enabled, the lobby system will automatically join and maintain the connection to the RTC room as long as the
	 * local user remains in the lobby. Applications can use the EOS_Lobby_GetRTCRoomName to get the name of the RTC Room associated with a lobby, which may be used with
	 * many of the EOS_RTC_* suite of functions. This can be useful to: register for notifications for talking status; to mute or unmute the local user's audio output;
	 * to block or unblock room participants; to set local audio device settings; and more.
	 *
	 * @param options Required fields for the creation of a lobby such as a user count and its starting advertised state
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the create operation completes, either successfully or in error
	 */
	public void createLobby(EOS_Lobby_CreateLobbyOptions options,
	                        Pointer clientData,
	                        EOS_Lobby_OnCreateLobbyCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_CreateLobby(this, options, clientData, completionDelegate);
	}

	/**
	 * Destroy a lobby given a lobby ID
	 *
	 * @param options Structure containing information about the lobby to be destroyed
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the destroy operation completes, either successfully or in error
	 */
	public void destroyLobby(EOS_Lobby_DestroyLobbyOptions options,
	                         Pointer clientData,
	                         EOS_Lobby_OnDestroyLobbyCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_DestroyLobby(this, options, clientData, completionDelegate);
	}

	/**
	 * Join a lobby, creating a local instance under a given lobby ID.  Backend will validate various conditions to make sure it is possible to join the lobby.
	 * <p>
	 * If the lobby is successfully join has an RTC Room enabled, the lobby system will automatically join and maintain the connection to the RTC room as long as the
	 * local user remains in the lobby. Applications can use the EOS_Lobby_GetRTCRoomName to get the name of the RTC Room associated with a lobby, which may be used with
	 * many of the EOS_RTC_* suite of functions. This can be useful to: register for notifications for talking status; to mute or unmute the local user's audio output;
	 * to block or unblock room participants; to set local audio device settings; and more.
	 *
	 * @param options Structure containing information about the lobby to be joined
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the join operation completes, either successfully or in error
	 */
	public void joinLobby(EOS_Lobby_JoinLobbyOptions options,
	                      Pointer clientData,
	                      EOS_Lobby_OnJoinLobbyCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_JoinLobby(this, options, clientData, completionDelegate);
	}

	/**
	 * This is a special case of EOS_Lobby_JoinLobby.  It should only be used if the lobby has had Join-by-ID enabled.
	 * Additionally, Join-by-ID should only be enabled to support native invites on an integrated platform.
	 *
	 * @param options Structure containing information about the lobby to be joined
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the join operation completes, either successfully or in error
	 * @see #joinLobby(EOS_Lobby_JoinLobbyOptions, Pointer, EOS_Lobby_OnJoinLobbyCallback)
	 */
	public void joinLobbyById(EOS_Lobby_JoinLobbyByIdOptions options,
	                          Pointer clientData,
	                          EOS_Lobby_OnJoinLobbyByIdCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_JoinLobbyById(this, options, clientData, completionDelegate);
	}

	/**
	 * Leave a lobby given a lobby ID
	 * <p>
	 * If the lobby you are leaving had an RTC Room enabled, leaving the lobby will also automatically leave the RTC room.
	 *
	 * @param options Structure containing information about the lobby to be left
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the leave operation completes, either successfully or in error
	 */
	public void leaveLobby(EOS_Lobby_LeaveLobbyOptions options,
	                       Pointer clientData,
	                       EOS_Lobby_OnLeaveLobbyCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_LeaveLobby(this, options, clientData, completionDelegate);
	}

	/**
	 * Creates a lobby modification handle (EOS_HLobbyModification). The lobby modification handle is used to modify an existing lobby and can be applied with EOS_Lobby_UpdateLobby.
	 * The EOSLobbyModification must be released by calling EOS_LobbyModification_Release once it is no longer needed.
	 *
	 * @param options Required fields such as lobby ID
	 * @param outLobbyModificationHandle Pointer to a Lobby Modification Handle only set if successful
	 * @return {@link EOS_EResult#EOS_Success} if we successfully created the Lobby Modification Handle pointed at in OutLobbyModificationHandle, or an error result if the input data was invalid
	 *		   {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 *
	 * @see EOS_LobbyModification#release()
	 * @see #updateLobby(EOS_Lobby_UpdateLobbyOptions, Pointer, EOS_Lobby_OnUpdateLobbyCallback)
	 * @see EOS_LobbyModification
	 */
	public EOS_EResult updateLobbyModification(EOS_Lobby_UpdateLobbyModificationOptions options,
	                                           PointerByReference outLobbyModificationHandle) {
		return EOSLibrary.instance.EOS_Lobby_UpdateLobbyModification(this, options, outLobbyModificationHandle);
	}

	/**
	 * Update a lobby given a lobby modification handle created by EOS_Lobby_UpdateLobbyModification
	 *
	 * @param options Structure containing information about the lobby to be updated
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the update operation completes, either successfully or in error
	 */
	public void updateLobby(EOS_Lobby_UpdateLobbyOptions options,
	                        Pointer clientData,
	                        EOS_Lobby_OnUpdateLobbyCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_UpdateLobby(this, options, clientData, completionDelegate);
	}

	/**
	 * Promote an existing member of the lobby to owner, allowing them to make lobby data modifications
	 *
	 * @param options Structure containing information about the lobby and member to be promoted
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the promotion operation completes, either successfully or in error
	 */
	public void promoteMember(EOS_Lobby_PromoteMemberOptions options,
	                          Pointer clientData,
	                          EOS_Lobby_OnPromoteMemberCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_PromoteMember(this, options, clientData, completionDelegate);
	}

	/**
	 * Kick an existing member from the lobby
	 *
	 * @param options Structure containing information about the lobby and member to be kicked
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the kick operation completes, either successfully or in error
	 */
	public void kickMember(EOS_Lobby_KickMemberOptions options,
	                       Pointer clientData,
	                       EOS_Lobby_OnKickMemberCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_KickMember(this, options, clientData, completionDelegate);
	}

	/**
	 * Hard mute an existing member in the lobby, can't speak but can hear other members of the lobby
	 *
	 * @param options Structure containing information about the lobby and member to be hard muted
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the hard mute operation completes, either successfully or in error
	 */
	public void hardMuteMember(EOS_Lobby_HardMuteMemberOptions options,
	                           Pointer clientData,
	                           EOS_Lobby_OnHardMuteMemberCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_HardMuteMember(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when a lobby owner updates the attributes associated with the lobby.<br>
	 * <b>Must call {@link #removeNotifyLobbyUpdateReceived} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLobbyUpdateReceived(EOS_Lobby_AddNotifyLobbyUpdateReceivedOptions options,
	                                                       Pointer clientData,
	                                                       EOS_Lobby_OnLobbyUpdateReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyUpdateReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a lobby changes its data.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyUpdateReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyUpdateReceived(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications when a lobby member updates the attributes associated with themselves inside the lobby.<br>
	 * <b>Must call {@link #removeNotifyLobbyMemberUpdateReceived} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLobbyMemberUpdateReceived(EOS_Lobby_AddNotifyLobbyMemberUpdateReceivedOptions options,
	                                                                       Pointer clientData,
	                                                                       EOS_Lobby_OnLobbyMemberUpdateReceivedCallback notificationFn)  {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyMemberUpdateReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when lobby members change their data.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyMemberUpdateReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyMemberUpdateReceived(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications about the changing status of lobby members.<br>
	 * <b>Must call {@link #removeNotifyLobbyMemberStatusReceived} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId EOS_Lobby_AddNotifyLobbyMemberStatusReceived(EOS_Lobby_AddNotifyLobbyMemberStatusReceivedOptions options,
	                                                                       Pointer clientData,
	                                                                       EOS_Lobby_OnLobbyMemberStatusReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyMemberStatusReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when lobby members status change.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyMemberStatusReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyMemberStatusReceived(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Send an invite to another user.  User must be a member of the lobby or else the call will fail
	 *
	 * @param options Structure containing information about the lobby and user to invite
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the send invite operation completes, either successfully or in error
	 */
	public void sendInvite(EOS_Lobby_SendInviteOptions options, Pointer clientData, EOS_Lobby_OnSendInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_SendInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Reject an invite from another user.
	 *
	 * @param options Structure containing information about the invite to reject
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the reject invite operation completes, either successfully or in error
	 */
	public void rejectInvite(EOS_Lobby_RejectInviteOptions options, Pointer clientData, EOS_Lobby_OnRejectInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_RejectInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Retrieve all existing invites for a single user
	 *
	 * @param options Structure containing information about the invites to query
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the query invites operation completes, either successfully or in error
	 */
	public void queryInvites(EOS_Lobby_QueryInvitesOptions options, Pointer clientData, EOS_Lobby_OnQueryInvitesCallback completionDelegate) {
		EOSLibrary.instance.EOS_Lobby_QueryInvites(this, options, clientData, completionDelegate);
	}

	/**
	 * Get the number of known invites for a given user
	 *
	 * @param options the Options associated with retrieving the current invite count
	 *
	 * @return number of known invites for a given user or 0 if there is an error
	 */
	public int getInviteCount(EOS_Lobby_GetInviteCountOptions options) {
		return EOSLibrary.instance.EOS_Lobby_GetInviteCount(this, options);
	}

	/**
	 * Retrieve an invite ID from a list of active invites for a given user
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return invite ID stringified version
	 *
	 * @throws EOSInvalidParametersException if any of the options are incorrect
	 * @throws EOSNotFoundException if the invite doesn't exist
	 *
	 * @see #getInviteCount(EOS_Lobby_GetInviteCountOptions)
	 * @see #copyLobbyDetailsHandleByInviteId(EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions, PointerByReference)
	 */
	public String getInviteIdByIndex(EOS_Lobby_GetInviteIdByIndexOptions options) throws EOSException {
		final ByteBuffer outBuffer = ByteBuffer.allocate(EOS_LOBBY_INVITEID_MAX_LENGTH + 1);
		final IntByReference inOutBufferLength = new IntByReference(outBuffer.capacity());
		final EOS_EResult result = EOSLibrary.instance.EOS_Lobby_GetInviteIdByIndex(this, options, outBuffer, inOutBufferLength);
		if (result.isSuccess()) {
			return new String(outBuffer.array(), 0, inOutBufferLength.getValue()).trim();
		}
		throw EOSException.fromResult(result);
	}

	/**
	 * Create a lobby search handle.  This handle may be modified to include various search parameters.
	 * Searching is possible in three methods, all mutually exclusive:<br>
	 * <ul>
	 * <li>set the lobby ID to find a specific lobby
	 * <li>set the target user ID to find a specific user
	 * <li>set lobby parameters to find an array of lobbies that match the search criteria (not available yet)
	 * </ul>
	 * @param options Structure containing required parameters such as the maximum number of search results
	 * @param outLobbySearchHandle The new search handle or null if there was an error creating the search handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the search creation completes successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult createLobbySearch(EOS_Lobby_CreateLobbySearchOptions options, PointerByReference outLobbySearchHandle) {
		return EOSLibrary.instance.EOS_Lobby_CreateLobbySearch(this, options, outLobbySearchHandle);
	}

	/**
	 * Register to receive notifications about lobby invites sent to local users.<br>
	 * <b>Must call {@link #removeNotifyLobbyInviteReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLobbyInviteReceived(EOS_Lobby_AddNotifyLobbyInviteReceivedOptions options,
	                                                       Pointer clientData,
	                                                       EOS_Lobby_OnLobbyInviteReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyInviteReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user receives a lobby invitation.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyInviteReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyInviteReceived(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications about lobby invites accepted by local user via the overlay.<br>
	 * <b>Must call {@link #removeNotifyLobbyInviteAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLobbyInviteAccepted(EOS_Lobby_AddNotifyLobbyInviteAcceptedOptions options,
	                                                                 Pointer clientData,
	                                                                 EOS_Lobby_OnLobbyInviteAcceptedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyInviteAccepted(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user accepts a lobby invitation via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyInviteAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyInviteAccepted(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications about lobby invites rejected by local user via the overlay.<br>
	 * <b>Must call {@link #removeNotifyLobbyInviteRejected(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLobbyInviteRejected(EOS_Lobby_AddNotifyLobbyInviteRejectedOptions options, Pointer clientData, EOS_Lobby_OnLobbyInviteRejectedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyLobbyInviteRejected(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user rejects a lobby invitation via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLobbyInviteRejected(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyLobbyInviteRejected(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications about lobby "JOIN" performed by local user (when no invite) via the overlay.<br>
	 * <b>Must call {@link #removeNotifyJoinLobbyAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyJoinLobbyAccepted(EOS_Lobby_AddNotifyJoinLobbyAcceptedOptions options,
	                                                               Pointer clientData,
	                                                               EOS_Lobby_OnJoinLobbyAcceptedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyJoinLobbyAccepted(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user accepts a lobby invitation via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyJoinLobbyAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyJoinLobbyAccepted(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Register to receive notifications about a lobby "INVITE" performed by a local user via the overlay.
	 * This is only needed when a configured integrated platform has EOS_IPMF_DisableSDKManagedSessions set.  The EOS SDK will
	 * then use the state of EOS_IPMF_PreferEOSIdentity and EOS_IPMF_PreferIntegratedIdentity to determine when the NotificationFn is
	 * called.<br>
	 * <b>Must call {@link #removeNotifySendLobbyNativeInviteRequested(EOS_NotificationId)} to remove the notification.</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 *
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_DisableSDKManagedSessions
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_PreferEOSIdentity
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_PreferIntegratedIdentity
	 */
	public EOS_NotificationId addNotifySendLobbyNativeInviteRequested(EOS_Lobby_AddNotifySendLobbyNativeInviteRequestedOptions options,
	                                                                            Pointer clientData,
	                                                                            EOS_Lobby_OnSendLobbyNativeInviteRequestedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifySendLobbyNativeInviteRequested(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user requests a send invite via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySendLobbyNativeInviteRequested(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifySendLobbyNativeInviteRequested(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * EOS_Lobby_CopyLobbyDetailsHandleByInviteId is used to immediately retrieve a handle to the lobby information from after notification of an invite
	 * If the call returns an EOS_Success result, the out parameter, OutLobbyDetailsHandle, must be passed to EOS_LobbyDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outLobbyDetailsHandle out parameter used to receive the lobby handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLobbyDetailsHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid invite ID or a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} If the invite ID cannot be found
	 *
	 * @see EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_EResult copyLobbyDetailsHandleByInviteId(EOS_Lobby_CopyLobbyDetailsHandleByInviteIdOptions options, PointerByReference outLobbyDetailsHandle) {
		return EOSLibrary.instance.EOS_Lobby_CopyLobbyDetailsHandleByInviteId(this, options, outLobbyDetailsHandle);
	}

	/**
	 * EOS_Lobby_CopyLobbyDetailsHandleByUiEventId is used to immediately retrieve a handle to the lobby information from after notification of an join game
	 * If the call returns an EOS_Success result, the out parameter, OutLobbyDetailsHandle, must be passed to EOS_LobbyDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outLobbyDetailsHandle out parameter used to receive the lobby handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLobbyDetailsHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid ui event ID<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} If the invite ID cannot be found
	 *
	 * @see EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_EResult copyLobbyDetailsHandleByUiEventId(EOS_Lobby_CopyLobbyDetailsHandleByUiEventIdOptions options, PointerByReference outLobbyDetailsHandle) {
		return EOSLibrary.instance.EOS_Lobby_CopyLobbyDetailsHandleByUiEventId(this, options, outLobbyDetailsHandle);
	}

	/**
	 * Create a handle to an existing lobby.
	 * If the call returns an EOS_Success result, the out parameter, OutLobbyDetailsHandle, must be passed to EOS_LobbyDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing information about the lobby to retrieve
	 * @param outLobbyDetailsHandle The new active lobby handle or null if there was an error
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the lobby handle was created successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the lobby doesn't exist
	 */
	public EOS_EResult copyLobbyDetailsHandle(EOS_Lobby_CopyLobbyDetailsHandleOptions options, PointerByReference outLobbyDetailsHandle) {
		return EOSLibrary.instance.EOS_Lobby_CopyLobbyDetailsHandle(this, options, outLobbyDetailsHandle);
	}

	/**
	 * Get the name of the RTC room associated with a specific lobby a local user belongs to.
	 * <p>
	 * This value can be used whenever you need a RoomName value in the RTC_* suite of functions. RTC Room Names must not be used with
	 * EOS_RTC_JoinRoom, EOS_RTC_LeaveRoom, or EOS_RTC_AddNotifyDisconnected. Doing so will return EOS_AccessDenied or
	 * EOS_INVALID_NOTIFICATIONID if used with those functions.
	 * <p>
	 * This function will only succeed when called on a lobby the local user is currently a member of.
	 *
	 * @param options Structure containing information about the RTC room name to retrieve
	 * @param outBuffer The buffer to store the null-terminated room name string within
	 * @param inOutBufferLength In: The maximum amount of writable chars in OutBuffer, Out: The minimum amount of chars needed in OutBuffer to store the RTC room name (including the null-terminator)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if a room exists for the specified lobby, there was enough space in OutBuffer, and the name was written successfully<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the lobby does not exist<br>
	 *         {@link EOS_EResult#EOS_Disabled} if the lobby exists, but did not have the RTC Room feature enabled when created<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer on invalid length for any of the parameters<br>
	 *         {@link EOS_EResult#EOS_LimitExceeded} The OutBuffer is not large enough to receive the room name. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 */
	public EOS_EResult getRTCRoomName(EOS_Lobby_GetRTCRoomNameOptions options, ByteBuffer outBuffer, IntBuffer inOutBufferLength) {
		return EOSLibrary.instance.EOS_Lobby_GetRTCRoomName(this, options, outBuffer, inOutBufferLength);
	}

	/**
	 * Get the current connection status of the RTC Room for a lobby.
	 * <p>
	 * The RTC Room connection status is independent of the lobby connection status, however the lobby system will attempt to keep
	 * them consistent, automatically connecting to the RTC room after joining a lobby which has an associated RTC room and disconnecting
	 * from the RTC room when a lobby is left or disconnected.
	 * <p>
	 * This function will only succeed when called on a lobby the local user is currently a member of.
	 *
	 * @param options Structure containing information about the lobby to query the RTC Room connection status for
	 * @param bOutIsConnected If the result is EOS_Success, this will be set to EOS_TRUE if we are connected, or EOS_FALSE if we are not yet connected.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if we are connected to the specified lobby, the input options and parameters were valid and we were able to write to bOutIsConnected successfully.<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the lobby doesn't exist<br>
	 *         {@link EOS_EResult#EOS_Disabled} if the lobby exists, but did not have the RTC Room feature enabled when created<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if bOutIsConnected is NULL, or any other parameters are NULL or invalid
	 *
	 * @see #addNotifyRTCRoomConnectionChanged(EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions, Pointer, EOS_Lobby_OnRTCRoomConnectionChangedCallback)
	 */
	public EOS_EResult isRTCRoomConnected(EOS_Lobby_IsRTCRoomConnectedOptions options, IntBuffer bOutIsConnected) {
		return EOSLibrary.instance.EOS_Lobby_IsRTCRoomConnected(this, options, bOutIsConnected);
	}

	/**
	 * Register to receive notifications of when the RTC Room for a particular lobby has a connection status change.
	 * <p>
	 * The RTC Room connection status is independent of the lobby connection status, however the lobby system will attempt to keep
	 * them consistent, automatically connecting to the RTC room after joining a lobby which has an associated RTC room and disconnecting
	 * from the RTC room when a lobby is left or disconnected.
	 * <p>
	 * This notification is entirely informational and requires no action in response by the application. If the connected status is offline
	 * (IsConnected is EOS_FALSE), the connection will automatically attempt to reconnect. The purpose of this notification is to allow
	 * applications to show the current connection status of the RTC room when the connection is not established.
	 * <p>
	 * Unlike EOS_RTC_AddNotifyDisconnected, EOS_RTC_LeaveRoom should not be called when the RTC room is disconnected.
	 * <p>
	 * This function will only succeed when called on a lobby the local user is currently a member of.
	 *
	 * @param options Structure containing information about the lobby to receive updates about
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn The function to call if the RTC Room's connection status changes
	 *
	 * @return A valid notification ID if the NotificationFn was successfully registered, or EOS_INVALID_NOTIFICATIONID if the input was invalid, the lobby did not exist, or the lobby did not have an RTC room.
	 *
	 * @see #removeNotifyRTCRoomConnectionChanged(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyRTCRoomConnectionChanged(EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions options,
	                                                                      Pointer clientData,
	                                                                      EOS_Lobby_OnRTCRoomConnectionChangedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Lobby_AddNotifyRTCRoomConnectionChanged(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when an RTC Room's connection status changes.
	 * <p>
	 * This should be called when the local user is leaving a lobby.
	 *
	 * @param inId Handle representing the registered callback
	 *
	 * @see #addNotifyRTCRoomConnectionChanged(EOS_Lobby_AddNotifyRTCRoomConnectionChangedOptions, Pointer, EOS_Lobby_OnRTCRoomConnectionChangedCallback)
	 */
	public void removeNotifyRTCRoomConnectionChanged(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Lobby_RemoveNotifyRTCRoomConnectionChanged(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}
}