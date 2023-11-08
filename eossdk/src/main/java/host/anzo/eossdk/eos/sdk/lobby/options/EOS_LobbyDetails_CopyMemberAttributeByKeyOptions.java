package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_LobbyDetails_CopyMemberAttributeByKey function.
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "AttrKey"})
public class EOS_LobbyDetails_CopyMemberAttributeByKeyOptions extends Structure {
	/** The most recent version of the EOS_LobbyDetails_CopyMemberAttributeByKey API. */
	public static final int EOS_LOBBYDETAILS_COPYMEMBERATTRIBUTEBYKEY_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYDETAILS_COPYMEMBERATTRIBUTEBYKEY_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the lobby member */
	public EOS_ProductUserId TargetUserId;
	/** Name of the attribute to copy */
	public String AttrKey;

	public EOS_LobbyDetails_CopyMemberAttributeByKeyOptions() {
		super();
	}

	public EOS_LobbyDetails_CopyMemberAttributeByKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_CopyMemberAttributeByKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_CopyMemberAttributeByKeyOptions implements Structure.ByValue {
	}
}