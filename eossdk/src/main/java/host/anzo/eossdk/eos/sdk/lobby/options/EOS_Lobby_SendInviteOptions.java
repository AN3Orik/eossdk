package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_SendInvite function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId", "TargetUserId"})
public class EOS_Lobby_SendInviteOptions extends Structure {
	/** The most recent version of the EOS_Lobby_SendInvite API. */
	public static final int EOS_LOBBY_SENDINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_SENDINVITE_API_LATEST. */
	public int ApiVersion;
	/** The ID of the lobby associated with the invitation */
	public String LobbyId;
	/** The Product User ID of the local user sending the invitation */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the user receiving the invitation */
	public EOS_ProductUserId TargetUserId;

	public EOS_Lobby_SendInviteOptions() {
		super();
		ApiVersion = EOS_LOBBY_SENDINVITE_API_LATEST;
	}

	public EOS_Lobby_SendInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_SendInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_SendInviteOptions implements Structure.ByValue {
	}
}