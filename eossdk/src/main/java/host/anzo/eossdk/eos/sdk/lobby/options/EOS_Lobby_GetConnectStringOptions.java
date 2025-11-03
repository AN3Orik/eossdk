package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

/**
 * Input parameters for the {@link EOSLibrary#EOS_Lobby_GetConnectString} function.
 * @author Anton Lasevich
 * @since 3/11/2025
 */
@FieldOrder({"ApiVersion", "LocalUserId", "LobbyId"})
public class EOS_Lobby_GetConnectStringOptions extends Structure {
	/** The most recent version of the EOS_Lobby_GetConnectString API. */
	public static final int EOS_LOBBY_GETCONNECTSTRING_API_LATEST = 5;

	/** API Version: Set this to {@link #EOS_LOBBY_GETCONNECTSTRING_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user requesting the connection string generated from the lobby; this user must currently own the lobby */
	public EOS_ProductUserId LocalUserId;
	/** The ID of the lobby to generate a connection string for */
	public String LobbyId;

	public EOS_Lobby_GetConnectStringOptions() {
		super();
		ApiVersion = EOS_LOBBY_GETCONNECTSTRING_API_LATEST;
	}

	public EOS_Lobby_GetConnectStringOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_GetConnectStringOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_GetConnectStringOptions implements Structure.ByValue {
	}
}