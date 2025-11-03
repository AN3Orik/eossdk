package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

/**
 * Input parameters for the {@link EOSLibrary#EOS_Lobby_GetConnectString} function.
 * @author Anton Lasevich
 * @since 3/11/2025
 */
@FieldOrder({"ApiVersion", "ConnectString"})
public class EOS_Lobby_ParseConnectStringOptions extends Structure {
	/** The most recent version of the EOS_Lobby_ParseConnectString API. */
	public static final int EOS_LOBBY_PARSECONNECTSTRING_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_LOBBY_PARSECONNECTSTRING_API_LATEST}. */
	public int ApiVersion;
	/** The connection string to parse */
	public String ConnectString;

	public EOS_Lobby_ParseConnectStringOptions() {
		super();
		ApiVersion = EOS_LOBBY_PARSECONNECTSTRING_API_LATEST;
	}

	public EOS_Lobby_ParseConnectStringOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_ParseConnectStringOptions implements Structure.ByReference {
	}
	public static class ByValue extends EOS_Lobby_ParseConnectStringOptions implements Structure.ByValue {
	}
}