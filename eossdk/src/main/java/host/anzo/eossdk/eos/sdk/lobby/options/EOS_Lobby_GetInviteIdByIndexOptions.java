package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_GetInviteIdByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_Lobby_GetInviteIdByIndexOptions extends Structure {
	/** The most recent version of the EOS_Lobby_GetInviteIdByIndex API. */
	public static final int EOS_LOBBY_GETINVITEIDBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_GETINVITEIDBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who received the cached invitation */
	public EOS_ProductUserId LocalUserId;
	/** The index of the invitation ID to retrieve */
	public int Index;

	public EOS_Lobby_GetInviteIdByIndexOptions() {
		super();
		ApiVersion = EOS_LOBBY_GETINVITEIDBYINDEX_API_LATEST;
	}

	public EOS_Lobby_GetInviteIdByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_GetInviteIdByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_GetInviteIdByIndexOptions implements Structure.ByValue {
	}
}