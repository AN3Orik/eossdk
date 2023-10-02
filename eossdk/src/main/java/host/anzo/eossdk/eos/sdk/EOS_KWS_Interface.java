package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.kws.EOS_KWS_PermissionStatus;
import host.anzo.eossdk.eos.sdk.kws.callbacks.*;
import host.anzo.eossdk.eos.sdk.kws.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

import java.nio.IntBuffer;

/**
 * This interface is not available for general access at this time.
 * <p>
 * The KWS Interface exists as an integration for age gating functionality provided by Kids Web Services from SuperAwesome, using the EOS Connect interface.
 * <p>
 * All KWS Interface calls take a handle of type EOS_HKWS as the first parameter.
 * This handle can be retrieved from a EOS_HPlatform handle by using the EOS_Platform_GetKWSInterface function.
 *
 * @see EOS_Platform_Interface#getKWSInterface()
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public class EOS_KWS_Interface extends PointerType {
	public EOS_KWS_Interface(Pointer address) {
		super(address);
	}
	public EOS_KWS_Interface() {
		super();
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Query the client's country and age permissions for client side reasoning about the possible need enforce age based restrictions
	 *
	 * @param options options required for interacting with the age gate system
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void queryAgeGate(EOS_KWS_QueryAgeGateOptions options, Pointer clientData, EOS_KWS_OnQueryAgeGateCallback completionDelegate) {
		EOSLibrary.instance.EOS_KWS_QueryAgeGate(this, options, clientData, completionDelegate);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Create an account with Kids Web Services and associate it with the local Product User ID
	 *
	 * @param options options required for creating an account such as the local users Product User ID, their data of birth, and parental contact information
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void createUser(EOS_KWS_CreateUserOptions options, Pointer clientData, EOS_KWS_OnCreateUserCallback completionDelegate) {
		EOSLibrary.instance.EOS_KWS_CreateUser(this, options, clientData, completionDelegate);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Query the current state of permissions for a given local Product User ID
	 *
	 * @param options options required for querying permissions such as the local users Product User ID
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void queryPermissions(EOS_KWS_QueryPermissionsOptions options, Pointer clientData, EOS_KWS_OnQueryPermissionsCallback completionDelegate) {
		EOSLibrary.instance.EOS_KWS_QueryPermissions(this, options, clientData, completionDelegate);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Update the parent contact information for a given local Product User ID
	 *
	 * @param options options required for updating the contact information such as the new email address
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void updateParentEmail(EOS_KWS_UpdateParentEmailOptions options, Pointer clientData, EOS_KWS_OnUpdateParentEmailCallback completionDelegate) {
		EOSLibrary.instance.EOS_KWS_UpdateParentEmail(this, options, clientData, completionDelegate);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Request new permissions for a given local Product User ID
	 *
	 * @param options options required for updating permissions such as the new list of permissions
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate A callback that is fired when the operation completes, either successfully or in error
	 */
	public void requestPermissions(EOS_KWS_RequestPermissionsOptions options, Pointer clientData, EOS_KWS_OnRequestPermissionsCallback completionDelegate) {
		EOSLibrary.instance.EOS_KWS_RequestPermissions(this, options, clientData, completionDelegate);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Fetch the number of permissions found for a given local user
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return the number of permissions associated with the given user
	 */
	public int getPermissionsCount(EOS_KWS_GetPermissionsCountOptions options) {
		return EOSLibrary.instance.EOS_KWS_GetPermissionsCount(this, options);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Fetch a permission for a given by index for a given local user
	 *
	 * @param options Structure containing the input parameters
	 * @return the permission for the given index, if it exists and is valid, use EOS_KWS_PermissionStatus_Release when finished
	 *
	 * @see #createUser(EOS_KWS_CreateUserOptions, Pointer, EOS_KWS_OnCreateUserCallback)
	 * @see #queryPermissions(EOS_KWS_QueryPermissionsOptions, Pointer, EOS_KWS_OnQueryPermissionsCallback)
	 * @see #requestPermissions(EOS_KWS_RequestPermissionsOptions, Pointer, EOS_KWS_OnRequestPermissionsCallback)
	 * @see EOS_KWS_PermissionStatus#release()
	 *
	 * @throws EOSNotFoundException if the user is not found or the index is invalid
	 */
	public EOS_KWS_PermissionStatus copyPermissionByIndex(EOS_KWS_CopyPermissionByIndexOptions options) throws EOSException {
		final EOS_KWS_PermissionStatus.ByReference outPermission = new EOS_KWS_PermissionStatus.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_KWS_CopyPermissionByIndex(this, options, outPermission);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outPermission;
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Fetch the state of a given permission that are cached for a given local user.
	 *
	 * @param options Structure containing the input parameters
	 * @param outPermission the permission for the given key, if it exists and is valid
	 *
	 * @see #createUser(EOS_KWS_CreateUserOptions, Pointer, EOS_KWS_OnCreateUserCallback)
	 * @see #queryPermissions(EOS_KWS_QueryPermissionsOptions, Pointer, EOS_KWS_OnQueryPermissionsCallback)
	 * @see #requestPermissions(EOS_KWS_RequestPermissionsOptions, Pointer, EOS_KWS_OnRequestPermissionsCallback)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the permission state is known for the given user and key
	 *         {@link EOS_EResult#EOS_NotFound} if the user or the permission is not found
	 */
	public EOS_EResult getPermissionByKey(EOS_KWS_GetPermissionByKeyOptions options, IntBuffer outPermission) {
		return EOSLibrary.instance.EOS_KWS_GetPermissionByKey(this, options, outPermission);
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Register to receive notifications about KWS permissions changes for any logged in local users<br>
	 * <b>Must call {@link EOS_KWS_Interface#removeNotifyPermissionsUpdateReceived(EOS_NotificationId)} to remove the notification</b>
	 *
	 * @param options Structure containing information about the request.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param notificationFn A callback that is fired when a notification is received.
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyPermissionsUpdateReceived(EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions options,
	                                                                     Pointer clientData,
	                                                                     EOS_KWS_OnPermissionsUpdateReceivedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_KWS_AddNotifyPermissionsUpdateReceived(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * This interface is not available for general access at this time.
	 * <p>
	 * Unregister from receiving notifications about KWS permissions related to logged in users
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyPermissionsUpdateReceived(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_KWS_RemoveNotifyPermissionsUpdateReceived(this, inId);
		CallbackUtils.unregisterCallback(inId);
	}
}