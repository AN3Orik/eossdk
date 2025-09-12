package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Connect_CreateUser function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Connect_CreateUserCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_CreateUser. */
	public Pointer ClientData;
	/** If the operation succeeded, this is the Product User ID of the local user who was created. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_CreateUserCallbackInfo() {
		super();
	}

	public EOS_Connect_CreateUserCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_CreateUserCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_CreateUserCallbackInfo implements Structure.ByValue {
	}
}