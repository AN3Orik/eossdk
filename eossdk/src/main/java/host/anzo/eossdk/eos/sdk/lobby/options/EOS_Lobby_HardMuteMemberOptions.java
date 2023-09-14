package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Lobby_HardMuteMember function.
 *
 * @author Anton Lasevich
 * @since 8/18/2023
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId", "TargetUserId", "bHardMute"})
public class EOS_Lobby_HardMuteMemberOptions extends Structure {
	public static final int EOS_LOBBY_HARDMUTEMEMBER_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_HARDMUTEMEMBER_API_LATEST. */
	public int ApiVersion;
	/** The ID of the lobby */
	public String LobbyId;
	/** The Product User ID of the local user requesting the hard mute; this user must be the lobby owner */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the lobby member to hard mute */
	public EOS_ProductUserId TargetUserId;
	/** TargetUserId hard mute status (mute on or off) */
	public int bHardMute;

	public EOS_Lobby_HardMuteMemberOptions() {
		super();
		ApiVersion = EOS_LOBBY_HARDMUTEMEMBER_API_LATEST;
	}

	public EOS_Lobby_HardMuteMemberOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_HardMuteMemberOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_HardMuteMemberOptions implements Structure.ByValue {
	}
}