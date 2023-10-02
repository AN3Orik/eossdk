package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.custominvites.callbacks.*;
import host.anzo.eossdk.eos.sdk.custominvites.options.*;
import host.anzo.eossdk.eos.sdk.integratedplatform.enums.EOS_EIntegratedPlatformManagementFlags;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The Custom Invites Interface is designed to allow developers to have custom game Invite and Join operations driven by the Notification Service and supported by the Overlay (if desired).
 * All Custom Invites Interface calls take a handle of type EOS_HCustomInvites as the first parameter.
 * This handle can be retrieved from a EOS_HPlatform handle by using the EOS_Platform_GetCustomInvitesInterface function.
 *
 * @see EOS_Platform_Interface#getCustomInvitesInterface()
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public class EOS_CustomInvites_Interface extends PointerType {
	public EOS_CustomInvites_Interface(Pointer address) {
		super(address);
	}
	public EOS_CustomInvites_Interface() {
		super();
	}

	/**
	 * Initializes a Custom Invite with a specified payload in preparation for it to be sent to another user or users.
	 *
	 * @param options Structure containing information about the request.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options values are incorrect
	 */
	public EOS_EResult setCustomInvite(EOS_CustomInvites_SetCustomInviteOptions options) {
		return EOSLibrary.instance.EOS_CustomInvites_SetCustomInvite(this, options);
	}

	/**
	 * Sends a Custom Invite that has previously been initialized via SetCustomInvite to a group of users.
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void sendCustomInvite(EOS_CustomInvites_SendCustomInviteOptions options,
	                                               Pointer clientData,
	                                               EOS_CustomInvites_OnSendCustomInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_CustomInvites_SendCustomInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when a Custom Invite for any logged in local user is received<br>
	 * <b>Must call {@link #removeNotifyCustomInviteReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a Custom Invite is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyCustomInviteReceived(EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions options,
	                                                                          Pointer clientData,
	                                                                          EOS_CustomInvites_OnCustomInviteReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyCustomInviteReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a Custom Invite for any logged in local user is received
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyCustomInviteReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyCustomInviteReceived(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications when a Custom Invite for any logged in local user is accepted via the Social Overlay
	 * Invites accepted in this way still need to have FinalizeInvite called on them after you have finished processing the invite accept (e.g. after joining the game)<br>
	 * <b>Must call {@link #removeNotifyCustomInviteAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a Custom Invite is accepted via the Social Overlay.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyCustomInviteAccepted(EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions options,
	                                                                          Pointer clientData,
	                                                                          EOS_CustomInvites_OnCustomInviteAcceptedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyCustomInviteAccepted(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a Custom Invite for any logged in local user is accepted via the Social Overlay
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyCustomInviteAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyCustomInviteAccepted(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications when a Custom Invite for any logged in local user is rejected via the Social Overlay
	 * Invites rejected in this way do not need to have FinalizeInvite called on them, it is called automatically internally by the SDK.<br>
	 * <b>Must call {@link #removeNotifyCustomInviteRejected(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a Custom Invite is rejected via the Social Overlay.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyCustomInviteRejected(EOS_CustomInvites_AddNotifyCustomInviteRejectedOptions options,
	                                                                          Pointer clientData,
	                                                                          EOS_CustomInvites_OnCustomInviteRejectedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyCustomInviteRejected(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a Custom Invite for any logged in local user is rejected via the Social Overlay
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyCustomInviteRejected(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyCustomInviteRejected(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Signal that the title has completed processing a received Custom Invite, and that it should be cleaned up internally and in the Overlay
	 *
	 * @param options Structure containing information about the request.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the option values are incorrect
	 */
	public EOS_EResult finalizeInvite(EOS_CustomInvites_FinalizeInviteOptions options) {
		return EOSLibrary.instance.EOS_CustomInvites_FinalizeInvite(this, options);
	}

	/**
	 * Request that another user send an invitation.
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void sendRequestToJoin(EOS_CustomInvites_SendRequestToJoinOptions options,
	                                                Pointer clientData,
	                                                EOS_CustomInvites_OnSendRequestToJoinCallback completionDelegate) {
		EOSLibrary.instance.EOS_CustomInvites_SendRequestToJoin(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when a request to join is responded to by a target user. Note that there is no guarantee a response will be received for every request to join.
	 * A player is free to ignore a Request to Join until it expires at which point it will be deleted without sending a response.<br>
	 * <b>Must call {@link #removeNotifyRequestToJoinResponseReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a response is received for an invite request.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyRequestToJoinResponseReceived(EOS_CustomInvites_AddNotifyRequestToJoinResponseReceivedOptions options,
	                                                                                   Pointer clientData,
	                                                                                   EOS_CustomInvites_OnRequestToJoinResponseReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyRequestToJoinResponseReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a request to join for any logged in local user is received
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyRequestToJoinResponseReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyRequestToJoinResponseReceived(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications when a request to join is received for a local user<br>
	 * <b>Must call {@link #removeNotifyRequestToJoinReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a response is received for an invite request.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyRequestToJoinReceived(EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions options,
	                                                                           Pointer clientData,
	                                                                           EOS_CustomInvites_OnRequestToJoinReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyRequestToJoinReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a request to join for any logged in local user is received
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyRequestToJoinReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyRequestToJoinReceived(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications about a custom invite "INVITE" performed by a local user via the overlay.
	 * This is only needed when a configured integrated platform has EOS_IPMF_DisableSDKManagedSessions set.  The EOS SDK will
	 * then use the state of EOS_IPMF_PreferEOSIdentity and EOS_IPMF_PreferIntegratedIdentity to determine when the notificationFn is
	 * called.<br>
	 * <b>Must call {@link #removeNotifySendCustomNativeInviteRequested(EOS_NotificationId)} to remove the notification.</b>
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
	public EOS_NotificationId addNotifySendCustomNativeInviteRequested(EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions options,
	                                                                                     Pointer clientData,
	                                                                                     EOS_CustomInvites_OnSendCustomNativeInviteRequestedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user requests a send invite via the overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifySendCustomNativeInviteRequested(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifySendCustomNativeInviteRequested(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications when a Request to Join for any logged in local user is accepted via the Social Overlay<br>
	 * <b>Must call {@link #removeNotifyRequestToJoinAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a Request to Join is accepted via the Social Overlay.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyRequestToJoinAccepted(EOS_CustomInvites_AddNotifyRequestToJoinAcceptedOptions options,
	                                                                           Pointer clientData,
	                                                                           EOS_CustomInvites_OnRequestToJoinAcceptedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyRequestToJoinAccepted(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a Request to Join for any logged in local user is accepted via the Social Overlay
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyRequestToJoinAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyRequestToJoinAccepted(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Register to receive notifications when a Request to Join for any logged in local user is rejected via the Social Overlay<br>
	 * <b>Must call {@link #removeNotifyRequestToJoinRejected(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a Request to Join is accepted via the Social Overlay.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyRequestToJoinRejected(EOS_CustomInvites_AddNotifyRequestToJoinRejectedOptions options,
	                                                                           Pointer clientData,
	                                                                           EOS_CustomInvites_OnRequestToJoinRejectedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_CustomInvites_AddNotifyRequestToJoinRejected(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a Request to Join for any logged in local user is rejected via the Social Overlay
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyRequestToJoinRejected(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_CustomInvites_RemoveNotifyRequestToJoinRejected(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}

	/**
	 * Accept a request to join from another user
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void acceptRequestToJoin(EOS_CustomInvites_AcceptRequestToJoinOptions options,
	                                                  Pointer clientData,
	                                                  EOS_CustomInvites_OnAcceptRequestToJoinCallback completionDelegate) {
		EOSLibrary.instance.EOS_CustomInvites_AcceptRequestToJoin(this, options, clientData, completionDelegate);
	}

	/**
	 * Reject a request to join from another user
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void rejectRequestToJoin(EOS_CustomInvites_RejectRequestToJoinOptions options,
	                                                  Pointer clientData,
	                                                  EOS_CustomInvites_OnRejectRequestToJoinCallback completionDelegate) {
		EOSLibrary.instance.EOS_CustomInvites_RejectRequestToJoin(this, options, clientData, completionDelegate);
	}
}