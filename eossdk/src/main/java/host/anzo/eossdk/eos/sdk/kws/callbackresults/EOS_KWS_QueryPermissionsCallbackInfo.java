package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_QueryPermissionsOptions Function. These parameters are received through the callback provided to EOS_KWS_QueryPermissions
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "KWSUserId", "DateOfBirth", "bIsMinor", "ParentEmail"})
public class EOS_KWS_QueryPermissionsCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the account query completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed requests is exceeded
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_KWS_QueryPermissions */
	public Pointer ClientData;
	/** Local user querying their permissions */
	public EOS_ProductUserId LocalUserId;
	/** KWS UserId created */
	public String KWSUserId;
	/** Date of birth in ISO8601 form (YYYY-MM-DD) */
	public String DateOfBirth;
	/** Is this user a minor */
	public int bIsMinor;
	/** Parent email. This value may be set to an empty string if the originally registered email recipient declined to be the right person to give consent. */
	public String ParentEmail;

	public EOS_KWS_QueryPermissionsCallbackInfo() {
		super();
	}

	public EOS_KWS_QueryPermissionsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_QueryPermissionsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_QueryPermissionsCallbackInfo implements Structure.ByValue {
	}
}