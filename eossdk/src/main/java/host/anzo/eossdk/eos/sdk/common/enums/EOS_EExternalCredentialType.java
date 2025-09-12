package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_CopyUserAuthTokenOptions;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LoginOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnCreateDeviceIdCallback;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CreateDeviceIdOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * List of the supported identity providers to authenticate a user.
 * <p>
 * The type of authentication token is specific to each provider.
 * Tokens in string format should be passed as-is to the function.
 * Tokens retrieved as raw byte arrays should be converted into a hex-encoded UTF-8 string (e.g. "FA87097A..") before being passed to the function.
 * EOS_ByteArray_ToString can be used for this conversion.
 *
 * @see EOS_Auth_Interface#login(EOS_Auth_LoginOptions, Pointer, EOS_Auth_OnLoginCallback)
 * @see EOS_Connect_Interface#login(EOS_Connect_LoginOptions, Pointer, EOS_Connect_OnLoginCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EExternalCredentialType implements NativeMapped {
	/**
	 * Epic Account Services Token
	 * <p>
	 * Using ID Token is preferred, retrieved with EOS_Auth_CopyIdToken that returns EOS_Auth_IdToken::JsonWebToken.
	 * Using Auth Token is supported for backwards compatibility, retrieved with EOS_Auth_CopyUserAuthToken that returns EOS_Auth_Token::AccessToken.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 *
	 * @see EOS_Auth_Interface#copyIdToken(EOS_EpicAccountId)
	 * @see EOS_Auth_Interface#copyUserAuthToken(EOS_Auth_CopyUserAuthTokenOptions, EOS_EpicAccountId)
	 */
	EOS_ECT_EPIC(0),
	/**
	 * Steam Encrypted App Ticket
	 * <p>
	 * <b>Note that EOS_ECT_STEAM_APP_TICKET is deprecated for use with EOS_Auth_Login. Use {@link #EOS_ECT_STEAM_SESSION_TICKET} instead.</b>
	 * <p>
	 * Generated using the ISteamUser::RequestEncryptedAppTicket API of Steamworks SDK.
	 * For ticket generation parameters, use pDataToInclude(NULL) and cbDataToInclude(0).
	 * <p>
	 * The retrieved App Ticket byte buffer needs to be converted into a hex-encoded UTF-8 string (e.g. "FA87097A..") before passing it to the EOS_Connect_Login API.
	 * EOS_ByteArray_ToString can be used for this conversion.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_STEAM_APP_TICKET(1),
	/**
	 * PlayStation(TM)Network ID Token
	 * <p>
	 * Retrieved from the PlayStation(R) SDK. Please see first-party documentation for additional information.
	 * <p>
	 * Supported with EOS_Auth_Login, EOS_Connect_Login.
	 */
	EOS_ECT_PSN_ID_TOKEN(2),
	/**
	 * Xbox Live XSTS Token
	 * <p>
	 * Retrieved from the GDK and XDK. Please see first-party documentation for additional information.
	 * <p>
	 * Supported with EOS_Auth_Login, EOS_Connect_Login.
	 */
	EOS_ECT_XBL_XSTS_TOKEN(3),
	/**
	 * Discord Access Token
	 * <p>
	 * Retrieved using the ApplicationManager::GetOAuth2Token API of Discord SDK.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_DISCORD_ACCESS_TOKEN(4),
	/**
	 * GOG Galaxy Encrypted App Ticket
	 * <p>
	 * Generated using the IUser::RequestEncryptedAppTicket API of GOG Galaxy SDK.
	 * For ticket generation parameters, use data(NULL) and dataSize(0).
	 * <p>
	 * The retrieved App Ticket byte buffer needs to be converted into a hex-encoded UTF-8 string (e.g. "FA87097A..") before passing it to the EOS_Connect_Login API.
	 * For C/C++ API integration, use the EOS_ByteArray_ToString API for the conversion.
	 * For C# integration, you can use Helper.ToHexString for the conversion.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_GOG_SESSION_TICKET(5),
	/**
	 * Nintendo Account ID Token
	 * <p>
	 * Identifies a Nintendo user account and is acquired through web flow authentication where the local user logs in using their email address/sign-in ID and password.
	 * This is the common Nintendo account that users login with outside the Nintendo Switch device.
	 * <p>
	 * Supported with EOS_Auth_Login, EOS_Connect_Login.<br>
	 * <b>Note: EOS_Auth_Login usage is restricted to Epic first party products only, attempting to use it will result in authentication failures.</b>
	 */
	EOS_ECT_NINTENDO_ID_TOKEN(6),
	/**
	 * Nintendo Service Account ID Token (NSA ID)
	 * <p>
	 * The NSA ID identifies uniquely the local Nintendo Switch device. The authentication token is acquired locally without explicit user credentials.
	 * As such, it is the primary authentication method for seamless login on Nintendo Switch.
	 * <p>
	 * The NSA ID is not exposed directly to the user and does not provide any means for login outside the local device.
	 * Because of this, Nintendo Switch users will need to link their Nintendo Account or another external user account
	 * to their Product User ID in order to share their game progression across other platforms. Otherwise, the user will
	 * not be able to login to their existing Product User ID on another platform due to missing login credentials to use.
	 * It is recommended that the game explicitly communicates this restriction to the user so that they will know to add
	 * the first linked external account on the Nintendo Switch device and then proceed with login on another platform.
	 * <p>
	 * In addition to sharing cross-platform game progression, linking the Nintendo Account or another external account
	 * will allow preserving the game progression permanently. Otherwise, the game progression will be tied only to the
	 * local device. In case the user loses access to their local device, they will not be able to recover the game
	 * progression if it is only associated with this account type.
	 * <p>
	 * Supported with EOS_Auth_Login, EOS_Connect_Login.
	 * <b>Note: EOS_Auth_Login usage is restricted to Epic first party products only, attempting to use it will result in authentication failures.</b>
	 */
	EOS_ECT_NINTENDO_NSA_ID_TOKEN(7),
	/**
	 * Uplay Access Token<br>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_UPLAY_ACCESS_TOKEN(8),
	/**
	 * OpenID Provider Access Token
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_OPENID_ACCESS_TOKEN(9),
	/**
	 * Device ID access token that identifies the current locally logged in user profile on the local device.
	 * The local user profile here refers to the operating system user login, for example the user's Windows Account
	 * or on a mobile device the default active user profile.
	 * <p>
	 * This credential type is used to automatically login the local user using the EOS Connect Device ID feature.
	 * <p>
	 * The intended use of the Device ID feature is to allow automatically logging in the user on a mobile device
	 * and to allow playing the game without requiring the user to necessarily login using a real user account at all.
	 * This makes a seamless first-time experience possible and allows linking the local device with a real external
	 * user account at a later time, sharing the same EOS_ProductUserId that is being used with the Device ID feature.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 *
	 * @see EOS_Connect_Interface#createDeviceId(EOS_Connect_CreateDeviceIdOptions, Pointer, EOS_Connect_OnCreateDeviceIdCallback)
	 */
	EOS_ECT_DEVICEID_ACCESS_TOKEN(10),
	/**
	 * Apple ID Token
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_APPLE_ID_TOKEN(11),
	/**
	 * Google ID Token
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_GOOGLE_ID_TOKEN(12),
	/**
	 * Oculus User ID and Nonce
	 * <p>
	 * Call ovr_User_GetUserProof(; or Platform.User.GetUserProof() if you are using Unity, to retrieve the nonce.
	 * Then pass the local User ID and the Nonce as a "{UserID}|{Nonce}" formatted string for the EOS_Connect_Login Token parameter.
	 * <p>
	 * Note that in order to successfully retrieve a valid non-zero id for the local user using ovr_User_GetUser(;
	 * your Oculus App needs to be configured in the Oculus Developer Dashboard to have the User ID feature enabled.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_OCULUS_USERID_NONCE(13),
	/**
	 * itch.io JWT Access Token
	 * <p>
	 * Use the itch.io app manifest to receive a JWT access token for the local user via the ITCHIO_API_KEY process environment variable.
	 * The itch.io access token is valid for 7 days after which the game needs to be restarted by the user as otherwise EOS Connect
	 * authentication session can no longer be refreshed.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_ITCHIO_JWT(14),
	/**
	 * itch.io Key Access Token
	 * <p>
	 * This access token type is retrieved through the OAuth 2.0 authentication flow for the itch.io application.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_ITCHIO_KEY(15),
	/**
	 * Epic Games ID Token
	 * <p>
	 * Acquired using EOS_Auth_CopyIdToken that returns EOS_Auth_IdToken::JsonWebToken.
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_EPIC_ID_TOKEN(16),
	/**
	 * Amazon Access Token
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_AMAZON_ACCESS_TOKEN(17),
	/**
	 * Steam Auth Session Ticket
	 * <p>
	 * Generated using the ISteamUser::GetAuthTicketForWebApi API of Steamworks SDK.
	 * <p>
	 * <b>ATTENTION</b><br>
	 * The pchIdentity input parameter of GetAuthTicketForWebApi API must be set to a valid non-empty string value.
	 * The string value used by the game client must match identically to the backend-configured value in EOS Dev Portal.
	 * The recommended value to use is "epiconlineservices" in lowercase, matching the default value for new Steam identity provider credentials in EOS Dev Portal.
	 * This identifier is important for security reasons to prevent session hijacking. Applications must use a dedicated unique identity identifier for Session Tickets passed to the EOS SDK APIs.
	 * Session Tickets using the EOS-assigned identifier must not be used with anything else than the EOS SDK APIs. You must use a different identifier when generating Session Tickets to authenticate with other parties.
	 * <p>
	 * <b>WARNING</b><br>
	 * To update an already live game to use the new GetAuthTicketForWebApi API instead of the deprecated GetAuthSessionTicket API, follow these steps in this order to prevent breaking the live game for players:<br>
	 * 1. Update your game client code to use the new ISteamUser::GetAuthTicketForWebApi API.<br>
	 * 2. Publish the new game client update to end-users.<br>
	 * 3. Update the existing Steam identity provider credentials entry in EOS Dev Portal to use the same identity string identifier as the game client.<br>
	 * <p>
	 * <b>Example:</b><br>
	 * {@code SteamUser()->GetAuthTicketForWebApi("epiconlineservices");}
	 * <p>
	 * The retrieved Auth Session Ticket byte buffer needs to be converted into a hex-encoded UTF-8 string (e.g. "FA87097A..") before passing it to the EOS_Auth_Login or EOS_Connect_Login APIs.
	 * EOS_ByteArray_ToString can be used for this conversion.
	 * <p>
	 * Supported with EOS_Auth_Login, EOS_Connect_Login.
	 *
	 * @since 1.15.1+
	 */
	EOS_ECT_STEAM_SESSION_TICKET(18),
	/**
	 * VIVEPORT User Session Token
	 * <p>
	 * Supported with EOS_Connect_Login.
	 */
	EOS_ECT_VIVEPORT_USER_TOKEN(19);

	private final int id;

	private static final Map<Integer, EOS_EExternalCredentialType> values = new HashMap<>();

	static {
		for (EOS_EExternalCredentialType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EExternalCredentialType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ECT_EPIC);
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
