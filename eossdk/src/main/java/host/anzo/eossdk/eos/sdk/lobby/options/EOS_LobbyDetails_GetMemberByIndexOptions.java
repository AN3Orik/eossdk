package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyDetails_GetMemberByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "MemberIndex"})
public class EOS_LobbyDetails_GetMemberByIndexOptions extends Structure {
	public static final int EOS_LOBBYDETAILS_GETMEMBERBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYDETAILS_GETMEMBERBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Index of the member to retrieve */
	public int MemberIndex;

	public EOS_LobbyDetails_GetMemberByIndexOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_GETMEMBERBYINDEX_API_LATEST;
	}

	public EOS_LobbyDetails_GetMemberByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_GetMemberByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_GetMemberByIndexOptions implements Structure.ByValue {
	}
}