package host.anzo.eossdk.eos.sdk.auth;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_EAuthTokenType;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_ELoginCredentialType;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_CopyUserAuthTokenOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains an auth token.
 * These structures are created by EOS_Auth_CopyUserAuthToken and must be passed to EOS_Auth_Token_Release.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "App", "ClientId", "AccountId", "AccessToken", "ExpiresIn", "ExpiresAt", "AuthType", "RefreshToken", "RefreshExpiresIn", "RefreshExpiresAt"})
public class EOS_Auth_Token extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Auth_Token struct. */
	public static int EOS_AUTH_TOKEN_API_LATEST = 2;

	/** API Version: Set this to EOS_ANTICHEATCOMMON_LOGPLAYERTICK_API_LATEST. */
	public int ApiVersion;
	/** Name of the app related to the client ID involved with this token */
	private String App;
	/** Client ID that requested this token */
	public String ClientId;
	/** The Epic Account ID associated with this auth token */
	public EOS_EpicAccountId AccountId;
	/** Access token for the current user login session */
	public String AccessToken;
	/** Time before the access token expires, in seconds, relative to the call to EOS_Auth_CopyUserAuthToken */
	public double ExpiresIn;
	/** Absolute time in UTC before the access token expires, in ISO 8601 format */
	public String ExpiresAt;
	/** Type of auth token */
	public EOS_EAuthTokenType AuthType;
	/**
	 * Refresh token.
	 * @see EOS_ELoginCredentialType#EOS_LCT_RefreshToken
	 */
	public String RefreshToken;
	/** Time before the access token expires, in seconds, relative to the call to EOS_Auth_CopyUserAuthToken */
	public double RefreshExpiresIn;
	/** Absolute time in UTC before the refresh token expires, in ISO 8601 format */
	public String RefreshExpiresAt;

	public EOS_Auth_Token() {
		super();
		ApiVersion = EOS_AUTH_TOKEN_API_LATEST;
	}

	public EOS_Auth_Token(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_Auth_Token structure. This must be called on data retrieved from EOS_Auth_CopyUserAuthToken.
	 *
	 * @see EOS_Auth_Token
	 * @see EOS_Auth_Interface#copyUserAuthToken(EOS_Auth_CopyUserAuthTokenOptions, EOS_EpicAccountId)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Auth_Token_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Auth_Token implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_Token implements Structure.ByValue {
	}
}