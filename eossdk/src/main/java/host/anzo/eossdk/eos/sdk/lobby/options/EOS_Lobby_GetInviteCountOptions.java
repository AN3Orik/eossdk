package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_GetInviteCount function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Lobby_GetInviteCountOptions extends Structure {
	/** The most recent version of the EOS_Lobby_GetInviteCount API. */
	public static final int EOS_LOBBY_GETINVITECOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_GETINVITECOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user whose cached lobby invitations you want to count */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_GetInviteCountOptions() {
		super();
		ApiVersion = EOS_LOBBY_GETINVITECOUNT_API_LATEST;
	}

	public EOS_Lobby_GetInviteCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_GetInviteCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_GetInviteCountOptions implements Structure.ByValue {
	}
}