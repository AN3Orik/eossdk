package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.*;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_OnlinePlatformType;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnQueryExternalAccountMappingsCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_QueryExternalAccountMappingsOptions;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo_BestDisplayName;
import host.anzo.eossdk.eos.sdk.userinfo.EOS_UserInfo_ExternalUserInfo;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback;
import host.anzo.eossdk.eos.sdk.userinfo.callbacks.EOS_UserInfo_OnQueryUserInfoCallback;
import host.anzo.eossdk.eos.sdk.userinfo.options.*;

/**
 * The UserInfo Interface is used to receive user information for Epic Account IDs from the backend services and to retrieve that information once it is cached.
 * All UserInfo Interface calls take a handle of type EOS_UserInfo as the first parameter.
 * This handle can be retrieved from a EOS_Platform handle by using the EOS_Platform_GetUserInfoInterface function.
 *
 * @see EOS_Platform_Interface#getUserInfoInterface()
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public class EOS_UserInfo_Interface extends PointerType {
	public EOS_UserInfo_Interface(Pointer address) {
		super(address);
	}

	public EOS_UserInfo_Interface() {
		super();
	}

	/**
	 * EOS_UserInfo_QueryUserInfo is used to start an asynchronous query to retrieve information, such as display name, about another account.
	 * Once the callback has been fired with a successful ResultCode, it is possible to call EOS_UserInfo_CopyUserInfo to receive an EOS_UserInfo containing the available information.
	 *
	 * @param options structure containing the input parameters
	 * @param clientData arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 *
	 * @see EOS_UserInfo
	 * @see #copyUserInfo(EOS_UserInfo_CopyUserInfoOptions)
	 * @see EOS_UserInfo_QueryUserInfoOptions
	 * @see EOS_UserInfo_OnQueryUserInfoCallback
	 */
	public void queryUserInfo(EOS_UserInfo_QueryUserInfoOptions options, Pointer clientData, EOS_UserInfo_OnQueryUserInfoCallback completionDelegate) {
		EOSLibrary.instance.EOS_UserInfo_QueryUserInfo(this, options, clientData, completionDelegate);
	}

	/**
	 * EOS_UserInfo_QueryUserInfoByDisplayName is used to start an asynchronous query to retrieve user information by display name. This can be useful for getting the EOS_EpicAccountId for a display name.
	 * Once the callback has been fired with a successful ResultCode, it is possible to call EOS_UserInfo_CopyUserInfo to receive an EOS_UserInfo containing the available information.
	 *
	 * @param options structure containing the input parameters
	 * @param clientData arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 *
	 * @see EOS_UserInfo
	 * @see #copyUserInfo(EOS_UserInfo_CopyUserInfoOptions)
	 * @see EOS_UserInfo_QueryUserInfoByDisplayNameOptions
	 * @see EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback
	 */
	public void queryUserInfoByDisplayName(EOS_UserInfo_QueryUserInfoByDisplayNameOptions options,
	                                       Pointer clientData,
	                                       EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback completionDelegate) {
		EOSLibrary.instance.EOS_UserInfo_QueryUserInfoByDisplayName(this, options, clientData, completionDelegate);
	}

	/**
	 * EOS_UserInfo_QueryUserInfoByExternalAccount is used to start an asynchronous query to retrieve user information by external accounts.
	 * This can be useful for getting the EOS_EpicAccountId for external accounts.
	 * Once the callback has been fired with a successful ResultCode, it is possible to call CopyUserInfo to receive an EOS_UserInfo containing the available information.
	 *
	 * @param options structure containing the input parameters
	 * @param clientData arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 *
	 * @see EOS_UserInfo
	 * @see EOS_UserInfo_QueryUserInfoByExternalAccountOptions
	 * @see EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback
	 */
	public void queryUserInfoByExternalAccount(EOS_UserInfo_QueryUserInfoByExternalAccountOptions options, Pointer clientData, EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback completionDelegate) {
		EOSLibrary.instance.EOS_UserInfo_QueryUserInfoByExternalAccount(this, options, clientData, completionDelegate);
	}

	/**
	 * EOS_UserInfo_CopyUserInfo is used to immediately retrieve a copy of user information based on an Epic Account ID, cached by a previous call to EOS_UserInfo_QueryUserInfo.
	 * If the call returns an EOS_Success result, the out parameter, OutUserInfo, must be passed to EOS_UserInfo_Release to release the memory associated with it.
	 *
	 * @param options structure containing the input parameters
	 * @return out parameter used to receive the EOS_UserInfo structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 * @throws EOSNotFoundException if the user info is not locally cached. The information must have been previously cached by a call to EOS_UserInfo_QueryUserInfo
	 *
	 * @see EOS_UserInfo
	 * @see EOS_UserInfo_CopyUserInfoOptions
	 * @see EOS_UserInfo#release()
	 */
	public EOS_UserInfo copyUserInfo(EOS_UserInfo_CopyUserInfoOptions options) throws EOSException {
		final EOS_UserInfo.ByReference outUserInfo = new EOS_UserInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyUserInfo(this, options, outUserInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outUserInfo;
	}

	/**
	 * Fetch the number of external user infos that are cached locally.
	 *
	 * @param options The options associated with retrieving the external user info count
	 *
	 * @see #copyExternalUserInfoByIndex(EOS_UserInfo_CopyExternalUserInfoByIndexOptions)
	 *
	 * @return The number of external user infos, or 0 if there is an error
	 */
	public int getExternalUserInfoCount(EOS_UserInfo_GetExternalUserInfoCountOptions options) {
		return EOSLibrary.instance.EOS_UserInfo_GetExternalUserInfoCount(this, options);
	}

	/**
	 * Fetches an external user info from a given index.
	 *
	 * @param options Structure containing the index being accessed
	 * @return The external user info. If it exists and is valid, use EOS_UserInfo_ExternalUserInfo_Release when finished
	 *
	 * @see EOS_UserInfo_ExternalUserInfo#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the external user info is not found
	 */
	public EOS_UserInfo_ExternalUserInfo copyExternalUserInfoByIndex(EOS_UserInfo_CopyExternalUserInfoByIndexOptions options) throws EOSException {
		final EOS_UserInfo_ExternalUserInfo.ByReference outExternalUserInfo = new EOS_UserInfo_ExternalUserInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyExternalUserInfoByIndex(this, options, outExternalUserInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outExternalUserInfo;
	}

	/**
	 * Fetches an external user info for a given external account type.
	 *
	 * @param options Structure containing the account type being accessed
	 * @return The external user info. If it exists and is valid, use EOS_UserInfo_ExternalUserInfo_Release when finished
	 *
	 * @see EOS_UserInfo_ExternalUserInfo#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the external user info is not found
	 */
	public EOS_UserInfo_ExternalUserInfo copyExternalUserInfoByAccountType(EOS_UserInfo_CopyExternalUserInfoByAccountTypeOptions options) throws EOSException {
		final EOS_UserInfo_ExternalUserInfo.ByReference outExternalUserInfo = new EOS_UserInfo_ExternalUserInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyExternalUserInfoByAccountType(this, options, outExternalUserInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outExternalUserInfo;
	}

	/**
	 * Fetches an external user info for a given external account ID.
	 *
	 * @param options Structure containing the account ID being accessed
	 * @return The external user info. If it exists and is valid, use EOS_UserInfo_ExternalUserInfo_Release when finished
	 *
	 * @see EOS_UserInfo_ExternalUserInfo#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the external user info is not found
	 */
	public EOS_UserInfo_ExternalUserInfo copyExternalUserInfoByAccountId(EOS_UserInfo_CopyExternalUserInfoByAccountIdOptions options) throws EOSException {
		final EOS_UserInfo_ExternalUserInfo.ByReference outExternalUserInfo = new EOS_UserInfo_ExternalUserInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyExternalUserInfoByAccountId(this, options, outExternalUserInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outExternalUserInfo;
	}

	/**
	 * EOS_UserInfo_CopyBestDisplayName is used to immediately retrieve a copy of user's best display name based on an Epic Account ID.
	 * This uses data cached by a previous call to EOS_UserInfo_QueryUserInfo, EOS_UserInfo_QueryUserInfoByDisplayName or EOS_UserInfo_QueryUserInfoByExternalAccount as well as EOS_Connect_QueryExternalAccountMappings.
	 * If the call returns an EOS_Success result, the out parameter, outBestDisplayName, must be passed to EOS_UserInfo_BestDisplayName_Release to release the memory associated with it.<br><br>
	 * The current priority for picking display name is as follows:
	 * <ul>
	 * <li>1. Target is online and friends with user, then use presence platform to determine display name
	 * <li>2. Target is in same lobby or is the owner of a lobby search result, then use lobby platform to determine display name (this requires the target's product user id to be cached)
	 * <li>3. Target is in same rtc room, then use rtc room platform to determine display name (this requires the target's product user id to be cached)
	 * </ul>
	 * @param options structure containing the input parameters
	 * @return out parameter used to receive the EOS_UserInfo_BestDisplayName structure.
	 *
	 * @throws EOSUserInfoBestDisplayNameIndeterminateException unable to determine a cert friendly display name for user, one potential solution would be to call EOS_UserInfo_CopyBestDisplayNameWithPlatform with EOS_OPT_Epic for the platform, see doc for more details
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the user info or product user id is not locally cached
	 *
	 * @see #queryUserInfo(EOS_UserInfo_QueryUserInfoOptions, Pointer, EOS_UserInfo_OnQueryUserInfoCallback)
	 * @see #queryUserInfoByDisplayName(EOS_UserInfo_QueryUserInfoByDisplayNameOptions, Pointer, EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback)
	 * @see #queryUserInfoByExternalAccount(EOS_UserInfo_QueryUserInfoByExternalAccountOptions, Pointer, EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback)
	 * @see EOS_Connect_Interface#queryExternalAccountMappings(EOS_Connect_QueryExternalAccountMappingsOptions, Pointer, EOS_Connect_OnQueryExternalAccountMappingsCallback)
	 * @see #copyBestDisplayNameWithPlatform(EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions)
	 * @see EOS_UserInfo_CopyBestDisplayNameOptions
	 * @see EOS_UserInfo_BestDisplayName
	 * @see EOS_UserInfo_BestDisplayName#release()
	 */
	public EOS_UserInfo_BestDisplayName copyBestDisplayName(EOS_UserInfo_CopyBestDisplayNameOptions options) throws EOSException {
		final EOS_UserInfo_BestDisplayName.ByReference outBestDisplayName = new EOS_UserInfo_BestDisplayName.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyBestDisplayName(this, options, outBestDisplayName);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outBestDisplayName;
	}

	/**
	 * EOS_UserInfo_CopyBestDisplayNameWithPlatform is used to immediately retrieve a copy of user's best display name based on an Epic Account ID.
	 * This uses data cached by a previous call to EOS_UserInfo_QueryUserInfo, EOS_UserInfo_QueryUserInfoByDisplayName or EOS_UserInfo_QueryUserInfoByExternalAccount.
	 * If the call returns an EOS_Success result, the out parameter, outBestDisplayName, must be passed to EOS_UserInfo_BestDisplayName_Release to release the memory associated with it.<br><br>
	 * The current priority for picking display name is as follows:
	 * <ul>
	 * <li>1. If platform is non-epic, then use platform display name (if the platform is linked to the account)
	 * <li>2. If platform is epic and user has epic display name, then use epic display name
	 * <li>3. If platform is epic and user has no epic display name, then use linked external account display name
	 * </ul>
	 * @param options structure containing the input parameters
	 * @return out parameter used to receive the EOS_UserInfo_BestDisplayName structure.
	 *
	 * @throws EOSUserInfoBestDisplayNameIndeterminateException unable to determine a cert friendly display name for user
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 * @throws EOSNotFoundException if the user info is not locally cached
	 *
	 * @see #queryUserInfo(EOS_UserInfo_QueryUserInfoOptions, Pointer, EOS_UserInfo_OnQueryUserInfoCallback)
	 * @see #queryUserInfoByDisplayName(EOS_UserInfo_QueryUserInfoByDisplayNameOptions, Pointer, EOS_UserInfo_OnQueryUserInfoByDisplayNameCallback)
	 * @see #queryUserInfoByExternalAccount(EOS_UserInfo_QueryUserInfoByExternalAccountOptions, Pointer, EOS_UserInfo_OnQueryUserInfoByExternalAccountCallback)
	 * @see EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions
	 * @see EOS_UserInfo_BestDisplayName
	 * @see EOS_UserInfo_BestDisplayName#release()
	 */
	public EOS_UserInfo_BestDisplayName copyBestDisplayNameWithPlatform(EOS_UserInfo_CopyBestDisplayNameWithPlatformOptions options) throws EOSException {
		final EOS_UserInfo_BestDisplayName.ByReference outBestDisplayName = new EOS_UserInfo_BestDisplayName.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_UserInfo_CopyBestDisplayNameWithPlatform(this, options, outBestDisplayName);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outBestDisplayName;
	}

	/**
	 * EOS_UserInfo_GetLocalPlatformType is used to retrieve the online platform type of the current running instance of the game.
	 *
	 * @param options structure containing the input parameters
	 *
	 * @return the online platform type of the current running instance of the game
	 *
	 * @see EOS_UserInfo_GetLocalPlatformTypeOptions
	 */
	public EOS_OnlinePlatformType getLocalPlatformType(EOS_UserInfo_GetLocalPlatformTypeOptions options) {
		return EOSLibrary.instance.EOS_UserInfo_GetLocalPlatformType(this, options);
	}
}
