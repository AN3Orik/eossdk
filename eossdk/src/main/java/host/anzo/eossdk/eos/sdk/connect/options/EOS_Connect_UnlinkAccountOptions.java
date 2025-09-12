package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_UnlinkAccount Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Connect_UnlinkAccountOptions extends Structure {
	/** The most recent version of the EOS_Connect_UnlinkAccount API. */
	public static int EOS_CONNECT_UNLINKACCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_UNLINKACCOUNT_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Existing logged in product user that is subject for the unlinking operation.
	 * The external account that was used to login to the product user will be unlinked from the owning keychain.
	 * <p>
	 * On a successful operation, the product user will be logged out as the external account used to authenticate the user was unlinked from the owning keychain.
	 */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_UnlinkAccountOptions() {
		super();
		ApiVersion = EOS_CONNECT_UNLINKACCOUNT_API_LATEST;
	}

	public EOS_Connect_UnlinkAccountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_UnlinkAccountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_UnlinkAccountOptions implements Structure.ByValue {
	}
}