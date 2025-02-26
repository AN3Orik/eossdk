package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.*;

/**
 * @author Anton Lasevich
 * @since 2/26/2025
 */
@FieldOrder({"ApiVersion"})
public class EOS_AntiCheatClient_Reserved01Options extends Structure {
	public static final int EOS_ANTICHEATCLIENT_RESERVED01_API_LATEST = 1;
	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_RESERVED01_API_LATEST}. */
	public int ApiVersion;

	public EOS_AntiCheatClient_Reserved01Options() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_RESERVED01_API_LATEST;
	}

	public EOS_AntiCheatClient_Reserved01Options(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_Reserved01Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_Reserved01Options implements Structure.ByValue {
	}
}