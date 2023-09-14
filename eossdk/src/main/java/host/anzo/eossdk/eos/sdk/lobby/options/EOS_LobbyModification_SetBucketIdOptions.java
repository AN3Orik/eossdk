package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyModification_SetBucketId function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "BucketId"})
public class EOS_LobbyModification_SetBucketIdOptions extends Structure {
	public static final int EOS_LOBBYMODIFICATION_SETBUCKETID_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYMODIFICATION_SETBUCKETID_API_LATEST. */
	public int ApiVersion;
	/** The new bucket id associated with the lobby */
	public String BucketId;

	public EOS_LobbyModification_SetBucketIdOptions() {
		super();
		ApiVersion = EOS_LOBBYMODIFICATION_SETBUCKETID_API_LATEST;
	}

	public EOS_LobbyModification_SetBucketIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyModification_SetBucketIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyModification_SetBucketIdOptions implements Structure.ByValue {
	}
}