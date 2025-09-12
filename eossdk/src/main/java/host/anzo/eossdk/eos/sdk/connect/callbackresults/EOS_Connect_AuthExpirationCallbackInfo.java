package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Connect_OnAuthExpirationCallback function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "LocalUserId"})
public class EOS_Connect_AuthExpirationCallbackInfo extends Structure {
	/** Context that was passed into EOS_Connect_AddNotifyAuthExpiration. */
	public Pointer ClientData;
	/** The Product User ID of the local player whose status has changed. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_AuthExpirationCallbackInfo() {
		super();
	}

	public EOS_Connect_AuthExpirationCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_AuthExpirationCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_AuthExpirationCallbackInfo implements Structure.ByValue {
	}
}
