package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_RejectInvite function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "InviteId", "LocalUserId"})
public class EOS_Lobby_RejectInviteOptions extends Structure {
	/** The most recent version of the EOS_Lobby_RejectInvite API. */
	public static final int EOS_LOBBY_REJECTINVITE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_REJECTINVITE_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the lobby associated with the invitation */
	public String InviteId;
	/** The Product User ID of the local user who is rejecting the invitation */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_RejectInviteOptions() {
		super();
		ApiVersion = EOS_LOBBY_REJECTINVITE_API_LATEST;
	}

	public EOS_Lobby_RejectInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_RejectInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_RejectInviteOptions implements Structure.ByValue {
	}
}