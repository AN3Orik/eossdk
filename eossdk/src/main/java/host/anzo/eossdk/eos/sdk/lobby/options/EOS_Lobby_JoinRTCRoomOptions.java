package host.anzo.eossdk.eos.sdk.lobby.options;

/**
 * @author ANZO
 * @since 2/26/2025
 */

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.*;

/**
 * Input parameters for the EOS_Lobby_JoinRTCRoom function.
 * @author Anton Lasevich
 * @since 2/26/2025
 */
@FieldOrder({"ApiVersion", "LobbyId", "LocalUserId", "LocalRTCOptions"})
public class EOS_Lobby_JoinRTCRoomOptions extends Structure {
	/** The most recent version of the EOS_Lobby_JoinRTCRoom API. */
	private static final int EOS_LOBBY_JOINRTCROOM_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_JOINRTCROOM_API_LATEST}. */
	public int ApiVersion;
	/** The ID of the lobby to join the RTC Room of */
	public String LobbyId;
	/** The Product User ID of the local user in the lobby */
	public EOS_ProductUserId LocalUserId;
	/**
	 * Allows the local application to set local audio options for the RTC Room if it is enabled.
	 * Only updates audio options when explicitly set; does not provide defaults.
	 */
	public EOS_Lobby_LocalRTCOptions.ByReference LocalRTCOptions;

	public EOS_Lobby_JoinRTCRoomOptions() {
		super();
		ApiVersion = EOS_LOBBY_JOINRTCROOM_API_LATEST;
	}

	public EOS_Lobby_JoinRTCRoomOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_JoinRTCRoomOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_JoinRTCRoomOptions implements Structure.ByValue {
	}
}