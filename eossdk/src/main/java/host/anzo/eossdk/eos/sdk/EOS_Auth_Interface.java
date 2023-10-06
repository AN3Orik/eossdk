package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.*;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_IdToken;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Token;
import host.anzo.eossdk.eos.sdk.auth.callbacks.*;
import host.anzo.eossdk.eos.sdk.auth.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.utils.CallbackUtils;

/**
 * The Auth Interface is used to manage local user permissions and access to backend services through the verification of various forms of credentials.
 * All Auth Interface calls take a handle of type EOS_HAuth as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetAuthInterface function.
 *
 * @see EOS_Platform_Interface#getAuthInterface()
 *
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public class EOS_Auth_Interface extends PointerType {
	public EOS_Auth_Interface(Pointer address) {
		super(address);
	}
	public EOS_Auth_Interface() {
		super();
	}

	/**
	 * Login/Authenticate with user credentials.
	 *
	 * @param options structure containing the account credentials to use during the login operation
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the login operation completes, either successfully or in error
	 */
	public void login(EOS_Auth_LoginOptions options, Pointer clientData, EOS_Auth_OnLoginCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_Login(this, options, clientData, completionDelegate);
	}

	/**
	 * Signs the player out of the online service.
	 *
	 * @param options structure containing information about which account to log out.
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the logout operation completes, either successfully or in error
	 */
	public void logout(EOS_Auth_LogoutOptions options, Pointer clientData, EOS_Auth_OnLogoutCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_Logout(this, options, clientData, completionDelegate);
	}

	/**
	 * Link external account by continuing previous login attempt with a continuance token.
	 * <p>
	 * The user will be presented with Epic Accounts onboarding flow managed by the SDK.
	 * <p>
	 * On success, the user will be logged in at the completion of this action.
	 * This will commit this external account to the Epic Account and cannot be undone in the SDK.
	 *
	 * @param options structure containing the account credentials to use during the link account operation
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the link account operation completes, either successfully or in error
	 */
	public void linkAccount(EOS_Auth_LinkAccountOptions options, Pointer clientData, EOS_Auth_OnLinkAccountCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_LinkAccount(this, options, clientData, completionDelegate);
	}

	/**
	 * Deletes a previously received and locally stored persistent auth access token for the currently logged in user of the local device.
	 * <p>
	 * On Desktop and Mobile platforms, the access token is deleted from the keychain of the local user and a backend request is made to revoke the token on the authentication server.
	 * On Console platforms, even though the caller is responsible for storing and deleting the access token on the local device,
	 * this function should still be called with the access token before its deletion to make the best effort in attempting to also revoke it on the authentication server.
	 * If the function would fail on Console, the caller should still proceed as normal to delete the access token locally as intended.
	 *
	 * @param options structure containing operation input parameters
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the deletion operation completes, either successfully or in error
	 */
	public void deletePersistentAuth(EOS_Auth_DeletePersistentAuthOptions options,
	                                 Pointer clientData,
	                                 EOS_Auth_OnDeletePersistentAuthCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_DeletePersistentAuth(this, options, clientData, completionDelegate);
	}

	/**
	 * Contact the backend service to verify validity of an existing user auth token.
	 * This function is intended for server-side use only.
	 *
	 * @param options structure containing information about the auth token being verified
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the logout operation completes, either successfully or in error
	 *
	 * @see EOS_Auth_Interface#copyUserAuthToken(EOS_Auth_CopyUserAuthTokenOptions, EOS_EpicAccountId)
	 */
	public void verifyUserAuth(EOS_Auth_VerifyUserAuthOptions options, Pointer clientData, EOS_Auth_OnVerifyUserAuthCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_VerifyUserAuth(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of accounts that are logged in.
	 *
	 * @return the number of accounts logged in.
	 */
	public int getLoggedInAccountsCount() {
		return EOSLibrary.instance.EOS_Auth_GetLoggedInAccountsCount(this);
	}

	/**
	 * Fetch an Epic Account ID that is logged in.
	 *
	 * @param index An index into the list of logged in accounts. If the index is out of bounds, the returned Epic Account ID will be invalid.
	 *
	 * @return The Epic Account ID associated with the index passed
	 */
	public EOS_EpicAccountId getLoggedInAccountByIndex(int index) {
		return EOSLibrary.instance.EOS_Auth_GetLoggedInAccountByIndex(this, index);
	}

	/**
	 * Fetches the login status for an Epic Account ID.
	 *
	 * @param localUserId The Epic Account ID of the user being queried
	 *
	 * @return The enum value of a user's login status
	 */
	public EOS_ELoginStatus getLoginStatus(EOS_EpicAccountId localUserId) {
		return EOSLibrary.instance.EOS_Auth_GetLoginStatus(this, localUserId);
	}

	/**
	 * Fetch a user auth token for an Epic Account ID.
	 * <p>
	 * A user authentication token allows any code with possession (backend/client) to perform certain actions on behalf of the user.
	 * Because of this, for the purposes of user identity verification, the EOS_Auth_CopyIdToken API should be used instead.
	 *
	 * @param options Structure containing the api version of CopyUserAuthToken to use
	 * @param localUserId The Epic Account ID of the user being queried
	 * @return The auth token for the given user, if it exists and is valid; use EOS_Auth_Token_Release when finished
	 * @see EOS_Auth_Token#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the auth token is not found or expired.
	 */
	public EOS_Auth_Token copyUserAuthToken(EOS_Auth_CopyUserAuthTokenOptions options, EOS_EpicAccountId localUserId) throws EOSException {
		final EOS_Auth_Token.ByReference authTokenReference = new EOS_Auth_Token.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Auth_CopyUserAuthToken(this, options, localUserId, authTokenReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return authTokenReference;
	}

	/**
	 * Fetch an ID token for an Epic Account ID.
	 * <p>
	 * ID tokens are used to securely verify user identities with online services.
	 * The most common use case is using an ID token to authenticate the local user by their selected account ID,
	 * which is the account ID that should be used to access any game-scoped data for the current application.
	 * <p>
	 * An ID token for the selected account ID of a locally authenticated user will always be readily available.
	 * To retrieve it for the selected account ID, you can use EOS_Auth_CopyIdToken directly after a successful user login.
	 *
	 * @param options Structure containing the account ID for which to copy an ID token.
	 * @return An ID token for the given user, if it exists and is valid; use EOS_Auth_IdToken_Release when finished.
	 *
	 * @see EOS_Auth_IdToken#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the Id token is not found or expired.
	 *
	 */
	public EOS_Auth_IdToken copyIdToken(EOS_Auth_CopyIdTokenOptions options) throws EOSException {
		final EOS_Auth_IdToken.ByReference authIdTokenReference = new EOS_Auth_IdToken.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Auth_CopyIdToken(this, options, authIdTokenReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return authIdTokenReference;
	}

	/**
	 * Query the backend for an ID token that describes one of the merged account IDs of a local authenticated user.
	 * <p>
	 * The ID token can be used to impersonate a merged account ID when communicating with online services.
	 * <p>
	 * An ID token for the selected account ID of a locally authenticated user will always be readily available and does not need to be queried explicitly.
	 *
	 * @param options Structure containing the merged account ID for which to query an ID token.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate.
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error.
	 */
	public void queryIdToken(EOS_Auth_QueryIdTokenOptions options, Pointer clientData, EOS_Auth_OnQueryIdTokenCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_QueryIdToken(this, options, clientData, completionDelegate);
	}

	/**
	 * Verify a given ID token for authenticity and validity.
	 *
	 * @param options Structure containing information about the ID token to verify.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error.
	 */
	public void verifyIdToken(EOS_Auth_VerifyIdTokenOptions options, Pointer clientData, EOS_Auth_OnVerifyIdTokenCallback completionDelegate) {
		EOSLibrary.instance.EOS_Auth_VerifyIdToken(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the selected account ID to the current application for a local authenticated user.
	 *
	 * @param localUserId The account ID of a currently logged in account.
	 * @return The selected account ID corresponding to the given account ID if the user is logged in and the information is available.
	 *
	 * @throws EOSInvalidParametersException if the output parameter is NULL.
	 * @throws EOSInvalidUserException if the input account ID is not locally known.
	 * @throws EOSInvalidAuthException if the input account ID is not locally logged in.
	 * @throws EOSNotFoundException otherwise.
	 */
	public EOS_EpicAccountId getSelectedAccountId(EOS_EpicAccountId localUserId) throws EOSException {
		final EOS_EpicAccountId epicAccountId = new EOS_EpicAccountId();
		final EOS_EResult result = EOSLibrary.instance.EOS_Auth_GetSelectedAccountId(this, localUserId, epicAccountId);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return epicAccountId;
	}

	/**
	 * Fetch the number of merged accounts for a given logged in account.
	 *
	 * @param localUserId The account ID of a currently logged in account.
	 *
	 * @return the number of merged accounts for the logged in account.
	 */
	public int getMergedAccountsCount(EOS_EpicAccountId localUserId) {
		return EOSLibrary.instance.EOS_Auth_GetMergedAccountsCount(this, localUserId);
	}

	/**
	 * Fetch one of the merged account IDs for a given logged in account.
	 *
	 * @param localUserId The account ID of a currently logged in account.
	 * @param index An index into the list of merged accounts. If the index is out of bounds, the returned Epic Account ID will be invalid.
	 *
	 * @return The Epic Account ID associated with the index passed.
	 */
	public EOS_EpicAccountId getMergedAccountByIndex(EOS_EpicAccountId localUserId, int index) {
		return EOSLibrary.instance.EOS_Auth_GetMergedAccountByIndex(this, localUserId, index);
	}

	/**
	 * Register to receive login status updates.<br>
	 * <b>Must call {@link #removeNotifyLoginStatusChanged(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options structure containing the api version of AddNotifyLoginStatusChanged to use
	 * @param clientData arbitrary data that is passed back to you in the callback
	 * @param notification a callback that is fired when the login status for a user changes
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyLoginStatusChanged(EOS_Auth_AddNotifyLoginStatusChangedOptions options,
	                                                      Pointer clientData,
	                                                      EOS_Auth_OnLoginStatusChangedCallback notification) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Auth_AddNotifyLoginStatusChanged(this, options, clientData, notification);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notification);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving login status updates.
	 *
	 * @param inId handle representing the registered callback
	 */
	public void removeNotifyLoginStatusChanged(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Auth_RemoveNotifyLoginStatusChanged(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}
}