package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtcdata.callbackresults.EOS_RTCData_ParticipantUpdatedCallbackInfo;
import host.anzo.eossdk.eos.sdk.rtcdata.callbacks.EOS_RTCData_OnDataReceivedCallback;
import host.anzo.eossdk.eos.sdk.rtcdata.callbacks.EOS_RTCData_OnParticipantUpdatedCallback;
import host.anzo.eossdk.eos.sdk.rtcdata.callbacks.EOS_RTCData_OnUpdateReceivingCallback;
import host.anzo.eossdk.eos.sdk.rtcdata.callbacks.EOS_RTCData_OnUpdateSendingCallback;
import host.anzo.eossdk.eos.sdk.rtcdata.enums.EOS_ERTCDataStatus;
import host.anzo.eossdk.eos.sdk.rtcdata.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The RTC Data Interface. This is used to manage Data specific RTC features
 *
 * @author Anton Lasevich
 * @since 3/24/2024
 */
public class EOS_RTC_Data_Interface extends PointerType {
	public EOS_RTC_Data_Interface(Pointer address) {
		super(address);
	}

	public EOS_RTC_Data_Interface() {
		super();
	}

	/**
	 * Register to receive notifications with remote data packet received.
	 * If the returned NotificationId is valid, you must call EOS_RTCData_RemoveNotifyDataReceived when you no longer wish to
	 * have your CompletionDelegate called.
	 * <p>
	 * <b>The CompletionDelegate may be called from a thread other than the one from which the SDK is ticking.</b>
	 *
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when a data packet is received
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyDataReceived(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyDataReceived(EOS_RTCData_AddNotifyDataReceivedOptions options, Pointer clientData, EOS_RTCData_OnDataReceivedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCData_AddNotifyDataReceived(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving remote data packets.
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyDataReceived(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCData_RemoveNotifyDataReceived(this, notificationId);
	}

	/**
	 * Use this function to send a data packet to the rest of participants.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @return {@link EOS_EResult#EOS_Success} the data packet was queued for sending<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the options are invalid<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the specified room was not found
	 */
	public EOS_EResult sendData(EOS_RTCData_SendDataOptions options) {
		return EOSLibrary.instance.EOS_RTCData_SendData(this, options);
	}

	/**
	 * Use this function to tweak outgoing data options for a room.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateSending(EOS_RTCData_UpdateSendingOptions options, Pointer clientData, EOS_RTCData_OnUpdateSendingCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCData_UpdateSending(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to tweak incoming data options for a room.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateReceiving(EOS_RTCData_UpdateReceivingOptions options, Pointer clientData, EOS_RTCData_OnUpdateReceivingCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCData_UpdateReceiving(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when a room participant data status is updated (f.e when connection state changes).
	 * <p>
	 * The notification is raised when the participant's data status is updated. In order not to miss any participant status changes, applications need to add the notification before joining a room.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCData_RemoveNotifyParticipantUpdated when you no longer wish
	 * to have your CompletionDelegate called.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when a participant changes data status
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyParticipantUpdated(EOS_NotificationId)
	 * @see EOS_RTCData_ParticipantUpdatedCallbackInfo
	 * @see EOS_ERTCDataStatus
	 */
	public EOS_NotificationId addNotifyParticipantUpdated(EOS_RTCData_AddNotifyParticipantUpdatedOptions options,
	                                                           Pointer clientData,
	                                                           EOS_RTCData_OnParticipantUpdatedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCData_AddNotifyParticipantUpdated(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving participant updated notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyParticipantUpdated(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCData_RemoveNotifyParticipantUpdated(this, notificationId);
	}
}