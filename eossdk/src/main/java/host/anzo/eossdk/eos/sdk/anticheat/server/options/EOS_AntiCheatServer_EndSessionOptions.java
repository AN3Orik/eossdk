package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_EndSession} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_AntiCheatServer_EndSessionOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatServer_EndSession API. */
	public static int EOS_ANTICHEATSERVER_ENDSESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATSERVER_ENDSESSION_API_LATEST}. */
	public int ApiVersion;

	public EOS_AntiCheatServer_EndSessionOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_ENDSESSION_API_LATEST;
	}

	public EOS_AntiCheatServer_EndSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_EndSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_EndSessionOptions implements Structure.ByValue {
	}
}