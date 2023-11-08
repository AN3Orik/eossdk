package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_KWS_CreateUser function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "DateOfBirth", "ParentEmail"})
public class EOS_KWS_CreateUserOptions extends Structure {
	/** The most recent version of the EOS_KWS_CreateUser API. */
	public static final int EOS_KWS_CREATEUSER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_KWS_CREATEUSER_API_LATEST}. */
	public int ApiVersion;
	/** Local user creating a KWS entry */
	public EOS_ProductUserId LocalUserId;
	/** Date of birth in ISO8601 form (YYYY-MM-DD) */
	public String DateOfBirth;
	/** Parent email */
	public String ParentEmail;

	public EOS_KWS_CreateUserOptions() {
		super();
		ApiVersion = EOS_KWS_CREATEUSER_API_LATEST;
	}

	public EOS_KWS_CreateUserOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_CreateUserOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_CreateUserOptions implements Structure.ByValue {
	}
}