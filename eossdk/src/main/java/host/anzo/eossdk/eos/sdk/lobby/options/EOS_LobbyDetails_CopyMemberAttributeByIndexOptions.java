package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyDetails_CopyMemberAttributeByIndex function.
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "AttrIndex"})
public class EOS_LobbyDetails_CopyMemberAttributeByIndexOptions extends Structure {
	public static final int EOS_LOBBYDETAILS_COPYMEMBERATTRIBUTEBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYDETAILS_COPYMEMBERATTRIBUTEBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the lobby member */
	public EOS_ProductUserId TargetUserId;
	/** The index of the attribute to copy */
	public int AttrIndex;

	public EOS_LobbyDetails_CopyMemberAttributeByIndexOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_COPYMEMBERATTRIBUTEBYINDEX_API_LATEST;
	}

	public EOS_LobbyDetails_CopyMemberAttributeByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_CopyMemberAttributeByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_CopyMemberAttributeByIndexOptions implements Structure.ByValue {
	}
}