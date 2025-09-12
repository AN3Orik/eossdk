package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Connect_Login function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "ContinuanceToken"})
public class EOS_Connect_LoginCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_Login. */
	public Pointer ClientData;
	/** If login was successful, this is the Product User ID of the local player that logged in. */
	public EOS_ProductUserId LocalUserId;
	/**
	 * If the user was not found with credentials passed into EOS_Connect_Login,
	 * this continuance token can be passed to either EOS_Connect_CreateUser
	 * or EOS_Connect_LinkAccount to continue the flow.
	 */
	public EOS_ContinuanceToken ContinuanceToken;

	public EOS_Connect_LoginCallbackInfo() {
		super();
	}

	public EOS_Connect_LoginCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_LoginCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LoginCallbackInfo implements Structure.ByValue {
	}
}