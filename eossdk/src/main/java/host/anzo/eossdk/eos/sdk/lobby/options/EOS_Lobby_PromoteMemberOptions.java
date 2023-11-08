package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_PromoteMember function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId", "TargetUserId"})
public class EOS_Lobby_PromoteMemberOptions extends Structure {
	/** The most recent version of the EOS_Lobby_PromoteMember API. */
	public static final int EOS_LOBBY_PROMOTEMEMBER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_PROMOTEMEMBER_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the local user making the request */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the member to promote to owner of the lobby */
	public EOS_ProductUserId TargetUserId;

	public EOS_Lobby_PromoteMemberOptions() {
		super();
		ApiVersion = EOS_LOBBY_PROMOTEMEMBER_API_LATEST;
	}

	public EOS_Lobby_PromoteMemberOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_PromoteMemberOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_PromoteMemberOptions implements Structure.ByValue {
	}
}