package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.integratedplatform.enums.EOS_EIntegratedPlatformManagementFlags;
import host.anzo.eossdk.eos.sdk.sessions.EOS_ActiveSession;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionSearch;
import host.anzo.eossdk.eos.sdk.sessions.callbacks.*;
import host.anzo.eossdk.eos.sdk.sessions.options.*;

/**
 * The Session Interface is used to manage sessions that can be advertised with the backend service
 * All Session Interface calls take a handle of type EOS_HSessions as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetSessionsInterface function.
 *
 * @see EOS_Platform_Interface#getSessionsInterface()
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public class EOS_Sessions_Interface extends PointerType {
	/** Max length of an invite ID */
	public static final int EOS_SESSIONS_INVITEID_MAX_LENGTH = 64;

	public EOS_Sessions_Interface(Pointer address) {
		super(address);
	}
	public EOS_Sessions_Interface() {
		super();
	}

	/**
	 * Creates a session modification handle (EOS_SessionModification).  The session modification handle is used to build a new session and can be applied with EOS_Sessions_UpdateSession
	 * The EOS_SessionModification must be released by calling EOS_SessionModification_Release once it no longer needed.
	 *
	 * @param options Required fields for the creation of a session such as a name, bucketid, and max players
	 * @param outSessionModificationHandle Pointer to a Session Modification Handle only set if successful
	 * @return {@link EOS_EResult#EOS_Success} if we successfully created the Session Modification Handle pointed at in outSessionModificationHandle, or an error result if the input data was invalid
	 *
	 * @see EOS_SessionModification#release()
	 * @see #updateSession(EOS_Sessions_UpdateSessionOptions, Pointer, EOS_Sessions_OnUpdateSessionCallback)
	 * @see EOS_SessionModification
	 */
	public EOS_EResult createSessionModification(EOS_Sessions_CreateSessionModificationOptions options, EOS_SessionModification outSessionModificationHandle) {
		return EOSLibrary.instance.EOS_Sessions_CreateSessionModification(this, options, outSessionModificationHandle);
	}

	/**
	 * Creates a session modification handle (EOS_SessionModification). The session modification handle is used to modify an existing session and can be applied with EOS_Sessions_UpdateSession.
	 * The EOS_SessionModification must be released by calling EOS_SessionModification_Release once it is no longer needed.
	 *
	 * @param options Required fields such as session name
	 * @param outSessionModificationHandle Pointer to a Session Modification Handle only set if successful
	 * @return {@link EOS_EResult#EOS_Success} if we successfully created the Session Modification Handle pointed at in outSessionModificationHandle, or an error result if the input data was invalid
	 *
	 * @see EOS_SessionModification#release()
	 * @see #updateSession(EOS_Sessions_UpdateSessionOptions, Pointer, EOS_Sessions_OnUpdateSessionCallback)
	 * @see EOS_SessionModification
	 */
	public EOS_EResult updateSessionModification(EOS_Sessions_UpdateSessionModificationOptions options, EOS_SessionModification outSessionModificationHandle) {
		return EOSLibrary.instance.EOS_Sessions_UpdateSessionModification(this, options, outSessionModificationHandle);
	}

	/**
	 * Update a session given a session modification handle created by EOS_Sessions_CreateSessionModification or EOS_Sessions_UpdateSessionModification
	 *
	 * @param options Structure containing information about the session to be updated
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the update operation completes, either successfully or in error
	 */
	public void updateSession(EOS_Sessions_UpdateSessionOptions options, Pointer clientData, EOS_Sessions_OnUpdateSessionCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_UpdateSession(this, options, clientData, completionDelegate);
	}

	/**
	 * Destroy a session given a session name
	 *
	 * @param options Structure containing information about the session to be destroyed
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the destroy operation completes, either successfully or in error
	 */
	public void destroySession(EOS_Sessions_DestroySessionOptions options, Pointer clientData, EOS_Sessions_OnDestroySessionCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_DestroySession(this, options, clientData, completionDelegate);
	}

	/**
	 * Join a session, creating a local session under a given session name.  Backend will validate various conditions to make sure it is possible to join the session.
	 *
	 * @param options Structure containing information about the session to be joined
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the join operation completes, either successfully or in error
	 */
	public void joinSession(EOS_Sessions_JoinSessionOptions options, Pointer clientData, EOS_Sessions_OnJoinSessionCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_JoinSession(this, options, clientData, completionDelegate);
	}

	/**
	 * Mark a session as started, making it unable to find if session properties indicate "join in progress" is not available
	 *
	 * @param options Structure containing information about the session to be started
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the start operation completes, either successfully or in error
	 */
	public void startSession(EOS_Sessions_StartSessionOptions options, Pointer clientData, EOS_Sessions_OnStartSessionCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_StartSession(this, options, clientData, completionDelegate);
	}

	/**
	 * Mark a session as ended, making it available to find if "join in progress" was disabled.  The session may be started again if desired
	 *
	 * @param options Structure containing information about the session to be ended
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the end operation completes, either successfully or in error
	 */
	public void endSession(EOS_Sessions_EndSessionOptions options, Pointer clientData, EOS_Sessions_OnEndSessionCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_EndSession(this, options, clientData, completionDelegate);
	}

	/**
	 * Register a group of players with the session, allowing them to invite others or otherwise indicate they are part of the session for determining a full session
	 *
	 * @param options Structure containing information about the session and players to be registered
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the registration operation completes, either successfully or in error
	 */
	public void registerPlayers(EOS_Sessions_RegisterPlayersOptions options, Pointer clientData, EOS_Sessions_OnRegisterPlayersCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_RegisterPlayers(this, options, clientData, completionDelegate);
	}

	/**
	 * Unregister a group of players with the session, freeing up space for others to join
	 *
	 * @param options Structure containing information about the session and players to be unregistered
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the unregistration operation completes, either successfully or in error
	 */
	public void unregisterPlayers(EOS_Sessions_UnregisterPlayersOptions options,
	                                           Pointer clientData,
	                                           EOS_Sessions_OnUnregisterPlayersCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_UnregisterPlayers(this, options, clientData, completionDelegate);
	}

	/**
	 * Send an invite to another player.  User must have created the session or be registered in the session or else the call will fail
	 *
	 * @param options Structure containing information about the session and player to invite
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the send invite operation completes, either successfully or in error
	 */
	public void sendInvite(EOS_Sessions_SendInviteOptions options, Pointer clientData, EOS_Sessions_OnSendInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_SendInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Reject an invite from another player.
	 *
	 * @param options Structure containing information about the invite to reject
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the reject invite operation completes, either successfully or in error
	 */
	public void rejectInvite(EOS_Sessions_RejectInviteOptions options, Pointer clientData, EOS_Sessions_OnRejectInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_RejectInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Retrieve all existing invites for a single user
	 *
	 * @param options Structure containing information about the invites to query
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the query invites operation completes, either successfully or in error
	 */
	public void queryInvites(EOS_Sessions_QueryInvitesOptions options, Pointer clientData, EOS_Sessions_OnQueryInvitesCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sessions_QueryInvites(this, options, clientData, completionDelegate);
	}

	/**
	 * Get the number of known invites for a given user
	 *
	 * @param options the options associated with retrieving the current invite count
	 *
	 * @return number of known invites for a given user or 0 if there is an error
	 */
	public int getInviteCount(EOS_Sessions_GetInviteCountOptions options) {
		return EOSLibrary.instance.EOS_Sessions_GetInviteCount(this, options);
	}

	/**
	 * Retrieve an invite ID from a list of active invites for a given user
	 *
	 * @param options Structure containing the input parameters
	 * @return invite ID
	 *
	 * @throws EOSInvalidParametersException if any of the options are incorrect
	 * @throws EOSNotFoundException if the invite doesn't exist
	 *
	 * @see #getInviteCount(EOS_Sessions_GetInviteCountOptions)
	 * @see #copySessionHandleByInviteId(EOS_Sessions_CopySessionHandleByInviteIdOptions, EOS_SessionDetails)
	 */
	public String getInviteIdByIndex(EOS_Sessions_GetInviteIdByIndexOptions options) throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_SESSIONS_INVITEID_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_SESSIONS_INVITEID_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Sessions_GetInviteIdByIndex(this, options, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}

	/**
	 * Create a session search handle.  This handle may be modified to include various search parameters.
	 * Searching is possible in three methods, all mutually exclusive
	 * <ul>
	 * <li>set the session ID to find a specific session
	 * <li>set the target user ID to find a specific user
	 * <li>set session parameters to find an array of sessions that match the search criteria
	 * </ul>
	 * @param options Structure containing required parameters such as the maximum number of search results
	 * @param outSessionSearchHandle The new search handle or null if there was an error creating the search handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the search creation completes successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult createSessionSearch(EOS_Sessions_CreateSessionSearchOptions options, EOS_SessionSearch outSessionSearchHandle) {
		return EOSLibrary.instance.EOS_Sessions_CreateSessionSearch(this, options, outSessionSearchHandle);
	}

	/**
	 * Create a handle to an existing active session.
	 *
	 * @param options Structure containing information about the active session to retrieve
	 * @param outSessionHandle The new active session handle or null if there was an error
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the session handle was created successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the active session doesn't exist
	 */
	public EOS_EResult copyActiveSessionHandle(EOS_Sessions_CopyActiveSessionHandleOptions options, EOS_ActiveSession outSessionHandle) {
		return EOSLibrary.instance.EOS_Sessions_CopyActiveSessionHandle(this, options, outSessionHandle);
	}

	/**
	 * Register to receive session invites.<br>
	 * <b>Must call {@link #removeNotifySessionInviteReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the session invite notification
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param notificationFn A callback that is fired when a session invite for a user has been received
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifySessionInviteReceived(EOS_Sessions_AddNotifySessionInviteReceivedOptions options,
	                                                                      Pointer clientData,
	                                                                      EOS_Sessions_OnSessionInviteReceivedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifySessionInviteReceived(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving session invites.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySessionInviteReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifySessionInviteReceived(this, inId);
	}

	/**
	 * Register to receive notifications when a user accepts a session invite via the social overlay.<br>
	 * <b>Must call {@link #removeNotifySessionInviteAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifySessionInviteAccepted(EOS_Sessions_AddNotifySessionInviteAcceptedOptions options,
	                                                                      Pointer clientData,
	                                                                      EOS_Sessions_OnSessionInviteAcceptedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifySessionInviteAccepted(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving notifications when a user accepts a session invite via the social overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySessionInviteAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifySessionInviteAccepted(this, inId);
	}

	/**
	 * Register to receive notifications when a user rejects a session invite.<br>
	 * <b>Must call {@link #removeNotifySessionInviteRejected(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifySessionInviteRejected(EOS_Sessions_AddNotifySessionInviteRejectedOptions options,
	                                                         Pointer clientData,
	                                                         EOS_Sessions_OnSessionInviteRejectedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifySessionInviteRejected(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving notifications when a user rejects a session invite via the social overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySessionInviteRejected(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifySessionInviteRejected(this, inId);
	}

	/**
	 * Register to receive notifications when a user accepts a session join game via the social overlay.<br>
	 * <b>Must call {@link #removeNotifyJoinSessionAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyJoinSessionAccepted(EOS_Sessions_AddNotifyJoinSessionAcceptedOptions options,
	                                                       Pointer clientData,
	                                                       EOS_Sessions_OnJoinSessionAcceptedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifyJoinSessionAccepted(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving notifications when a user accepts a session join game via the social overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyJoinSessionAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifyJoinSessionAccepted(this, inId);
	}

	/**
	 * EOS_Sessions_CopySessionHandleByInviteId is used to immediately retrieve a handle to the session information from after notification of an invite
	 * If the call returns an EOS_Success result, the out parameter, OutSessionHandle, must be passed to EOS_SessionDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outSessionHandle out parameter used to receive the session handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in outSessionHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid invite ID or a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the invite ID cannot be found
	 *
	 * @see EOS_Sessions_CopySessionHandleByInviteIdOptions
	 * @see EOS_SessionDetails#release()
	 */
	public EOS_EResult copySessionHandleByInviteId(EOS_Sessions_CopySessionHandleByInviteIdOptions options, EOS_SessionDetails outSessionHandle) {
		return EOSLibrary.instance.EOS_Sessions_CopySessionHandleByInviteId(this, options, outSessionHandle);
	}

	/**
	 * EOS_Sessions_CopySessionHandleByUiEventId is used to immediately retrieve a handle to the session information from after notification of a join game event.
	 * If the call returns an EOS_Success result, the out parameter, OutSessionHandle, must be passed to EOS_SessionDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outSessionHandle out parameter used to receive the session handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutSessionHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid invite ID or a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the invite ID cannot be found
	 *
	 * @see EOS_Sessions_CopySessionHandleByUiEventIdOptions
	 * @see EOS_SessionDetails#release()
	 */
	public EOS_EResult copySessionHandleByUiEventId(EOS_Sessions_CopySessionHandleByUiEventIdOptions options, EOS_SessionDetails outSessionHandle) {
		return EOSLibrary.instance.EOS_Sessions_CopySessionHandleByUiEventId(this, options, outSessionHandle);
	}

	/**
	 * EOS_Sessions_CopySessionHandleForPresence is used to immediately retrieve a handle to the session information which was marked with bPresenceEnabled on create or join.
	 * If the call returns an EOS_Success result, the out parameter, OutSessionHandle, must be passed to EOS_SessionDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outSessionHandle out parameter used to receive the session handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutSessionHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid invite ID or a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if there is no session with bPresenceEnabled
	 *
	 * @see EOS_Sessions_CopySessionHandleForPresenceOptions
	 * @see EOS_SessionDetails#release()
	 */
	public EOS_EResult copySessionHandleForPresence(EOS_Sessions_CopySessionHandleForPresenceOptions options, EOS_SessionDetails outSessionHandle) {
		return EOSLibrary.instance.EOS_Sessions_CopySessionHandleForPresence(this, options, outSessionHandle);
	}

	/**
	 * EOS_Sessions_IsUserInSession returns whether or not a given user can be found in a specified session
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the user is found in the specified session<br>
	 *		   {@link EOS_EResult#EOS_NotFound} if the user is not found in the specified session<br>
	 *		   {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid invite ID or a null pointer for the out parameter<br>
	 *		   {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 *		   {@link EOS_EResult#EOS_Invalid_ProductUserID} if an invalid target user is specified<br>
	 *		   {@link EOS_EResult#EOS_Sessions_InvalidSession} if the session specified is invalid
	 */
	public EOS_EResult isUserInSession(EOS_Sessions_IsUserInSessionOptions options) {
		return EOSLibrary.instance.EOS_Sessions_IsUserInSession(this, options);
	}

	/**
	 * Dump the contents of active sessions that exist locally to the log output, purely for debug purposes
	 *
	 * @param options Options related to dumping session state such as the session name
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the output operation completes successfully<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the session specified does not exist<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult dumpSessionState(EOS_Sessions_DumpSessionStateOptions options) {
		return EOSLibrary.instance.EOS_Sessions_DumpSessionState(this, options);
	}

	/**
	 * Register to receive notifications about leave session requests performed by local user via the overlay.
	 * When user requests to leave the session in the social overlay, the SDK does not automatically leave the session, it is up to the game to perform any necessary cleanup and call the EOS_Sessions_DestroySession method using the SessionName sent in the notification function.<br>
	 * <b>Must call {@link #removeNotifyLeaveSessionRequested(EOS_NotificationId)} to remove the notification.</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLeaveSessionRequested(EOS_Sessions_AddNotifyLeaveSessionRequestedOptions options,
	                                                         Pointer clientData,
	                                                         EOS_Sessions_OnLeaveSessionRequestedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifyLeaveSessionRequested(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving notifications when a user performs a leave lobby action via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyLeaveSessionRequested(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifyLeaveSessionRequested(this, inId);
	}

	/**
	 * Register to receive notifications about a session "INVITE" performed by a local user via the overlay.
	 * This is only needed when a configured integrated platform has EOS_IPMF_DisableSDKManagedSessions set.  The EOS SDK will
	 * then use the state of EOS_IPMF_PreferEOSIdentity and EOS_IPMF_PreferIntegratedIdentity to determine when the notificationFn is
	 * called.<br>
	 *
	 * <b>Must call {@link #removeNotifySendSessionNativeInviteRequested(EOS_NotificationId)} to remove the notification.</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 *
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_DisableSDKManagedSessions
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_PreferEOSIdentity
	 * @see EOS_EIntegratedPlatformManagementFlags#EOS_IPMF_PreferIntegratedIdentity
	 */
	public EOS_NotificationId addNotifySendSessionNativeInviteRequested(EOS_Sessions_AddNotifySendSessionNativeInviteRequestedOptions options,
	                                                                                 Pointer clientData,
	                                                                                 EOS_Sessions_OnSendSessionNativeInviteRequestedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Sessions_AddNotifySendSessionNativeInviteRequested(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving notifications when a user requests a send invite via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySendSessionNativeInviteRequested(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Sessions_RemoveNotifySendSessionNativeInviteRequested(this, inId);
	}
}