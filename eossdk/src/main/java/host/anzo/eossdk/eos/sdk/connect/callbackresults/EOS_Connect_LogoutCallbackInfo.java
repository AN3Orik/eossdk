package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.*;

/**
 * Output parameters for the EOS_Connect_Logout function.
 *
 * @author Anton Lasevich
 * @since 3/23/2024
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Connect_LogoutCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_Logout. */
	public Pointer ClientData;
	/** The Product User ID of the player that is being logged out. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_LogoutCallbackInfo() {
		super();
	}

	public EOS_Connect_LogoutCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_LogoutCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LogoutCallbackInfo implements Structure.ByValue {
	}
}