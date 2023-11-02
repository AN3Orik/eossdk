package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtc.callbacks.*;
import host.anzo.eossdk.eos.sdk.rtc.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The RTC Interface is used to manage joining and leaving rooms.
 * @see EOS_Platform_Interface#getRTCInterface()
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public class EOS_RTC_Interface extends PointerType {
	public EOS_RTC_Interface(Pointer address) {
		super(address);
	}

	public EOS_RTC_Interface() {
		super();
	}

	/**
	 * Get a handle to the Audio interface
	 * @return EOS_RTC_InterfaceAudio handle
	 */
	public EOS_RTC_Audio_Interface getAudioInterface() {
		return EOSLibrary.instance.EOS_RTC_GetAudioInterface(this);
	}

	/**
	 * Use this function to join a room.
	 * <p>
	 * This function does not need to called for the Lobby RTC Room system; doing so will return EOS_AccessDenied. The lobby system will
	 * automatically join and leave RTC Rooms for all lobbies that have RTC rooms enabled.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void joinRoom(EOS_RTC_JoinRoomOptions options, Pointer clientData, EOS_RTC_OnJoinRoomCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTC_JoinRoom(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to leave a room and clean up all the resources associated with it. This function has to always be called when the
	 * room is abandoned even if the user is already disconnected for other reasons.
	 * <p>
	 * This function does not need to called for the Lobby RTC Room system; doing so will return EOS_AccessDenied. The lobby system will
	 * automatically join and leave RTC Rooms for all lobbies that have RTC rooms enabled.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void leaveRoom(EOS_RTC_LeaveRoomOptions options, Pointer clientData, EOS_RTC_OnLeaveRoomCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTC_LeaveRoom(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to block a participant already connected to the room. After blocking them no media will be sent or received between
	 * that user and the local user. This method can be used after receiving the OnParticipantStatusChanged notification.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void blockParticipant(EOS_RTC_BlockParticipantOptions options, Pointer clientData, EOS_RTC_OnBlockParticipantCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTC_BlockParticipant(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when disconnected from the room. If the returned NotificationId is valid, you must call
	 * EOS_RTC_RemoveNotifyDisconnected when you no longer wish to have your CompletionDelegate called.
	 * <p>
	 * This function will always return EOS_INVALID_NOTIFICATIONID when used with lobby RTC room. To be notified of the connection
	 * status of a Lobby-managed RTC room, use the EOS_Lobby_AddNotifyRTCRoomConnectionChanged function instead.
	 *
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when a presence change occurs
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyDisconnected(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyDisconnected(EOS_RTC_AddNotifyDisconnectedOptions options, Pointer clientData, EOS_RTC_OnDisconnectedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTC_AddNotifyDisconnected(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving room disconnection notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyDisconnected(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_RTC_RemoveNotifyDisconnected(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Register to receive notifications when a participant's status changes (e.g: join or leave the room), or when the participant is added or removed
	 * from an applicable block list (e.g: Epic block list and/or current platform's block list).
	 * If the returned NotificationId is valid, you must call EOS_RTC_RemoveNotifyParticipantStatusChanged when you no longer wish to have your CompletionDelegate called.
	 * <p>
	 * If you register to this notification before joining a room, you will receive a notification for every member already in the room when you join said room.
	 * This allows you to know who is already in the room when you join.
	 * <p>
	 * To be used effectively with a Lobby-managed RTC room, this should be registered during the EOS_Lobby_CreateLobby or EOS_Lobby_JoinLobby completion
	 * callbacks when the ResultCode is EOS_Success. If this notification is registered after that point, it is possible to miss notifications for
	 * already-existing room participants.
	 * <p>
	 * You can use this notification to detect internal automatic RTC blocks due to block lists.
	 * When a participant joins a room and while the system resolves the block list status of said participant, the participant is set to blocked and you'll receive
	 * a notification with ParticipantStatus set to EOS_RTCPS_Joined and bParticipantInBlocklist set to true.
	 * Once the block list status is resolved, if the player is not in any applicable block list(s), it is then unblocked and a new notification is sent with
	 * ParticipantStatus set to EOS_RTCPS_Joined and bParticipantInBlocklist set to false.
	 *
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when a presence change occurs
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 * <p>
	 * <b>This notification is also raised when the local user joins the room, but NOT when the local user leaves the room.</b>
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyParticipantStatusChanged(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyParticipantStatusChanged(EOS_RTC_AddNotifyParticipantStatusChangedOptions options, Pointer clientData, EOS_RTC_OnParticipantStatusChangedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTC_AddNotifyParticipantStatusChanged(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving participant status change notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyParticipantStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_RTC_RemoveNotifyParticipantStatusChanged(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Use this function to control settings.
	 * <p>
	 * The available settings are documented as part of EOS_RTC_SetSettingOptions.
	 *
	 * @param options structure containing the parameters for the operation
	 * @return {@link EOS_EResult#EOS_Success} when the setting is successfully set<br>
	 *         {@link EOS_EResult#EOS_NotFound} when the setting is unknown<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} when the value is invalid.
	 */
	public EOS_EResult setSetting(EOS_RTC_SetSettingOptions options) {
		return EOSLibrary.instance.EOS_RTC_SetSetting(this, options);
	}

	/**
	 * Use this function to control settings for the specific room.
	 * <p>
	 * The available settings are documented as part of EOS_RTC_SetRoomSettingOptions.
	 *
	 * @param options structure containing the parameters for the operation
	 * @return {@link EOS_EResult#EOS_Success} when the setting is successfully set<br>
	 *         {@link EOS_EResult#EOS_NotFound} when the setting is unknown<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} when the value is invalid.
	 */
	public EOS_EResult setRoomSetting(EOS_RTC_SetRoomSettingOptions options) {
		return EOSLibrary.instance.EOS_RTC_SetRoomSetting(this, options);
	}

	/**
	 * Register to receive notifications to receiving periodical statistics update. If the returned NotificationId is valid, you must call
	 * EOS_RTC_RemoveNotifyRoomStatisticsUpdated when you no longer wish to have your StatisticsUpdateHandler called.
	 *
	 * @param clientData Arbitrary data that is passed back in the StatisticsUpdateHandler
	 * @param statisticsUpdateHandler The callback to be fired when a statistics updated.
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyRoomStatisticsUpdated(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyRoomStatisticsUpdated(EOS_RTC_AddNotifyRoomStatisticsUpdatedOptions options, Pointer clientData, EOS_RTC_OnRoomStatisticsUpdatedCallback statisticsUpdateHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTC_AddNotifyRoomStatisticsUpdated(this, options, clientData, statisticsUpdateHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, statisticsUpdateHandler);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving periodical statistics update notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyRoomStatisticsUpdated(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_RTC_RemoveNotifyRoomStatisticsUpdated(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}
}