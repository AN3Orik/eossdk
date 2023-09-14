/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Credentials;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LoginOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible types of login methods, availability depends on permissions granted to the client.
 * @see EOS_Auth_Interface#login(EOS_Auth_LoginOptions, Pointer, EOS_Auth_OnLoginCallback)
 * @see EOS_Auth_Credentials
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_ELoginCredentialType implements NativeMapped {
	/**
	 * Login using account email address and password.
	 * <p>
	 * <b>Use of this login method is restricted and cannot be used in general.</b>
	 */
	EOS_LCT_Password(0),
	/**
	 * A short-lived one-time use exchange code to login the local user.
	 * <p>
	 * <b>Typically retrieved via command-line parameters provided by a launcher that generated the exchange code for this application.
	 * When started, the application is expected to consume the exchange code by using the EOS_Auth_Login API as soon as possible.
	 * This is needed in order to authenticate the local user before the exchange code would expire.
	 * Attempting to consume an already expired exchange code will return EOS_EResult::EOS_Auth_ExchangeCodeNotFound error by the EOS_Auth_Login API.</b>
	 */
	EOS_LCT_ExchangeCode(1),
	/**
	 * Used by standalone applications distributed outside the supported game platforms such as Epic Games Store or Steam, and on Nintendo Switch.
	 * <p>
	 * Persistent Auth is used in conjuction with the EOS_LCT_AccountPortal login method for automatic login of the local user across multiple runs of the application.
	 * <p>
	 * Standalone applications implement the login sequence as follows:<br>
	 * 1. Application calls EOS_Auth_Login with EOS_LCT_PersistentAuth, using a previously stored Epic refresh token for an automatic user login.<br>
	 * 2. If automatic login fails, the application discards the Epic refresh token used as defunct, and proceeds to call EOS_Auth_Login with EOS_LCT_AccountPortal to prompt the user for manual login.
	 * <p>
	 * <b>On Desktop and Mobile platforms, the persistent refresh token is automatically managed by the SDK that stores it in the keychain of the currently logged in user of the local device.
	 * On Nintendo Switch, after a successful login the refresh token must be retrieved using the EOS_Auth_CopyUserAuthToken API and stored by the application specifically for the active Nintendo Switch user.</b>
	 *
	 * @see EOS_ELoginCredentialType#EOS_LCT_AccountPortal
	 */
	EOS_LCT_PersistentAuth(2),
	/**
	 * Not supported. Superseded by EOS_LCT_ExternalAuth login method.
	 *
	 * @see EOS_ELoginCredentialType#EOS_LCT_ExternalAuth
	 */
	EOS_LCT_DeviceCode(3),
	/**
	 * Login with named credentials hosted by the EOS SDK Developer Authentication Tool.
	 * <p>
	 * <b>Used for development purposes only.</b>
	 */
	EOS_LCT_Developer(4),
	/**
	 * Refresh token that was retrieved from a previous call to EOS_Auth_Login API in another local process context.
	 * Mainly used in conjunction with custom desktop launcher applications.
	 * <p>
	 * <b>Can be used for example when launching the game from Epic Games Launcher and having an intermediate process
	 * in-between that requires authenticating the user before eventually starting the actual game client application.
	 * In such scenario, an intermediate launcher will log in the user by consuming the exchange code it received from the
	 * Epic Games Launcher. To allow the game client to also authenticate the user, it can copy the refresh token using the
	 * EOS_Auth_CopyUserAuthToken API and pass it via launch parameters to the started game client. The game client can then
	 * use the refresh token to log in the user.</b>
	 */
	EOS_LCT_RefreshToken(5),
	/**
	 * Used by standalone applications distributed outside the supported game platforms such as Epic Games Store or Steam, and on Nintendo Switch.
	 * <p>
	 * Login using the built-in user onboarding experience provided by the SDK, which will automatically store a persistent
	 * refresh token to enable automatic user login for consecutive application runs on the local device. Applications are
	 * expected to attempt automatic login using the EOS_LCT_PersistentAuth login method, and fall back to EOS_LCT_AccountPortal
	 * to prompt users for manual login.
	 * <p>
	 * <b>On Windows, using this login method requires applications to be started through the EOS Bootstrapper application
	 * and to have the local Epic Online Services redistributable installed on the local system. See EOS_Platform_GetDesktopCrossplayStatus
	 * for adding a readiness check prior to calling EOS_Auth_Login.</b>
	 *
	 * @see EOS_ELoginCredentialType#EOS_LCT_PersistentAuth
	 */
	EOS_LCT_AccountPortal(6),
	/**
	 * Login using external account provider credentials, such as PlayStation(TM)Network, Steam, and Xbox Live.
	 * <p>
	 * This is the intended login method on PlayStation® and Xbox console devices.
	 * On Desktop and Mobile, used when launched through any of the commonly supported platform clients.
	 * <p>
	 * <b>The user is seamlessly logged in to their Epic account using an external account access token.
	 * If the local platform account is already linked with the user's Epic account, the login will succeed and EOS_EResult::EOS_Success is returned.
	 * When the local platform account has not been linked with an Epic account yet,
	 * EOS_EResult::EOS_InvalidUser is returned and the EOS_ContinuanceToken will be set in the EOS_Auth_LoginCallbackInfo data.
	 * If EOS_EResult::EOS_InvalidUser is returned,
	 * the application should proceed to call the EOS_Auth_LinkAccount API with the EOS_ContinuanceToken to continue with the external account login
	 * and to link the external account at the end of the login flow.</b>
	 * <p>
	 * <b>Login flow when the platform user account has not been linked with an Epic account yet:<br>
	 * 1. Game calls EOS_Auth_Login with the EOS_LCT_ExternalAuth credential type.<br>
	 * 2. EOS_Auth_Login returns EOS_EResult::EOS_InvalidUser with a non-null EOS_ContinuanceToken in the EOS_Auth_LoginCallbackInfo data.<br>
	 * 3. Game calls EOS_Auth_LinkAccount with the EOS_ContinuanceToken to initiate the login flow for linking the platform account with the user's Epic account.<br>
	 * 4. The user is taken automatically to the Epic accounts user onboarding flow managed by the SDK.<br>
	 * 5. Once the user completes the login, cancels it or if the login flow times out, EOS_Auth_LinkAccount invokes the completion callback to the caller.<br>
	 *    - If the user was logged in successfully, EOS_EResult::EOS_Success is returned in the EOS_Auth_LoginCallbackInfo. Otherwise, an error result code is returned accordingly.</b>
	 * <p>
	 * <b>On Windows, using this login method requires applications to be started through the EOS Bootstrapper application
	 * and to have the local Epic Online Services redistributable installed on the local system. See EOS_Platform_GetDesktopCrossplayStatus
	 * for adding a readiness check prior to calling EOS_Auth_Login.</b>
	 */
	EOS_LCT_ExternalAuth(7);

	private final int id;

	private static final Map<Integer, EOS_ELoginCredentialType> values = new HashMap<>();

	static {
		for (EOS_ELoginCredentialType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELoginCredentialType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_LCT_Password);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}