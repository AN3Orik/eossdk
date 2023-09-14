/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "bIsNetworkActive"})
public class EOS_AntiCheatServer_SetClientNetworkStateOptions extends Structure {
	public static int EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value describing the remote user (e.g. a player object pointer) */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** True if the network is functioning normally, false if temporarily interrupted */
	public int bIsNetworkActive;

	public EOS_AntiCheatServer_SetClientNetworkStateOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_SETCLIENTNETWORKSTATE_API_LATEST;
	}

	public EOS_AntiCheatServer_SetClientNetworkStateOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_SetClientNetworkStateOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_SetClientNetworkStateOptions implements Structure.ByValue {
	}
}