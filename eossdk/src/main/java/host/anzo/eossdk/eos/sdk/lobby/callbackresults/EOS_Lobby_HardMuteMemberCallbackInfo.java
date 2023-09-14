package host.anzo.eossdk.eos.sdk.lobby.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Lobby_HardMuteMember function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LobbyId", "TargetUserId"})
public class EOS_Lobby_HardMuteMemberCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br><br>
	 * {@link EOS_EResult#EOS_Success} if the hard mute completes successfully<br>
	 * {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Invalid_ProductUserID} if a target user is incorrect<br>
	 * {@link EOS_EResult#EOS_NotFound} if lobby or target user cannot be found<br>
	 * {@link EOS_EResult#EOS_Lobby_VoiceNotEnabled} if lobby has no voice enabled<br>
	 * {@link EOS_EResult#EOS_Lobby_NotOwner} if the calling user is not the owner of the lobby<br>
	 * {@link EOS_EResult#EOS_NotFound} if a lobby of interest does not exist<br>
	 * {@link EOS_EResult#EOS_AlreadyPending} if the user is already marked for hard mute<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if there are too many requests
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Lobby_HardMuteMember */
	public Pointer ClientData;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the lobby member whose mute status has been updated */
	public EOS_ProductUserId TargetUserId;

	public EOS_Lobby_HardMuteMemberCallbackInfo() {
		super();
	}

	public EOS_Lobby_HardMuteMemberCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_HardMuteMemberCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_HardMuteMemberCallbackInfo implements Structure.ByValue {
	}
}