package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@Deprecated
@FieldOrder({"ApiVersion", "OutMessageLength"})
public class EOS_AntiCheatClient_PollStatusOptions extends Structure {
	public static final int EOS_ANTICHEATCLIENT_POLLSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCLIENT_POLLSTATUS_API_LATEST. */
	public int ApiVersion;
	/** The size of OutMessage in bytes. Recommended size is 256 bytes. */
	public int OutMessageLength;
	public EOS_AntiCheatClient_PollStatusOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_POLLSTATUS_API_LATEST;
	}
	public EOS_AntiCheatClient_PollStatusOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_PollStatusOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_PollStatusOptions implements Structure.ByValue {
	}
}