package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_LobbyDetails_GetMemberAttributeCountOptions extends Structure {
	public static final int EOS_LOBBYDETAILS_GETMEMBERATTRIBUTECOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYDETAILS_GETMEMBERATTRIBUTECOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the lobby member */
	public EOS_ProductUserId TargetUserId;

	public EOS_LobbyDetails_GetMemberAttributeCountOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_GETMEMBERATTRIBUTECOUNT_API_LATEST;
	}

	public EOS_LobbyDetails_GetMemberAttributeCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_GetMemberAttributeCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_GetMemberAttributeCountOptions implements Structure.ByValue {
	}
}