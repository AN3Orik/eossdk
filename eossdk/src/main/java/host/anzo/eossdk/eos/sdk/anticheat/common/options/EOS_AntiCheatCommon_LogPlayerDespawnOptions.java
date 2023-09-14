/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "DespawnedPlayerHandle"})
public class EOS_AntiCheatCommon_LogPlayerDespawnOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERDESPAWN_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCOMMON_LOGPLAYERDESPAWN_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle DespawnedPlayerHandle;

	public EOS_AntiCheatCommon_LogPlayerDespawnOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERDESPAWN_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerDespawnOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerDespawnOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerDespawnOptions implements Structure.ByValue {
	}
}