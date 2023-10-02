package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.integratedplatform.EOS_IntegratedPlatformOptionsContainer;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbacks.EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.integratedplatform.callbacks.EOS_IntegratedPlatform_OnUserPreLogoutCallback;
import host.anzo.eossdk.eos.sdk.integratedplatform.options.*;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * To add integrated platforms, you must call EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer to create an integrated platform options container. To modify that handle, call
 * EOS_IntegratedPlatformOptionsContainer_* methods. Once you are finished, call EOS_Platform_Create with your handle. You must then release your integrated platform options container
 * handle by calling EOS_IntegratedPlatformOptionsContainer_Release.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_IntegratedPlatform_Interface extends PointerType {
	public EOS_IntegratedPlatform_Interface(Pointer address) {
		super(address);
	}
	public EOS_IntegratedPlatform_Interface() {
		super();
	}

	/**
	 * Creates an integrated platform options container handle. This handle can used to add multiple options to your container which will then be applied with EOS_Platform_Create.
	 * The resulting handle must be released by calling EOS_IntegratedPlatformOptionsContainer_Release once it has been passed to EOS_Platform_Create.
	 *
	 * @param options structure containing operation input parameters.
	 * @param outIntegratedPlatformOptionsContainerHandle Pointer to an integrated platform options container handle to be set if successful.
	 * @return Success if we successfully created the integrated platform options container handle pointed at in OutIntegratedPlatformOptionsContainerHandle, or an error result if the input data was invalid.
	 *
	 * @see EOS_IntegratedPlatformOptionsContainer#release()
	 * @see EOS#EOS_Platform_Create(EOS_Platform_Options)
	 * @see EOS_IntegratedPlatformOptionsContainer#add(EOS_IntegratedPlatformOptionsContainer_AddOptions)
	 */
	public EOS_EResult createIntegratedPlatformOptionsContainer(EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions options,
	                                                            EOS_IntegratedPlatformOptionsContainer outIntegratedPlatformOptionsContainerHandle) {
		return EOSLibrary.instance.EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer(options, outIntegratedPlatformOptionsContainerHandle);
	}

	/**
	 * Sets the current login status of a specific local platform user to a new value.
	 * <p>
	 * This function may only be used with an Integrated Platform initialized with the EOS_IPMF_ApplicationManagedIdentityLogin flag, otherwise
	 * calls will return EOS_InvalidState and a platform user's login status will be controlled by OS events.
	 * <p>
	 * If the login status of a user changes, a Integrated Platform User Login Status Changed notification will fire, and depending on the state
	 * of the user's login and the platform, the EOS SDK might start fetching data for the user, it may clear cached data, or it may do nothing.
	 * <p>
	 * If the login status of a user is not different from a previous call to this function, the function will do nothing and return EOS_Success.
	 * This will not trigger a call to the Integrated Platform User Login Status Changed.
	 *
	 * @param options options
	 * @return {@link EOS_EResult#EOS_Success} if the call was successful<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} if the Integrated Platform was not initialized on platform creation<br>
	 *         {@link EOS_EResult#EOS_InvalidState} if the Integrated Platform was not initialized with the EOS_IPMF_ApplicationManagedIdentityLogin flag<br>
	 *         {@link EOS_EResult#EOS_InvalidUser} if the LocalPlatformUserId is not a valid user id for the provided Integrated Platform<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any other input was invalid
	 */
	public EOS_EResult setUserLoginStatus(EOS_IntegratedPlatform_SetUserLoginStatusOptions options) {
		return EOSLibrary.instance.EOS_IntegratedPlatform_SetUserLoginStatus(this, options);
	}

	/**
	 * Register to receive notifications when the login state of Integrated Platform users change.
	 * <p>
	 * This notification will trigger any time the EOS SDK's internal login state changes for a user, including for manual login state
	 * changes (when the EOS_IPMF_ApplicationManagedIdentityLogin flag is set), or automatically detected ones (when not disabled by the
	 * EOS_IPMF_ApplicationManagedIdentityLogin flag).
	 *
	 * @param options Data associated with what version of the notification to receive.
	 * @param clientData A context pointer that is returned in the callback function.
	 * @param callbackFunction The function that is called when Integrated Platform user logins happen
	 * @return A valid notification that can be used to unregister for notifications, or EOS_INVALID_NOTIFICATIONID if input was invalid.
	 *
	 * @see #removeNotifyUserLoginStatusChanged(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyUserLoginStatusChanged(EOS_IntegratedPlatform_AddNotifyUserLoginStatusChangedOptions options,
	                                                                                 Pointer clientData,
	                                                                                 EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback callbackFunction) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_IntegratedPlatform_AddNotifyUserLoginStatusChanged(this, options, clientData, callbackFunction);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, callbackFunction);
		}
		return notificationId;
	}

	/**
	 * Unregister from Integrated Platform user login and logout notifications.
	 *
	 * @param notificationId The NotificationId that was returned from registering for Integrated Platform user login and logout notifications.
	 *
	 * @see #addNotifyUserLoginStatusChanged(EOS_IntegratedPlatform_AddNotifyUserLoginStatusChangedOptions, Pointer, EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback)
	 */
	public void removeNotifyUserLoginStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_IntegratedPlatform_RemoveNotifyUserLoginStatusChanged(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Sets the integrated platform user logout handler for all integrated platforms.
	 * <p>
	 * There can only be one handler set at once, attempting to set a handler when one is already set will result in a EOS_AlreadyConfigured error.
	 * <p>
	 * This callback handler allows applications to decide if a user is logged-out immediately when the SDK receives a system user logout event,
	 * or if the application would like to give the user a chance to correct themselves and log back in if they are in a state that might be
	 * disruptive if an accidental logout happens (unsaved user data, in a multiplayer match, etc). This is not supported on all integrated
	 * platforms, such as those where applications automatically close when a user logs out, or those where a user is always logged-in.
	 * <p>
	 * If a logout is deferred, applications are expected to eventually call EOS_IntegratedPlatform_FinalizeDeferredUserLogout when they
	 * have decided a user meant to logout, or if they have logged in again.
	 *
	 * @param options Data that specifies the API version.
	 * @param clientData An optional context pointer that is returned in the callback data.
	 * @param callbackFunction The function that will handle the callback.
	 * @return {@link EOS_EResult#EOS_Success} if the platform user logout handler was bound successfully.<br>
	 *		   {@link EOS_EResult#EOS_AlreadyConfigured} if there is already a platform user logout handler bound.
	 *
	 * @see #clearUserPreLogoutCallback(EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions)
	 * @see #finalizeDeferredUserLogout(EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions)
	 */
	public EOS_EResult setUserPreLogoutCallback(EOS_IntegratedPlatform_SetUserPreLogoutCallbackOptions options,
	                                                                   Pointer clientData,
	                                                                   EOS_IntegratedPlatform_OnUserPreLogoutCallback callbackFunction) {
		return EOSLibrary.instance.EOS_IntegratedPlatform_SetUserPreLogoutCallback(this, options, clientData, callbackFunction);
	}

	/**
	 * Clears a previously set integrated platform user logout handler for the specified integrated platform. If none is set for the specified platform, this does nothing.
	 * <p>
	 * If there are any pending deferred user-logouts when a handler is cleared, those users will internally be logged-out and cached data about those users cleared before this function returns.
	 * Any applicable callbacks about those users being logged-out will occur in a future call to EOS_Platform_Tick().
	 *
	 * @param options Data for which integrated platform to no longer call a previously-registered callback for.
	 *
	 * @see #setUserPreLogoutCallback(EOS_IntegratedPlatform_SetUserPreLogoutCallbackOptions, Pointer, EOS_IntegratedPlatform_OnUserPreLogoutCallback)
	 */
	public void clearUserPreLogoutCallback(EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions options) {
		EOSLibrary.instance.EOS_IntegratedPlatform_ClearUserPreLogoutCallback(this, options);
	}

	/**
	 * Complete a Logout/Login for a previously deferred Integrated Platform User Logout.
	 * <p>
	 * This function allows applications to control whether an integrated-platform user actually logs out when an integrated platform's system tells the SDK a user has been logged-out.
	 * This allows applications to prevent accidental logouts from destroying application user state. If a user did not mean to logout, the application should prompt and confirm whether
	 * the user meant to logout, and either wait for them to confirm they meant to, or wait for them to login again, before calling this function.
	 * <p>
	 * If the sign-out is intended and your application believes the user is still logged-out, the UserExpectedLoginState in Options should be EOS_LS_NotLoggedIn.
	 * If the sign-out was NOT intended and your application believes the user has logged-in again, the UserExpectedLoginState in Options should be EOS_LS_LoggedIn.
	 *
	 * @param options Data for which integrated platform and user is now in the expected logged-in/logged-out state.
	 * @return {@link EOS_EResult#EOS_Success} if the platform user state matches the UserExpectedLoginState internally.<br>
	 *         {@link EOS_EResult#EOS_NotConfigured} if the Integrated Platform was not initialized on platform creation<br>
	 *         {@link EOS_EResult#EOS_InvalidUser} if the LocalPlatformUserId is not a valid user id for the provided Integrated Platform, or if there is no deferred logout waiting to be completed for this specified user<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if any other input was invalid
	 *
	 * @see #setUserPreLogoutCallback(EOS_IntegratedPlatform_SetUserPreLogoutCallbackOptions, Pointer, EOS_IntegratedPlatform_OnUserPreLogoutCallback)
	 * @see #clearUserPreLogoutCallback(EOS_IntegratedPlatform_ClearUserPreLogoutCallbackOptions)
	 * @see #addNotifyUserLoginStatusChanged(EOS_IntegratedPlatform_AddNotifyUserLoginStatusChangedOptions, Pointer, EOS_IntegratedPlatform_OnUserLoginStatusChangedCallback)
	 */
	public EOS_EResult finalizeDeferredUserLogout(EOS_IntegratedPlatform_FinalizeDeferredUserLogoutOptions options) {
		return EOSLibrary.instance.EOS_IntegratedPlatform_FinalizeDeferredUserLogout(this, options);
	}
}