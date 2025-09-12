package host.anzo.eossdk.eos.sdk.auth;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains an ID token.
 * These structures are created by EOS_Auth_CopyIdToken and must be passed to EOS_Auth_IdToken_Release when finished.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "AccountId", "JsonWebToken"})
public class EOS_Auth_IdToken extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Auth_IdToken struct. */
	public static int EOS_AUTH_IDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_COPYUSERAUTHTOKEN_API_LATEST. */
	public int ApiVersion;
	/**
	 * The Epic Account ID described by the ID token.
	 * Use EOS_EpicAccountId_FromString to populate this field when validating a received ID token.
	 */
	public EOS_EpicAccountId AccountId;
	/** The ID token as a Json Web Token (JWT) string. */
	public String JsonWebToken;

	public EOS_Auth_IdToken() {
		super();
		ApiVersion = EOS_AUTH_IDTOKEN_API_LATEST;
	}

	public EOS_Auth_IdToken(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_Auth_IdToken structure. This must be called on data retrieved from EOS_Auth_CopyIdToken.
	 *
	 * @see EOS_Auth_IdToken
	 * @see EOS_Auth_Interface#copyIdToken(EOS_EpicAccountId)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Auth_IdToken_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Auth_IdToken implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_IdToken implements Structure.ByValue {
	}
}