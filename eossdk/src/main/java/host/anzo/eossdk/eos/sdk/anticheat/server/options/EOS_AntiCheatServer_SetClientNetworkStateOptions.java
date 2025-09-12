package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "IsNetworkActive"})
public class EOS_AntiCheatServer_SetClientNetworkStateOptions extends Structure {
	public static int EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value describing the remote user (e.g. a player object pointer) */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** {@link EOS_Bool#EOS_TRUE} if the network is functioning normally, {@link EOS_Bool#EOS_FALSE} if temporarily interrupted */
	public EOS_Bool IsNetworkActive;

	public EOS_AntiCheatServer_SetClientNetworkStateOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST;
	}

	public EOS_AntiCheatServer_SetClientNetworkStateOptions(EOS_AntiCheatCommon_ClientHandle clientHandle, boolean isNetworkActive) {
		this();
		ClientHandle = clientHandle;
		IsNetworkActive = EOS_Bool.of(isNetworkActive);
	}

	public EOS_AntiCheatServer_SetClientNetworkStateOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_SetClientNetworkStateOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_SetClientNetworkStateOptions implements Structure.ByValue {
	}
}