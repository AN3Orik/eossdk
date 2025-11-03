package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the {@link EOSLibrary#EOS_SessionSearch_Find} function.
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ResultCode", "ClientData"})
public class EOS_SessionSearch_FindCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the find operation completes successfully<br>
	 * {@link EOS_EResult#EOS_NotFound} if searching for an individual session by sessionid or targetuserid returns no results<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_SessionSearch_Find */
	public String ClientData;

	public EOS_SessionSearch_FindCallbackInfo() {
		super();
	}

	public EOS_SessionSearch_FindCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_FindCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_FindCallbackInfo implements Structure.ByValue {
	}
}