package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.presence.callbackresults.EOS_Presence_JoinGameAcceptedCallbackInfo;
import host.anzo.eossdk.eos.sdk.ui.callbacks.*;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EInputStateButtonFlags;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_EKeyCombination;
import host.anzo.eossdk.eos.sdk.ui.enums.EOS_UI_ENotificationLocation;
import host.anzo.eossdk.eos.sdk.ui.options.*;

/**
 * The UI Interface is used to access the Social Overlay UI.  Each UI component will have a function for
 * opening it.  All UI Interface calls take a handle of type EOS_HUI as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetUIInterface function.
 *
 * @see EOS_Platform_Interface#getUIInterface()
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public class EOS_UI_Interface extends PointerType {
	public EOS_UI_Interface(Pointer address) {
		super(address);
	}

	public EOS_UI_Interface() {
		super();
	}

	/**
	 * Opens the Social Overlay with a request to show the friends list.
	 *
	 * @param options Structure containing the Epic Account ID of the friends list to show.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate A callback that is fired when the request to show the friends list has been sent to the Social Overlay, or on an error.
	 */
	public void showFriends(EOS_UI_ShowFriendsOptions options, Pointer clientData, EOS_UI_OnShowFriendsCallback completionDelegate) {
		EOSLibrary.instance.EOS_UI_ShowFriends(this, options, clientData, completionDelegate);
	}

	/**
	 * Hides the active Social Overlay.
	 *
	 * @param options Structure containing the Epic Account ID of the browser to close.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate A callback that is fired when the request to hide the friends list has been processed, or on an error.
	 */
	public void hideFriends(EOS_UI_HideFriendsOptions options, Pointer clientData, EOS_UI_OnHideFriendsCallback completionDelegate) {
		EOSLibrary.instance.EOS_UI_HideFriends(this, options, clientData, completionDelegate);
	}

	/**
	 * Gets the friends overlay visibility.
	 *
	 * @param options Structure containing the Epic Account ID of the friends Social Overlay owner.
	 *
	 * @return {@code true} If the overlay is visible.
	 */
	public boolean getFriendsVisible(EOS_UI_GetFriendsVisibleOptions options) {
		return EOSLibrary.instance.EOS_UI_GetFriendsVisible(this, options) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Gets the friends overlay exclusive input state.
	 *
	 * @param options Structure containing the Epic Account ID of the friends Social Overlay owner.
	 *
	 * @return {@code true} If the overlay has exclusive input.
	 */
	public boolean getFriendsExclusiveInput(EOS_UI_GetFriendsExclusiveInputOptions options) {
		return EOSLibrary.instance.EOS_UI_GetFriendsExclusiveInput(this, options) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Register to receive notifications when the overlay display settings are updated.
	 * Newly registered handlers will always be called the next tick with the current state.<br>
	 * <b>Must call {@link #removeNotifyDisplaySettingsUpdated(EOS_NotificationId)} to remove the notification.</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the notificationFn.
	 * @param completionDelegate A callback that is fired when the overlay display settings are updated.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyDisplaySettingsUpdated(EOS_UI_AddNotifyDisplaySettingsUpdatedOptions options,
	                                                                 Pointer clientData,
	                                                                 EOS_UI_OnDisplaySettingsUpdatedCallback completionDelegate) {
		return EOSLibrary.instance.EOS_UI_AddNotifyDisplaySettingsUpdated(this, options, clientData, completionDelegate);
	}

	/**
	 * Unregister from receiving notifications when the overlay display settings are updated.
	 *
	 * @param id Handle representing the registered callback
	 */
	public void removeNotifyDisplaySettingsUpdated(EOS_NotificationId id) {
		EOSLibrary.instance.EOS_UI_RemoveNotifyDisplaySettingsUpdated(this, id);
	}

	/**
	 * Updates the current Toggle Friends Key. This key can be used by the user to toggle the friends
	 * overlay when available. The default value represents `Shift + F3` as `((int32_t)EOS_UIK_Shift | (int32_t)EOS_UIK_F3)`.
	 * The provided key should satisfy EOS_UI_IsValidKeyCombination. The value EOS_UIK_None is specially handled
	 * by resetting the key binding to the system default.
	 *
	 * @param options Structure containing the key combination to use.
	 *
	 * @return {@link EOS_EResult#EOS_Success} If the overlay has been notified about the request.<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} If the overlay is not properly configured.<br>
	 *         {@link EOS_EResult#EOS_NoChange} If the key combination did not change.
	 *
	 * @see #isValidKeyCombination(EOS_UI_EKeyCombination)
	 */
	public EOS_EResult setToggleFriendsKey(EOS_UI_SetToggleFriendsKeyOptions options) {
		return EOSLibrary.instance.EOS_UI_SetToggleFriendsKey(this, options);
	}

	/**
	 * Returns the current Toggle Friends Key. This key can be used by the user to toggle the friends
	 * overlay when available. The default value represents `Shift + F3` as `((int32_t)EOS_UIK_Shift | (int32_t)EOS_UIK_F3)`.
	 *
	 * @param options Structure containing any options that are needed to retrieve the key.
	 * @return A valid key combination which represent a single key with zero or more modifier keys.
	 *         EOS_UIK_None will be returned if any error occurs.
	 * @see EOS_UI_EKeyCombination
	 */
	public EOS_UI_EKeyCombination getToggleFriendsKey(EOS_UI_GetToggleFriendsKeyOptions options) {
		return EOSLibrary.instance.EOS_UI_GetToggleFriendsKey(this, options);
	}

	/**
	 * Determine if a key combination is valid. A key combinations must have a single key and at least one modifier.
	 * The single key must be one of the following: F1 through F12, Space, Backspace, Escape, or Tab.
	 * The modifier key must be one or more of the following: Shift, Control, or Alt.
	 *
	 * @param keyCombination The key to test.
	 * @return {@code true} if the provided key combination is valid.
	 */
	public boolean isValidKeyCombination(EOS_UI_EKeyCombination keyCombination) {
		return EOSLibrary.instance.EOS_UI_IsValidKeyCombination(this, keyCombination) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Updates the current Toggle Friends Button. This button can be used by the user to toggle the friends
	 * overlay when available.
	 * <p>
	 * The default value is EOS_UISBF_None.
	 * The provided button must satisfy EOS_UI_IsValidButtonCombination.
	 * <p>
	 * On PC the EOS Overlay automatically listens to gamepad input and routes it to the overlay when appropriate. If this button is configured, the user may open the overlay using either this button or the toggle friends key.
	 * On console platforms, the game must be calling EOS_UI_ReportInputState to route gamepad input to the EOS Overlay.
	 *
	 * @param options Structure containing the button combination to use.
	 *
	 * @return {@link EOS_EResult#EOS_Success} If the overlay has been notified about the request.<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} If the overlay is not properly configured.<br>
	 *         {@link EOS_EResult#EOS_NoChange} If the button combination did not change.
	 *
	 * @see #isValidKeyCombination(EOS_UI_EKeyCombination)
	 * @see #reportInputState(EOS_UI_ReportInputStateOptions)
	 */
	public EOS_EResult setToggleFriendsButton(EOS_UI_SetToggleFriendsButtonOptions options) {
		return EOSLibrary.instance.EOS_UI_SetToggleFriendsButton(this, options);
	}

	/**
	 * Returns the current Toggle Friends Button.  This button can be used by the user to toggle the friends
	 * overlay when available. The default value is EOS_UISBF_None.
	 *
	 * @param options Structure containing any options that are needed to retrieve the button.
	 * @return A valid button combination which represents any number of buttons.
	 *         {@link EOS_UI_EInputStateButtonFlags#EOS_UISBF_None} will be returned if any error occurs.
	 */
	public EOS_UI_EInputStateButtonFlags getToggleFriendsButton(EOS_UI_GetToggleFriendsButtonOptions options) {
		return EOSLibrary.instance.EOS_UI_GetToggleFriendsButton(this, options);
	}

	/**
	 * Determine if a button combination is valid.
	 *
	 * @param buttonCombination The button to test.
	 * @return {@code true} if the provided button combination is valid.
	 * @see EOS_UI_EInputStateButtonFlags
	 */
	public boolean isValidButtonCombination(EOS_UI_EInputStateButtonFlags buttonCombination) {
		return EOSLibrary.instance.EOS_UI_IsValidButtonCombination(this, buttonCombination) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Define any preferences for any display settings.
	 *
	 * @param options Structure containing any options that are needed to set
	 * @return {@link EOS_EResult#EOS_Success} If the overlay has been notified about the request.<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} If the overlay is not properly configured.<br>
	 *         {@link EOS_EResult#EOS_NoChange} If the preferences did not change.
	 */
	public EOS_EResult setDisplayPreference(EOS_UI_SetDisplayPreferenceOptions options) {
		return EOSLibrary.instance.EOS_UI_SetDisplayPreference(this, options);
	}

	/**
	 * Returns the current notification location display preference.
	 * @return The current notification location display preference.
	 */
	public EOS_UI_ENotificationLocation getNotificationLocationPreference() {
		return EOSLibrary.instance.EOS_UI_GetNotificationLocationPreference(this);
	}

	/**
	 * Lets the SDK know that the given UI event ID has been acknowledged and should be released.
	 *
	 * @return {@link EOS_EResult#EOS_Success} is returned if the UI event ID has been acknowledged.<br>
	 *         {@link EOS_EResult#EOS_NotFound} is returned if the UI event ID does not exist.
	 *
	 * @see EOS_Presence_JoinGameAcceptedCallbackInfo
	 */
	public EOS_EResult acknowledgeEventId(EOS_UI_AcknowledgeEventIdOptions options) {
		return EOSLibrary.instance.EOS_UI_AcknowledgeEventId(this, options);
	}

	/**
	 * Pushes platform agnostic input state to the SDK. The state is passed to the EOS Overlay on console platforms.
	 * This function has an empty implementation (i.e. returns EOS_NotImplemented) on all non-consoles platforms.
	 *
	 * @param options Structure containing the input state
	 *
	 * @return {@link EOS_EResult#EOS_Success} If the Social Overlay has been notified about the request.<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} If the Social Overlay is not properly configured.<br>
	 *         {@link EOS_EResult#EOS_NotImplemented}x If the application is suspended.<br>
	 *         {@link EOS_EResult#EOS_NotImplemented} If this function is not implemented on the current platform.
	 */
	public EOS_EResult reportInputState(EOS_UI_ReportInputStateOptions options) {
		return EOSLibrary.instance.EOS_UI_ReportInputState(this, options);
	}

	/**
	 * Gives the Overlay the chance to issue its own drawing commands on console platforms.
	 * Issued by the hosting application after it has finished the backbuffer and is ready to trigger presenting it.
	 * As this process can be involved and rather varied depending on platform we do not plan to make the call
	 * replace the standard "present" call, but rather expect it to be issued "just before" that call.
	 * This function has an empty implementation (i.e. returns EOS_NotImplemented) on all non-consoles platforms.
	 * @param options will vary from platform to platform.
	 *        Main difference will be due to a platforms ability to provide multiple rendering queues.
	 *
	 * @return An EOS_EResult is returned to indicate success or an error.
	 */
	public EOS_EResult prePresent(EOS_UI_PrePresentOptions options) {
		return EOSLibrary.instance.EOS_UI_PrePresent(this, options);
	}

	/**
	 * Requests that the Social Overlay open and display the "Block User" flow for the specified user.
	 *
	 * @param clientData Arbitrary data that is passed back to you in the notificationFn.
	 * @param completionDelegate A callback that is fired when the user exits the Block UI.
	 */
	public void showBlockPlayer(EOS_UI_ShowBlockPlayerOptions options, Pointer clientData, EOS_UI_OnShowBlockPlayerCallback completionDelegate) {
		EOSLibrary.instance.EOS_UI_ShowBlockPlayer(this, options, clientData, completionDelegate);
	}

	/**
	 * Requests that the Social Overlay open and display the "Report User" flow for the specified user.
	 *
	 * @param clientData Arbitrary data that is passed back to you in the notificationFn.
	 * @param completionDelegate A callback that is fired when the user exits the Report UI.
	 */
	public void showReportPlayer(EOS_UI_ShowReportPlayerOptions options, Pointer clientData, EOS_UI_OnShowReportPlayerCallback completionDelegate) {
		EOSLibrary.instance.EOS_UI_ShowReportPlayer(this, options, clientData, completionDelegate);
	}

	/**
	 * Sets the bIsPaused state of the overlay.
	 * While true then all notifications will be delayed until after the bIsPaused is false again.
	 * While true then the key and button events will not toggle the overlay.
	 * If the Overlay was visible before being paused then it will be hidden.
	 * If it is known that the Overlay should now be visible after being paused then it will be shown.
	 *
	 * @return {@link EOS_EResult#EOS_Success} If the overlay has been notified about the request.<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} If the overlay is not properly configured.
	 */
	public EOS_EResult pauseSocialOverlay(EOS_UI_PauseSocialOverlayOptions options) {
		return EOSLibrary.instance.EOS_UI_PauseSocialOverlay(this, options);
	}

	/**
	 * Gets the bIsPaused state of the overlay as set by any previous calls to EOS_UI_PauseSocialOverlay().
	 *
	 * @return {@code true} If the overlay is paused.
	 *
	 * @see #pauseSocialOverlay(EOS_UI_PauseSocialOverlayOptions)
	 */
	public boolean isSocialOverlayPaused(EOS_UI_IsSocialOverlayPausedOptions options) {
		return EOSLibrary.instance.EOS_UI_IsSocialOverlayPaused(this, options) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Register to receive notifications from the memory monitor.
	 * Newly registered handlers will always be called the next tick with the current state.<br>
	 * <b>Must call {@link #removeNotifyMemoryMonitor(EOS_NotificationId)} to remove the notification.</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the notificationFn.
	 * @param completionDelegate A callback that is fired when the overlay display settings are updated.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyMemoryMonitor(EOS_UI_AddNotifyMemoryMonitorOptions options, Pointer clientData, EOS_UI_OnMemoryMonitorCallback completionDelegate) {
		return EOSLibrary.instance.EOS_UI_AddNotifyMemoryMonitor(this, options, clientData, completionDelegate);
	}

	/**
	 * Unregister from receiving notifications when the memory monitor posts a notification.
	 *
	 * @param id Handle representing the registered callback
	 */
	public void removeNotifyMemoryMonitor(EOS_NotificationId id) {
		EOSLibrary.instance.EOS_UI_RemoveNotifyMemoryMonitor(this, id);
	}

	/**
	 * Requests that the native ID for a target player be identified and the native profile be displayed for that player.
	 *
	 * @param clientData Arbitrary data that is passed back to you in the notificationFn.
	 * @param completionDelegate A callback that is fired when the profile has been shown.
	 */
	public void showNativeProfile(EOS_UI_ShowNativeProfileOptions options, Pointer clientData, EOS_UI_OnShowNativeProfileCallback completionDelegate) {
		EOSLibrary.instance.EOS_UI_ShowNativeProfile(this, options, clientData, completionDelegate);
	}
}