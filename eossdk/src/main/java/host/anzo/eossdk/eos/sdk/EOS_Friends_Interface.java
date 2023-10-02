package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.friends.callbacks.*;
import host.anzo.eossdk.eos.sdk.friends.enums.EOS_EFriendsStatus;
import host.anzo.eossdk.eos.sdk.friends.options.*;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The Friends Interface is used to manage a user's friends list, by interacting with the backend services, and to retrieve the cached list of friends, blocked users and pending invitations.
 * All Friends Interface calls take a handle of type EOS_HFriends as the first parameter.
 * This handle can be retrieved from a EOS_HPlatform handle by using the EOS_Platform_GetFriendsInterface function.
 *
 * @see EOS_Platform_Interface#getFriendsInterface()
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_Friends_Interface extends PointerType {
	public EOS_Friends_Interface(Pointer address) {
		super(address);
	}
	public EOS_Friends_Interface() {
		super();
	}

	/**
	 * Starts an asynchronous task that reads the user's friends list and blocklist from the backend service, caching it for future use.<br>
	 * <b>When the Social Overlay is enabled then this will be called automatically.  The Social Overlay is enabled by default (see {@link EOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY}).</b>
	 *
	 * @param options structure containing the account for which to retrieve the friends list
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void queryFriends(EOS_Friends_QueryFriendsOptions options, Pointer clientData, EOS_Friends_OnQueryFriendsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Friends_QueryFriends(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task that sends a friend invitation to another user. The completion delegate is executed after the backend response has been received.
	 * It does not indicate that the target user has responded to the friend invitation.
	 *
	 * @param options structure containing the account to send the invite from and the account to send the invite to
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void sendInvite(EOS_Friends_SendInviteOptions options, Pointer clientData, EOS_Friends_OnSendInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Friends_SendInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task that accepts a friend invitation from another user. The completion delegate is executed after the backend response has been received.
	 *
	 * @param options structure containing the logged in account and the inviting account
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void acceptInvite(EOS_Friends_AcceptInviteOptions options, Pointer clientData, EOS_Friends_OnAcceptInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Friends_AcceptInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task that rejects a friend invitation from another user. The completion delegate is executed after the backend response has been received.
	 *
	 * @param options structure containing the logged in account and the inviting account
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void rejectInvite(EOS_Friends_RejectInviteOptions options, Pointer clientData, EOS_Friends_OnRejectInviteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Friends_RejectInvite(this, options, clientData, completionDelegate);
	}

	/**
	 * Retrieves the number of friends on the friends list that has already been retrieved by the EOS_Friends_QueryFriends API.
	 *
	 * @param options structure containing the Epic Account ID of user who owns the friends list
	 * @return the number of friends on the list
	 *
	 * @see EOS_Friends_Interface#getFriendAtIndex(EOS_Friends_GetFriendAtIndexOptions)
	 */
	public int getFriendsCount(EOS_Friends_GetFriendsCountOptions options) {
		return EOSLibrary.instance.EOS_Friends_GetFriendsCount(this, options);
	}

	/**
	 * Retrieves the Epic Account ID of an entry from the friends list that has already been retrieved by the EOS_Friends_QueryFriends API.
	 * The Epic Account ID returned by this function may belong to an account that has been invited to be a friend or that has invited the local user to be a friend.
	 * To determine if the Epic Account ID returned by this function is a friend or a pending friend invitation, use the EOS_Friends_GetStatus function.
	 *
	 * @param options structure containing the Epic Account ID of the owner of the friends list and the index into the list
	 * @return the Epic Account ID of the friend. Note that if the index provided is out of bounds, the returned Epic Account ID will be a "null" account ID.
	 *
	 * @see EOS_Friends_Interface#getFriendsCount(EOS_Friends_GetFriendsCountOptions)
	 * @see EOS_Friends_Interface#getStatus(EOS_Friends_GetStatusOptions)
	 */
	public EOS_EpicAccountId getFriendAtIndex(EOS_Friends_GetFriendAtIndexOptions options) {
		return EOSLibrary.instance.EOS_Friends_GetFriendAtIndex(this, options);
	}

	/**
	 * Retrieve the friendship status between the local user and another user.
	 *
	 * @param options structure containing the Epic Account ID of the friend list to check and the account of the user to test friendship status
	 * @return A value indicating whether the two accounts have a friendship, pending invites in either direction, or no relationship<br>
	 *         {@link EOS_EFriendsStatus#EOS_FS_Friends} is returned for two users that have confirmed friendship<br>
	 *         {@link EOS_EFriendsStatus#EOS_FS_InviteSent} is returned when the local user has sent a friend invitation but the other user has not accepted or rejected it<br>
	 *         {@link EOS_EFriendsStatus#EOS_FS_InviteReceived} is returned when the other user has sent a friend invitation to the local user<br>
	 *         {@link EOS_EFriendsStatus#EOS_FS_NotFriends} is returned when there is no known relationship
	 *
	 * @see EOS_EFriendsStatus
	 */
	public EOS_EFriendsStatus getStatus(EOS_Friends_GetStatusOptions options) {
		return EOSLibrary.instance.EOS_Friends_GetStatus(this, options);
	}

	/**
	 * Listen for changes to friends for a particular account.
	 *
	 * @param options Information about who would like notifications.
	 * @param clientData This value is returned to the caller when FriendsUpdateHandler is invoked.
	 * @param friendsUpdateHandler The callback to be invoked when a change to any friend status changes.
	 * @return A valid notification ID if successfully bound, or EOS_INVALID_NOTIFICATIONID otherwise
	 */
	public EOS_NotificationId addNotifyFriendsUpdate(EOS_Friends_AddNotifyFriendsUpdateOptions options,
	                                                             Pointer clientData,
	                                                             EOS_Friends_OnFriendsUpdateCallback friendsUpdateHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Friends_AddNotifyFriendsUpdate(this, options, clientData, friendsUpdateHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, friendsUpdateHandler);
		}
		return notificationId;
	}

	/**
	 * Stop listening for friends changes on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID.
	 */
	public void removeNotifyFriendsUpdate(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_Friends_RemoveNotifyFriendsUpdate(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Retrieves the number of blocked users on the blocklist that has already been retrieved by the EOS_Friends_QueryFriends API.
	 *
	 * @param options structure containing the Epic Account ID of user who owns the blocklist.
	 * @return the number of users on the blocklist.
	 *
	 * @see EOS_Friends_Interface#queryFriends(EOS_Friends_QueryFriendsOptions, Pointer, EOS_Friends_OnQueryFriendsCallback)
	 */
	public int getBlockedUsersCount(EOS_Friends_GetBlockedUsersCountOptions options) {
		return EOSLibrary.instance.EOS_Friends_GetBlockedUsersCount(this, options);
	}

	/**
	 * Retrieves the Epic Account ID of an entry from the blocklist that has already been retrieved by the EOS_Friends_QueryFriends API.
	 *
	 * @param options structure containing the Epic Account ID of the owner of the blocklist and the index into the list.
	 * @return the Epic Account ID of the blocked user. Note that if the index provided is out of bounds, the returned Epic Account ID will be a "null" account ID.
	 *
	 * @see EOS_Friends_Interface#queryFriends(EOS_Friends_QueryFriendsOptions, Pointer, EOS_Friends_OnQueryFriendsCallback)
	 * @see EOS_Friends_Interface#getBlockedUsersCount(EOS_Friends_GetBlockedUsersCountOptions)
	 */
	public EOS_EpicAccountId getBlockedUserAtIndex(EOS_Friends_GetBlockedUserAtIndexOptions options) {
		return EOSLibrary.instance.EOS_Friends_GetBlockedUserAtIndex(this, options);
	}

	/**
	 * Listen for changes to blocklist for a particular account.
	 *
	 * @param options Information about the API version which is being used.
	 * @param clientData This value is returned to the caller when BlockedUsersUpdateHandler is invoked.
	 * @param blockedUsersUpdateHandler The callback to be invoked when a blocklist changes.
	 * @return A valid notification ID if successfully bound, or EOS_INVALID_NOTIFICATIONID otherwise.
	 */
	public EOS_NotificationId addNotifyBlockedUsersUpdate(EOS_Friends_AddNotifyBlockedUsersUpdateOptions options,
	                                                                  Pointer clientData,
	                                                                  EOS_Friends_OnBlockedUsersUpdateCallback blockedUsersUpdateHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Friends_AddNotifyBlockedUsersUpdate(this, options, clientData, blockedUsersUpdateHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, blockedUsersUpdateHandler);
		}
		return notificationId;
	}

	/**
	 * Stop listening for blocklist changes on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID.
	 */
	public void removeNotifyBlockedUsersUpdate(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_Friends_RemoveNotifyBlockedUsersUpdate(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}
}