package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_SetTargetUserId function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_LobbySearch_SetTargetUserIdOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_SetTargetUserId API. */
	public static final int EOS_LOBBYSEARCH_SETTARGETUSERID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_SETTARGETUSERID_API_LATEST}. */
	public int ApiVersion;
	/** Search lobbies for given user by Product User ID, returning any lobbies where this user is currently registered */
	public EOS_ProductUserId TargetUserId;

	public EOS_LobbySearch_SetTargetUserIdOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_SETTARGETUSERID_API_LATEST;
	}

	public EOS_LobbySearch_SetTargetUserIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_SetTargetUserIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_SetTargetUserIdOptions implements Structure.ByValue {
	}
}