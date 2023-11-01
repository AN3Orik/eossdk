package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSLimitExceededException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.presence.EOS_PresenceModification;
import host.anzo.eossdk.eos.sdk.presence.EOS_Presence_Info;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnJoinGameAcceptedCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnPresenceChangedCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_OnQueryPresenceCompleteCallback;
import host.anzo.eossdk.eos.sdk.presence.callbacks.EOS_Presence_SetPresenceCompleteCallback;
import host.anzo.eossdk.eos.sdk.presence.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The Presence methods enable you to query and read other player's presence information, or modify your own.
 * <p>
 * QueryPresence must be called once per login, per remote user, before data will be available. It is currently only possible to query presence for
 * users that are on your friends list, all other queries will return no results.
 *
 * @see EOS_Platform_Interface#getPresenceInterface()
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_Presence_Interface extends PointerType {
	public EOS_Presence_Interface(Pointer address) {
		super(address);
	}

	public EOS_Presence_Interface() {
		super();
	}

	/**
	 * Query a user's presence. This must complete successfully before CopyPresence will have valid results. If HasPresence returns true for a remote
	 * user, this does not need to be called.
	 *
	 * @param options Object containing properties related to who is querying presence and for what user
	 * @param clientData Optional pointer to help track this request, that is returned in the completion callback
	 * @param completionDelegate Pointer to a function that handles receiving the completion information
	 */
	public void queryPresence(EOS_Presence_QueryPresenceOptions options, Pointer clientData, EOS_Presence_OnQueryPresenceCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Presence_QueryPresence(this, options, clientData, completionDelegate);
	}

	/**
	 * Check if we already have presence for a user
	 *
	 * @param options Object containing properties related to who is requesting presence and for what user
	 * @return EOS_TRUE if we have presence for the requested user, or EOS_FALSE if the request was invalid or we do not have cached data
	 */
	public boolean hasPresence(EOS_Presence_HasPresenceOptions options) {
		return EOSLibrary.instance.EOS_Presence_HasPresence(this, options) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Get a user's cached presence object. If successful, this data must be released by calling EOS_Presence_Info_Release
	 *
	 * @param options Object containing properties related to who is requesting presence and for what user
	 * @return A pointer to a pointer of Presence Info. If the returned result is success, this will be set to data that must be later released, otherwise this will be set to NULL
	 *
	 * @see EOS_Presence_Info#release()
	 */
	public EOS_Presence_Info copyPresence(EOS_Presence_CopyPresenceOptions options) throws EOSException {
		final EOS_Presence_Info.ByReference outPresence = new EOS_Presence_Info.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Presence_CopyPresence(this, options, outPresence);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outPresence;
	}

	/**
	 * Creates a presence modification handle. This handle can used to add multiple changes to your presence that can be applied with EOS_Presence_SetPresence.
	 * The resulting handle must be released by calling EOS_PresenceModification_Release once it has been passed to EOS_Presence_SetPresence.
	 *
	 * @param options Object containing properties related to the user modifying their presence
	 * @param outPresenceModificationHandle Pointer to a Presence Modification Handle to be set if successful
	 * @return {@link EOS_EResult#EOS_Success} if we successfully created the Presence Modification Handle pointed at in OutPresenceModificationHandle, or an error result if the input data was invalid
	 *
	 * @see EOS_PresenceModification#release()
	 * @see #setPresence(EOS_Presence_SetPresenceOptions, Pointer, EOS_Presence_SetPresenceCompleteCallback)
	 * @see EOS_PresenceModification#setStatus(EOS_PresenceModification_SetStatusOptions)
	 * @see EOS_PresenceModification#setRawRichText(EOS_PresenceModification_SetRawRichTextOptions)
	 * @see EOS_PresenceModification#setData(EOS_PresenceModification_SetDataOptions)
	 * @see EOS_PresenceModification#deleteData(EOS_PresenceModification_DeleteDataOptions)
	 */
	public EOS_EResult createPresenceModification(EOS_Presence_CreatePresenceModificationOptions options, EOS_PresenceModification outPresenceModificationHandle) {
		return EOSLibrary.instance.EOS_Presence_CreatePresenceModification(this, options, outPresenceModificationHandle);
	}

	/**
	 * Sets your new presence with the data applied to a PresenceModificationHandle. The PresenceModificationHandle can be released safely after calling this function.
	 *
	 * @param options Object containing a PresenceModificationHandle and associated user data
	 * @param clientData Optional pointer to help track this request, that is returned in the completion callback
	 * @param completionDelegate Pointer to a function that handles receiving the completion information
	 *
	 * @see #createPresenceModification(EOS_Presence_CreatePresenceModificationOptions, EOS_PresenceModification)
	 * @see EOS_PresenceModification#release()
	 */
	public void setPresence(EOS_Presence_SetPresenceOptions options, Pointer clientData, EOS_Presence_SetPresenceCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Presence_SetPresence(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when presence changes. If the returned NotificationId is valid, you must call RemoveNotifyOnPresenceChanged when you no longer wish to
	 * have your NotificationHandler called
	 *
	 * @param clientData Data the is returned to when NotificationHandler is invoked
	 * @param notificationHandler The callback to be fired when a presence change occurs
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyOnPresenceChanged(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyOnPresenceChanged(EOS_Presence_AddNotifyOnPresenceChangedOptions options,
	                                                     Pointer clientData,
	                                                     EOS_Presence_OnPresenceChangedCallback notificationHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Presence_AddNotifyOnPresenceChanged(this, options, clientData, notificationHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationHandler);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving presence update notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyOnPresenceChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_Presence_RemoveNotifyOnPresenceChanged(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Register to receive notifications when a user accepts a join game option via the social overlay.<br>
	 * <b>Must call {@link #removeNotifyJoinGameAccepted(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyJoinGameAccepted(EOS_Presence_AddNotifyJoinGameAcceptedOptions options,
	                                                    Pointer clientData,
	                                                    EOS_Presence_OnJoinGameAcceptedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Presence_AddNotifyJoinGameAccepted(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving notifications when a user accepts a join game option via the social overlay.
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyJoinGameAccepted(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Presence_RemoveNotifyJoinGameAccepted(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}

	/**
	 * Gets a join info custom game-data string for a specific user. This is a helper function for reading the presence data related to how a user can be joined.
	 * Its meaning is entirely application dependent.
	 * <p>
	 * This value will be valid only after a QueryPresence call has successfully completed.
	 *
	 * @param options Object containing an associated user
	 * @return join info custom game-data string for a specific user
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if there is user or the location string was not found
	 * @throws EOSLimitExceededException The OutBuffer is not large enough to receive the location string. InOutBufferLength contains the required minimum length to perform the operation successfully
	 *
	 * @see EOS_PresenceModification#EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH
	 */
	public String getJoinInfo(EOS_Presence_GetJoinInfoOptions options) throws EOSException {
		final IntByReference inOutBufferLength = new IntByReference(EOS_PresenceModification.EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH);
		final byte[] outBuffer = new byte[EOS_PresenceModification.EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH];
		final EOS_EResult result = EOSLibrary.instance.EOS_Presence_GetJoinInfo(this, options, outBuffer, inOutBufferLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outBuffer, 0, inOutBufferLength.getValue());
	}
}