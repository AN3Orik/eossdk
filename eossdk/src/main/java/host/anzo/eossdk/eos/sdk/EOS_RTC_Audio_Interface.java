package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_LocalRTCOptions;
import host.anzo.eossdk.eos.sdk.rtc.options.EOS_RTC_JoinRoomOptions;
import host.anzo.eossdk.eos.sdk.rtcaudio.EOS_RTCAudio_InputDeviceInformation;
import host.anzo.eossdk.eos.sdk.rtcaudio.EOS_RTCAudio_OutputDeviceInformation;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults.EOS_RTCAudio_ParticipantUpdatedCallbackInfo;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbacks.*;
import host.anzo.eossdk.eos.sdk.rtcaudio.enums.EOS_ERTCAudioStatus;
import host.anzo.eossdk.eos.sdk.rtcaudio.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The RTC Audio Interface. This is used to manage Audio specific RTC features
 * @see EOS_RTC_Interface#getAudioInterface()
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public class EOS_RTC_Audio_Interface extends PointerType {
	public EOS_RTC_Audio_Interface(Pointer address) {
		super(address);
	}

	public EOS_RTC_Audio_Interface() {
		super();
	}

	/**
	 * Use this function to push a new audio buffer to be sent to the participants of a room.
	 * <p>
	 * This should only be used if Manual Audio Input was enabled locally for the specified room.
	 *
	 * @param options structure containing the parameters for the operation.
	 * @return {@link EOS_EResult#EOS_Success} if the buffer was successfully queued for sending<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any of the parameters are incorrect<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the specified room was not found<br>
	 *         {@link EOS_EResult#EOS_InvalidState} if manual recording was not enabled when joining the room.
	 * @see EOS_RTC_JoinRoomOptions
	 * @see EOS_Lobby_LocalRTCOptions
	 */
	public EOS_EResult sendAudio(EOS_RTCAudio_SendAudioOptions options) {
		return EOSLibrary.instance.EOS_RTCAudio_SendAudio(this, options);
	}

	/**
	 * Use this function to tweak outgoing audio options for a room.
	 * <p>
	 * <b>Due to internal implementation details, this function requires that you first register to any notification for room</b>
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateSending(EOS_RTCAudio_UpdateSendingOptions options, Pointer clientData, EOS_RTCAudio_OnUpdateSendingCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UpdateSending(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to tweak incoming audio options for a room.
	 * <p>
	 * <b>Due to internal implementation details, this function requires that you first register to any notification for room</b>
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateReceiving(EOS_RTCAudio_UpdateReceivingOptions options, Pointer clientData, EOS_RTCAudio_OnUpdateReceivingCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UpdateReceiving(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to change outgoing audio volume for a room.
	 * <p>
	 * <b>Due to internal implementation details, this function requires that you first register to any notification for room</b>
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateSendingVolume(EOS_RTCAudio_UpdateSendingVolumeOptions options, Pointer clientData, EOS_RTCAudio_OnUpdateSendingVolumeCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UpdateSendingVolume(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to change incoming audio volume for a room.
	 * <p>
	 * <b>Due to internal implementation details, this function requires that you first register to any notification for room</b>
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or on error
	 */
	public void updateReceivingVolume(EOS_RTCAudio_UpdateReceivingVolumeOptions options, Pointer clientData, EOS_RTCAudio_OnUpdateReceivingVolumeCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UpdateReceivingVolume(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to change participant audio volume for a room.
	 * <p>
	 * <b>Due to internal implementation details, this function requires that you first register to any notification for room</b>
	 *
	 * @param options structure containing the parameters for the operation.
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void updateParticipantVolume(EOS_RTCAudio_UpdateParticipantVolumeOptions options, Pointer clientData, EOS_RTCAudio_OnUpdateParticipantVolumeCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UpdateParticipantVolume(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive notifications when a room participant audio status is updated (f.e when mute state changes or speaking flag changes).
	 * <p>
	 * The notification is raised when the participant's audio status is updated. In order not to miss any participant status changes, applications need to add the notification before joining a room.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyParticipantUpdated when you no longer wish
	 * to have your completionDelegate called.
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when a participant changes audio status
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyParticipantUpdated(EOS_NotificationId)
	 * @see EOS_RTCAudio_ParticipantUpdatedCallbackInfo
	 * @see EOS_ERTCAudioStatus
	 */
	public EOS_NotificationId addNotifyParticipantUpdated(EOS_RTCAudio_AddNotifyParticipantUpdatedOptions options,
	                                                      Pointer clientData,
	                                                      EOS_RTCAudio_OnParticipantUpdatedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyParticipantUpdated(this, options, clientData, completionDelegate);
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
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyParticipantUpdated(this, notificationId);
	}

	/**
	 * Register to receive notifications when an audio device is added or removed to the system.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyAudioDevicesChanged when you no longer wish
	 * to have your completionDelegate called.
	 * <p>
	 * The library will try to use user selected audio device while following these rules:
	 * <ul>
	 *     <li>if none of the audio devices has been available and connected before - the library will try to use it;
	 *     <li>if user selected device failed for some reason, default device will be used instead (and user selected device will be memorized);
	 *     <li>if user selected a device but it was not used for some reason (and default was used instead), when devices selection is triggered we will try to use user selected device again;
	 *     <li>triggers to change a device: when new audio device appears or disappears - library will try to use previously user selected;
	 *     <li>if for any reason, a device cannot be used - the library will fallback to using default;
	 *     <li>if a configuration of the current audio device has been changed, it will be restarted.
	 * </ul>
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when an audio device change occurs
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyAudioDevicesChanged(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions options, Pointer clientData, EOS_RTCAudio_OnAudioDevicesChangedCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyAudioDevicesChanged(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving audio devices notifications
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyAudioDevicesChanged(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyAudioDevicesChanged(this, notificationId);
	}

	/**
	 * Register to receive notifications when audio input state changed.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyAudioInputState when you no longer wish to
	 * have your completionDelegate called.
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when audio input state changes
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyAudioInputState(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyAudioInputState(EOS_RTCAudio_AddNotifyAudioInputStateOptions options, Pointer clientData, EOS_RTCAudio_OnAudioInputStateCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyAudioInputState(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving notifications on audio input state changed.
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyAudioInputState(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyAudioInputState(this, notificationId);
	}

	/**
	 * Register to receive notifications when audio output state changed.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyAudioOutputState when you no longer wish to
	 * have your completionDelegate called.
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when audio output state changes
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyAudioOutputState(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyAudioOutputState(EOS_RTCAudio_AddNotifyAudioOutputStateOptions options,
	                                                    Pointer clientData,
	                                                    EOS_RTCAudio_OnAudioOutputStateCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyAudioOutputState(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving notifications on audio output state changed.
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyAudioOutputState(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyAudioOutputState(this, notificationId);
	}

	/**
	 * Register to receive notifications when local audio buffers are about to be encoded and sent.
	 * <p>
	 * This gives you access to the audio data about to be sent, allowing for example the implementation of custom filters/effects.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyAudioBeforeSend when you no longer wish to
	 * have your completionDelegate called.
	 * <p>
	 * <b>The CompletionDelegate may be called from a thread other than the one from which the SDK is ticking.</b>
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when local audio buffers are about to be encoded and sent
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyAudioBeforeSend(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyAudioBeforeSend(EOS_RTCAudio_AddNotifyAudioBeforeSendOptions options,
	                                                   Pointer clientData,
	                                                   EOS_RTCAudio_OnAudioBeforeSendCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyAudioBeforeSend(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving local audio buffers before they are encoded and sent.
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyAudioBeforeSend(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyAudioBeforeSend(this, notificationId);
	}

	/**
	 * Register to receive notifications with remote audio buffers before they are rendered.
	 * <p>
	 * This gives you access to the audio data received, allowing for example the implementation of custom filters/effects.
	 * <p>
	 * If the returned NotificationId is valid, you must call EOS_RTCAudio_RemoveNotifyAudioBeforeRender when you no longer wish to
	 * have your completionDelegate called.
	 * <p>
	 * <b>The CompletionDelegate may be called from a thread other than the one from which the SDK is ticking.</b>
	 *
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when remote audio buffers are about to be rendered
	 * @return Notification ID representing the registered callback if successful, an invalid NotificationId if not
	 *
	 * @see EOS_NotificationId#EOS_INVALID_NOTIFICATIONID
	 * @see #removeNotifyAudioBeforeRender(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyAudioBeforeRender(EOS_RTCAudio_AddNotifyAudioBeforeRenderOptions options,
	                                                     Pointer clientData,
	                                                     EOS_RTCAudio_OnAudioBeforeRenderCallback completionDelegate) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_RTCAudio_AddNotifyAudioBeforeRender(this, options, clientData, completionDelegate);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, completionDelegate);
		}
		return notificationId;
	}

	/**
	 * Unregister a previously bound notification handler from receiving remote audio buffers before they are rendered.
	 *
	 * @param notificationId The Notification ID representing the registered callback
	 */
	public void removeNotifyAudioBeforeRender(EOS_NotificationId notificationId) {
		CallbackUtils.unregisterNotificationCallback(notificationId);
		EOSLibrary.instance.EOS_RTCAudio_RemoveNotifyAudioBeforeRender(this, notificationId);
	}

	/**
	 * Use this function to inform the audio system of a user.
	 * <p>
	 * This function is only necessary for some platforms.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 *
	 * @see #unregisterPlatformUser(EOS_RTCAudio_UnregisterPlatformUserOptions, Pointer, EOS_RTCAudio_OnUnregisterPlatformUserCallback)
	 */
	public void registerPlatformUser(EOS_RTCAudio_RegisterPlatformUserOptions options, Pointer clientData, EOS_RTCAudio_OnRegisterPlatformUserCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_RegisterPlatformUser(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to remove a user that was added with EOS_RTCAudio_RegisterPlatformUser.
	 * <p>
	 * This function is only necessary for some platforms.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void unregisterPlatformUser(EOS_RTCAudio_UnregisterPlatformUserOptions options,
	                                   Pointer clientData,
	                                   EOS_RTCAudio_OnUnregisterPlatformUserCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_UnregisterPlatformUser(this, options, clientData, completionDelegate);
	}

	/**
	 * Query for a list of audio input devices available in the system together with their specifications.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void queryInputDevicesInformation(EOS_RTCAudio_QueryInputDevicesInformationOptions options,
	                                         Pointer clientData,
	                                         EOS_RTCAudio_OnQueryInputDevicesInformationCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_QueryInputDevicesInformation(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of audio input devices available in the system that are cached locally.
	 * <p>
	 * The returned value should not be cached and should instead be used immediately with
	 * the EOS_RTCAudio_CopyInputDeviceInformationByIndex function.
	 *
	 * @param options structure containing the parameters for the operation
	 * @return The number of audio input devices available in the system or 0 if there is an error
	 *
	 * @see #copyInputDeviceInformationByIndex(EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions)
	 * @see #addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public int getInputDevicesCount(EOS_RTCAudio_GetInputDevicesCountOptions options) {
		return EOSLibrary.instance.EOS_RTCAudio_GetInputDevicesCount(this, options);
	}

	/**
	 * Fetches an audio input device's information from then given index that are cached locally.
	 *
	 * @param options structure containing the index being accessed
	 * @return The audio input device's information for the given index, if it exists and is valid, use EOS_RTCAudio_InputDeviceInformation_Release when finished
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the audio input device's information is not found
	 *
	 * @see EOS_RTCAudio_InputDeviceInformation#release()
	 * @see #addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public EOS_RTCAudio_InputDeviceInformation copyInputDeviceInformationByIndex(EOS_RTCAudio_CopyInputDeviceInformationByIndexOptions options) throws EOSException {
		final PointerByReference outResult = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_RTCAudio_CopyInputDeviceInformationByIndex(this, options, outResult);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_RTCAudio_InputDeviceInformation deviceInfo = new EOS_RTCAudio_InputDeviceInformation(outResult.getValue());
		deviceInfo.read();
		return deviceInfo;
	}

	/**
	 * Query for a list of audio output devices available in the system together with their specifications.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void queryOutputDevicesInformation(EOS_RTCAudio_QueryOutputDevicesInformationOptions options,
	                                          Pointer clientData,
	                                          EOS_RTCAudio_OnQueryOutputDevicesInformationCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_QueryOutputDevicesInformation(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of audio output devices available in the system that are cached locally.
	 * <p>
	 * The returned value should not be cached and should instead be used immediately with
	 * the EOS_RTCAudio_CopyOutputDeviceInformationByIndex function.
	 *
	 * @param options structure containing the parameters for the operation
	 * @return The number of audio output devices available in the system or 0 if there is an error
	 *
	 * @see #copyOutputDeviceInformationByIndex(EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions)
	 * @see #addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public int getOutputDevicesCount(EOS_RTCAudio_GetOutputDevicesCountOptions options) {
		return EOSLibrary.instance.EOS_RTCAudio_GetOutputDevicesCount(this, options);
	}

	/**
	 * Fetches an audio output device's information from then given index that are cached locally.
	 *
	 * @param options structure containing the index being accessed
	 * @return The audio output device's information for the given index, if it exists and is valid, use EOS_RTCAudio_OutputDeviceInformation_Release when finished
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the audio output device's information is not found
	 *
	 * @see EOS_RTCAudio_OutputDeviceInformation#release()
	 * @see #addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public EOS_RTCAudio_OutputDeviceInformation copyOutputDeviceInformationByIndex(EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions options) throws EOSException {
		final PointerByReference outResult = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_RTCAudio_CopyOutputDeviceInformationByIndex(this, options, outResult);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_RTCAudio_OutputDeviceInformation deviceInfo = new EOS_RTCAudio_OutputDeviceInformation(outResult.getValue());
		deviceInfo.read();
		return deviceInfo;
	}

	/**
	 * Use this function to set audio input device settings, such as the active input device, or platform AEC.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void setInputDeviceSettings(EOS_RTCAudio_SetInputDeviceSettingsOptions options,
	                                   Pointer clientData,
	                                   EOS_RTCAudio_OnSetInputDeviceSettingsCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_SetInputDeviceSettings(this, options, clientData, completionDelegate);
	}

	/**
	 * Use this function to set audio output device settings, such as the active output device.
	 *
	 * @param options structure containing the parameters for the operation
	 * @param clientData Arbitrary data that is passed back in the completionDelegate
	 * @param completionDelegate The callback to be fired when the operation completes, either successfully or in error
	 */
	public void setOutputDeviceSettings(EOS_RTCAudio_SetOutputDeviceSettingsOptions options,
	                                    Pointer clientData,
	                                    EOS_RTCAudio_OnSetOutputDeviceSettingsCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAudio_SetOutputDeviceSettings(this, options, clientData, completionDelegate);
	}
}