package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.kws.options.EOS_KWS_RequestPermissionsOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_RequestPermissionsOptions Function. These parameters are received through the callback provided to EOS_KWS_RequestPermissions
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_KWS_RequestPermissionsCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if contact information update completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed requests is exceeded<br>
	 * {@link EOS_EResult#EOS_KWS_ParentEmailMissing} if the account requesting permissions has no parent email associated with it<br>
	 * {@link EOS_EResult#EOS_LimitExceeded} if the number of permissions exceeds {@link EOS_KWS_RequestPermissionsOptions#EOS_KWS_MAX_PERMISSIONS}, or if any permission name exceeds {@link EOS_KWS_RequestPermissionsOptions#EOS_KWS_MAX_PERMISSION_LENGTH}
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_KWS_RequestPermissions */
	public Pointer ClientData;
	/** Local user requesting new permissions */
	public EOS_ProductUserId LocalUserId;

	public EOS_KWS_RequestPermissionsCallbackInfo() {
		super();
	}

	public EOS_KWS_RequestPermissionsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_RequestPermissionsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_RequestPermissionsCallbackInfo implements Structure.ByValue {
	}
}