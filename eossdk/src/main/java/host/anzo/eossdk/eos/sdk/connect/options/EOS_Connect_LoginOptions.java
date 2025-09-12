package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_Credentials;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_UserLoginInfo;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_Login function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "Credentials", "UserLoginInfo"})
public class EOS_Connect_LoginOptions extends Structure {
	/** The most recent version of the EOS_Connect_Login API. */
	public static int EOS_CONNECT_LOGIN_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_CONNECT_LOGIN_API_LATEST}. */
	public int ApiVersion;
	/** Credentials specified for a given login method */
	public EOS_Connect_Credentials.ByReference Credentials;
	/**
	 * Additional non-authoritative information about the local user.
	 * <p>
	 * This field is required to be set and only used when authenticating the user using Amazon, Apple, Google, Nintendo Account, Nintendo Service Account, Oculus or the Device ID feature login.
	 * When using other identity providers, set to NULL.
	 * It is also required for using the Lobbies and Sessions interfaces when running on the Nintendo Switch device, and using any other credential type than EOS_ECT_NINTENDO_NSA_ID_TOKEN.
	 * In all other cases, set this field to NULL.
	 */
	public EOS_Connect_UserLoginInfo.ByReference UserLoginInfo;

	public EOS_Connect_LoginOptions() {
		super();
		ApiVersion = EOS_CONNECT_LOGIN_API_LATEST;
	}

	public EOS_Connect_LoginOptions(EOS_Connect_Credentials.ByReference credentials) {
		this();
		Credentials = credentials;
	}

	public EOS_Connect_LoginOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_LoginOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LoginOptions implements Structure.ByValue {
	}
}