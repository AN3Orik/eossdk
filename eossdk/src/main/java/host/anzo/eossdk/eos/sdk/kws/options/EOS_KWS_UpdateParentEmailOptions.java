package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_KWS_UpdateParentEmail function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ParentEmail"})
public class EOS_KWS_UpdateParentEmailOptions extends Structure {
	/** The most recent version of the EOS_KWS_UpdateParentEmail API. */
	public static final int EOS_KWS_UPDATEPARENTEMAIL_API_LATEST = 1;

	/** API Version: Set this to EOS_KWS_UPDATEPARENTEMAIL_API_LATEST. */
	public int ApiVersion;
	/** Local user updating parental information */
	public EOS_ProductUserId LocalUserId;
	/** New parent email */
	public String ParentEmail;

	public EOS_KWS_UpdateParentEmailOptions() {
		super();
		ApiVersion = EOS_KWS_UPDATEPARENTEMAIL_API_LATEST;
	}

	public EOS_KWS_UpdateParentEmailOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_UpdateParentEmailOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_UpdateParentEmailOptions implements Structure.ByValue {
	}
}