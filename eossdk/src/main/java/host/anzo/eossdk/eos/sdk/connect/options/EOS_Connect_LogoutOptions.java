package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.*;

/**
 * Input parameters for the EOS_Connect_Logout API
 *
 * @author Anton Lasevich
 * @since 3/23/2024
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Connect_LogoutOptions extends Structure {
	/** The most recent version of the EOS_Connect_Logout API. */
	public final static int EOS_CONNECT_LOGOUT_API_LATEST = 1;

	/** API Version: Set this to  {@link #EOS_CONNECT_LOGOUT_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the player to logout */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_LogoutOptions() {
		super();
		ApiVersion = EOS_CONNECT_LOGOUT_API_LATEST;
	}

	public EOS_Connect_LogoutOptions(EOS_ProductUserId localUserId) {
		this();
		LocalUserId = localUserId;
	}

	public static class ByReference extends EOS_Connect_LogoutOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LogoutOptions implements Structure.ByValue {
	}
}