package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * Input parameters for the {@link EOSLibrary#EOS_LobbyDetails_CopyMemberInfo} function.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_LobbyDetails_CopyMemberInfoOptions extends Structure {
	/** The most recent version of the EOS_LobbyDetails_CopyMemberInfo API. */
	public static final int EOS_LOBBYDETAILS_COPYMEMBERINFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBYDETAILS_COPYMEMBERINFO_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the lobby member to copy. */
	public EOS_ProductUserId TargetUserId;

	public EOS_LobbyDetails_CopyMemberInfoOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_COPYMEMBERINFO_API_LATEST;
	}

	public EOS_LobbyDetails_CopyMemberInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_CopyMemberInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_CopyMemberInfoOptions implements Structure.ByValue {
	}
}