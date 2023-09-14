package host.anzo.eossdk.eos.sdk.lobby.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/17/2023
 */
@FieldOrder({"ApiVersion", "AttrKey"})
public class EOS_LobbyDetails_CopyAttributeByKeyOptions extends Structure {
	public static final int EOS_LOBBYDETAILS_COPYATTRIBUTEBYKEY_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBYDETAILS_COPYATTRIBUTEBYKEY_API_LATEST. */
	public int ApiVersion;

	/** Name of the attribute */
	public String AttrKey;

	public EOS_LobbyDetails_CopyAttributeByKeyOptions() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_COPYATTRIBUTEBYKEY_API_LATEST;
	}

	public EOS_LobbyDetails_CopyAttributeByKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_LobbyDetails_CopyAttributeByKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_CopyAttributeByKeyOptions implements Structure.ByValue {
	}
}