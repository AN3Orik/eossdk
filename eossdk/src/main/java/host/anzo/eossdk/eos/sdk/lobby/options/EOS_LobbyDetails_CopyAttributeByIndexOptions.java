package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyDetails_CopyAttributeByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "AttrIndex"})
public class EOS_LobbyDetails_CopyAttributeByIndexOptions extends Structure {
	/** The most recent version of the EOS_LobbyDetails_CopyAttributeByIndex API. */
	public static final int EOS_LOBBYDETAILS_COPYATTRIBUTEBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYDETAILS_COPYATTRIBUTEBYINDEX_API_LATEST}. */
	public int ApiVersion;
	public int AttrIndex;

	public EOS_LobbyDetails_CopyAttributeByIndexOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_COPYATTRIBUTEBYINDEX_API_LATEST;
	}

	public EOS_LobbyDetails_CopyAttributeByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_CopyAttributeByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_CopyAttributeByIndexOptions implements Structure.ByValue {
	}
}