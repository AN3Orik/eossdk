package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_QueryInvites function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Lobby_QueryInvitesCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_QueryInvites */
	public Pointer ClientData;
	/** The Product User ID of the local user that made the request */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_QueryInvitesCallbackInfo() {
		super();
	}

	public EOS_Lobby_QueryInvitesCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_QueryInvitesCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_QueryInvitesCallbackInfo implements Structure.ByValue {
	}
}