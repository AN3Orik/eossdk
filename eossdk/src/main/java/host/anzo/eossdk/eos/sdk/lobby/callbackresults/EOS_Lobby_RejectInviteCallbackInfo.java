package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_RejectInvite function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "InviteId"})
public class EOS_Lobby_RejectInviteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the invite rejection completes successfully
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 * {@link EOS_EResult#EOS_NotFound} if the invite does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_RejectInvite */
	public Pointer ClientData;
	/** The ID of the invitation being rejected */
	public String InviteId;

	public EOS_Lobby_RejectInviteCallbackInfo() {
		super();
	}

	public EOS_Lobby_RejectInviteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_RejectInviteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_RejectInviteCallbackInfo implements Structure.ByValue {
	}
}