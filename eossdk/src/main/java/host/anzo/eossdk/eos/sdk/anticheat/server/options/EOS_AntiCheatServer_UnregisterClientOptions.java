package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link host.anzo.eossdk.eos.sdk.EOSLibrary#EOS_AntiCheatServer_UnregisterClient} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle"})
public class EOS_AntiCheatServer_UnregisterClientOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatServer_UnregisterClient API. */
	public static int EOS_ANTICHEATSERVER_UNREGISTERCLIENT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATSERVER_UNREGISTERCLIENT_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value describing the remote user, as previously passed to RegisterClient */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;

	public EOS_AntiCheatServer_UnregisterClientOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_UNREGISTERCLIENT_API_LATEST;
	}

	public EOS_AntiCheatServer_UnregisterClientOptions(EOS_AntiCheatCommon_ClientHandle clientHandle) {
		this();
		ClientHandle = clientHandle;
	}

	public EOS_AntiCheatServer_UnregisterClientOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_UnregisterClientOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_UnregisterClientOptions implements Structure.ByValue {
	}
}