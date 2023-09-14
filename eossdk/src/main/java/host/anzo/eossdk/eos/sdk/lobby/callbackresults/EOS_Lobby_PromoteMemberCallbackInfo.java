package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_PromoteMember function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId"})
public class EOS_Lobby_PromoteMemberCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the promote completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Lobby_NotOwner} if the calling user is not the owner of the lobby<br>
	 * {@link EOS_EResult#EOS_NotFound} if the lobby of interest does not exist<br>
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_PromoteMember */
	public Pointer ClientData;
	/** The ID of the lobby where the user was promoted */
	public String LobbyId;

	public EOS_Lobby_PromoteMemberCallbackInfo() {
		super();
	}

	public EOS_Lobby_PromoteMemberCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_PromoteMemberCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_PromoteMemberCallbackInfo implements Structure.ByValue {
	}
}