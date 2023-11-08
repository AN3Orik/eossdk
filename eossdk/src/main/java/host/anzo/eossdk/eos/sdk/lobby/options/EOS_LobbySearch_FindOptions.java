package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbySearch_Find function.
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_LobbySearch_FindOptions extends Structure {
	/** The most recent version of the EOS_LobbySearch_Find API. */
	public static final int EOS_LOBBYSEARCH_FIND_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYSEARCH_FIND_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user making the search request */
	public EOS_ProductUserId LocalUserId;

	public EOS_LobbySearch_FindOptions() {
		super();
		ApiVersion = EOS_LOBBYSEARCH_FIND_API_LATEST;
	}

	public EOS_LobbySearch_FindOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbySearch_FindOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbySearch_FindOptions implements Structure.ByValue {
	}
}