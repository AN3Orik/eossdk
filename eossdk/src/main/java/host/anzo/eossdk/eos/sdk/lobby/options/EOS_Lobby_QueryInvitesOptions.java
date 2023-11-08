package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_QueryInvites function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Lobby_QueryInvitesOptions extends Structure {
	/** The most recent version of the EOS_Lobby_QueryInvites API. */
	public static final int EOS_LOBBY_QUERYINVITES_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_QUERYINVITES_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user whose invitations you want to retrieve */
	public EOS_ProductUserId LocalUserId;

	public EOS_Lobby_QueryInvitesOptions() {
		super();
		ApiVersion = EOS_LOBBY_QUERYINVITES_API_LATEST;
	}

	public EOS_Lobby_QueryInvitesOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_QueryInvitesOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_QueryInvitesOptions implements Structure.ByValue {
	}
}