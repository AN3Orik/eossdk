package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sessions_UpdateSession function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ResultCode", "ClientData", "SessionName", "SessionId"})
public class EOS_Sessions_UpdateSessionCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the update completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Sessions_OutOfSync} if the session is out of sync and will be updated on the next connection with the backend<br>
	 * {@link EOS_EResult#EOS_NotFound} if a session to be updated does not exist<br>
	 * {@link EOS_EResult#EOS_LimitExceeded} if a new session cannot be created because doing so would exceed the maximum allowed concurrent session count<br>
	 * {@link EOS_EResult#EOS_InvalidUser} if the local user associated with the session to update does not exist or is not authenticated
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sessions_UpdateSession */
	public Pointer ClientData;
	/** Name of the session that was created/modified */
	public String SessionName;
	/** ID of the session that was created/modified */
	public String SessionId;

	public EOS_Sessions_UpdateSessionCallbackInfo() {
		super();
	}

	public EOS_Sessions_UpdateSessionCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_UpdateSessionCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_UpdateSessionCallbackInfo implements Structure.ByValue {
	}
}