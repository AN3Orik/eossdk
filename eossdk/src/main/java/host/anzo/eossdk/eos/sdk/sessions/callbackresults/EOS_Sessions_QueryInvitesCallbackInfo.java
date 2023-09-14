package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Sessions_QueryInvitesCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sessions_QueryInvites */
	public Pointer ClientData;
	/** The Product User of the local user who made the request */
	public EOS_ProductUserId LocalUserId;

	public EOS_Sessions_QueryInvitesCallbackInfo() {
		super();
	}

	public EOS_Sessions_QueryInvitesCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_QueryInvitesCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_QueryInvitesCallbackInfo implements Structure.ByValue {
	}
}