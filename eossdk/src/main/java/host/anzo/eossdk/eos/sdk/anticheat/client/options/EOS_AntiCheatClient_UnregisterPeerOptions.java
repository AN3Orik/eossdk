package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatClient_UnregisterPeer} function.
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "PeerHandle"})
public class EOS_AntiCheatClient_UnregisterPeerOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatClient_UnregisterPeer API. */
	public static final int EOS_ANTICHEATCLIENT_UNREGISTERPEER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_UNREGISTERPEER_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value describing the remote user, as previously passed to EOS_AntiCheatClient_RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle PeerHandle;

	public EOS_AntiCheatClient_UnregisterPeerOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_UNREGISTERPEER_API_LATEST;
	}

	public EOS_AntiCheatClient_UnregisterPeerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_UnregisterPeerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_UnregisterPeerOptions implements Structure.ByValue {
	}
}