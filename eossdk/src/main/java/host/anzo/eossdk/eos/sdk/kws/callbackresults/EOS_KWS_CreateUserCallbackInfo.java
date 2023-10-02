package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_CreateUserOptions Function. These parameters are received through the callback provided to EOS_KWS_CreateUser
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "KWSUserId", "IsMinor"})
public class EOS_KWS_CreateUserCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if account creation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed requests is exceeded
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_KWS_CreateUser */
	public Pointer ClientData;
	/** Local user that created a KWS entry */
	public EOS_ProductUserId LocalUserId;
	/** KWS UserId created */
	public String KWSUserId;
	/** Is this user a minor */
	public EOS_Bool IsMinor;

	public EOS_KWS_CreateUserCallbackInfo() {
		super();
	}

	public EOS_KWS_CreateUserCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_CreateUserCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_CreateUserCallbackInfo implements Structure.ByValue {
	}
}