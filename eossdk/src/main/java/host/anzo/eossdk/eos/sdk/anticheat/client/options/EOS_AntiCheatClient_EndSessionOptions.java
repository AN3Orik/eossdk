package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatClient_EndSession} function.
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_AntiCheatClient_EndSessionOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatClient_EndSession API. */
	public static final int EOS_ANTICHEATCLIENT_ENDSESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_ENDSESSION_API_LATEST}. */
	public int ApiVersion;

	public EOS_AntiCheatClient_EndSessionOptions() {
		super();
	}

	public EOS_AntiCheatClient_EndSessionOptions(Pointer peer) {
		super(peer);
		ApiVersion = EOS_ANTICHEATCLIENT_ENDSESSION_API_LATEST;
	}

	public static class ByReference extends EOS_AntiCheatClient_EndSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_EndSessionOptions implements Structure.ByValue {
	}
}